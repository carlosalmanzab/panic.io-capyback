package com.capy.back.reportesciudadanos.parametrizacion.service;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionDTO;
import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionOutDTO;

public interface IParametrizacionService {

    ResultDTO guardarParametrizacion(ParametrizacionDTO parametrizacionDTO);
    ParametrizacionOutDTO obtenerParametrizacion(Long id);
    ParametrizacionOutDTO actualizarParametrizacion(ParametrizacionDTO parametrizacionDTO);
    EstadoParametrizacionReporteEnum[] obtenerEstadoParametrizacion();
    ParametrizacionOutDTO obtenerParametrizacionesActivas();
    ResultDTO cambiarEstadoParametrizacion(Long id, EstadoParametrizacionReporteEnum estadoParametrizacionReporteEnum);
    Boolean existeParametrizacionActivaPorId(Long id);

}
