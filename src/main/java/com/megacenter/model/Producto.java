    
package com.megacenter.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto ;
    
    @Column(name = "codigo" , length = 100 , unique = true )
    private String codigo ; 
    
    @Column ( name = "numProducto" , length =200 )
    private String numProducto ;
    
    @Column (name = "precioCompra" , precision = 16 , scale = 2)
    private Double precioCompra ; 
    
    @Column ( name = "precioVenta" , precision = 16 , scale = 2)
    private Double precioVenta ;
    
    @Column(name = "stock" , length = 11)
    private int stock ;
    
    @Column (name = "fechaVencimiento" )
    private Date fechaVencimiento;
    
    @Column (name = "numLote" , length = 30)
    private String numLote ;
    
    @Column (name = "estado" , length = 10)
    private String estado ;
    
    @Column (name = "area" , length = 10)
    private String area ;
    
    @Column ( name  = "laboratorio" , length = 50)
    private String laboratorio;
    
    @Column (name = "recomendacion" , length = 400)
    private String recomendacion ;

    @Column ( name = "imagen" , length  = 400 )
    private String imagen ;
    
    @ManyToOne
    @JoinColumn (name = "id_categoria")
    private Categoria categoria ;
    
   
    @ManyToOne
    @JoinColumn (name = "id_dolencia")
    private Dolencia dolencia ;
    
    @ManyToOne
    @JoinColumn (name = "id_unidadmedida")
    private UnidadMedida unidadMedida ;

    public Producto() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    
    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(String numProducto) {
        this.numProducto = numProducto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

   
    
    
    public Dolencia getDolencia() {
        return dolencia;
    }

    public void setDolencia(Dolencia dolencia) {
        this.dolencia = dolencia;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
}
