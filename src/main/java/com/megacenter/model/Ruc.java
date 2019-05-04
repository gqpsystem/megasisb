/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reyme
 */
public class Ruc {

    private String ruc;
    private String razonSocial;
    private String nombreComercial;

    private String tipo;
    private String estado;
    private String condicion;

    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;

    private String fechaInscripcion;
    private String fechaInicioActividades;
    
    private String sistEmision;
    private String actExterior;
    private String sisContabilidad;
    private String comprobanteElectronicos;
    private String emisorElectronico ;
    
    private List<String> comprobantePago = new ArrayList<>();
    private List<String> actividades = new ArrayList<>();
    private List<String> sisEmisionElectronica = new ArrayList<>();
    
    private String PLE ;
    
    private List<String> padrones = new ArrayList<>();
    public Ruc() {
    }

    public String getEmisorElectronico() {
        return emisorElectronico;
    }

    public void setEmisorElectronico(String emisorElectronico) {
        this.emisorElectronico = emisorElectronico;
    }

    
    
    public String getComprobanteElectronicos() {
        return comprobanteElectronicos;
    }

    public void setComprobanteElectronicos(String comprobanteElectronicos) {
        this.comprobanteElectronicos = comprobanteElectronicos;
    }

    
    public List<String> getPadrones() {
        return padrones;
    }

    public void setPadrones(List<String> padrones) {
        this.padrones = padrones;
    }

    
    public String getPLE() {
        return PLE;
    }

    public void setPLE(String PLE) {
        this.PLE = PLE;
    }

    
    public String getSisContabilidad() {
        return sisContabilidad;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public List<String> getSisEmisionElectronica() {
        return sisEmisionElectronica;
    }

    public void setSisEmisionElectronica(List<String> sisEmisionElectronica) {
        this.sisEmisionElectronica = sisEmisionElectronica;
    }

    
    public List<String> getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(List<String> comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
    

    public void setActividades(List<String> actividades) {
        this.actividades = actividades;
    }
    
    

    public void setSisContabilidad(String sisContabilidad) {
        this.sisContabilidad = sisContabilidad;
    }

    
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(String fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }
    
    
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getSistEmision() {
        return sistEmision;
    }

    public void setSistEmision(String sistEmision) {
        this.sistEmision = sistEmision;
    }

    public String getActExterior() {
        return actExterior;
    }

    public void setActExterior(String actExterior) {
        this.actExterior = actExterior;
    }

    public void separadorRucRazonSocial(String rucSocial) {
        int position = rucSocial.indexOf("-");
        this.ruc = rucSocial.substring(0, position);
        this.razonSocial = rucSocial.substring(position + 1, rucSocial.length());

    }

    public void setLugar(String direc) {
        String[] partes = direc.split("-");
        this.setProvincia(partes[partes.length - 2]);
        this.setDistrito(partes[partes.length - 1]);
        this.setAlinar(partes);

    }

    public void setAlinar(String[] alineamiento) {
        
        String alinar ="";
        for (int i = 0; i < alineamiento.length-2; i++) {
            alinar += alineamiento[i];
            if(i!=alineamiento.length-3){
                alinar+="-";
            }
        }
        
        String[] partes = alinar.split("\\s");
        switch (partes[partes.length - 1].toUpperCase()) {
            case "DIOS":
                this.setDireccion(alinar.substring(0 , alinar.lastIndexOf(partes[partes.length-3])));
                this.setDepartamento("MADRE DE DIOS");
                return;
            case "MARTIN":
                this.setDireccion(alinar.substring(0 , alinar.lastIndexOf(partes[partes.length-2])));
                this.setDepartamento("SAN MARTIN");
                return;
            case "LIBERTAD" :
                this.setDireccion(alinar.substring(0 , alinar.lastIndexOf(partes[partes.length-2])));
                this.setDepartamento("LA LIBERTAD");
                return;

        }
        this.setDepartamento(partes[partes.length - 1].toUpperCase());
        this.setDireccion(alinar.substring(0 , alinar.lastIndexOf(partes[partes.length-1])));
    }

}
