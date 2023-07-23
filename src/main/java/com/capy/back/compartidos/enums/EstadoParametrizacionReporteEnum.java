package com.capy.back.compartidos.enums;

public enum EstadoParametrizacionReporteEnum {

    ACTIVO("ACTIVO"),
    INACTIVO("INACTIVO");

    private final String estado;

    EstadoParametrizacionReporteEnum(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
