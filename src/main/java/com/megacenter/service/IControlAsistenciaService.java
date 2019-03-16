package com.megacenter.service;

import java.util.List;

import com.megacenter.model.ControlAsistencia;

public interface IControlAsistenciaService {

    void registrar(ControlAsistencia asistencia);

    void modificar(ControlAsistencia asistencia);

    void eliminar (int idAsistencia);

    ControlAsistencia listarId(int idAsistencia);

    List<ControlAsistencia> listar();

}