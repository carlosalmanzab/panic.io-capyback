package com.capy.back.reportesciudadanos.creacion.service;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoDTO;

public interface IReporteCiudadanoService {

    ResultDTO guardarReporteCiudadano(ReporteCiudadanoDTO reporteCiudadanoDTO);
}
