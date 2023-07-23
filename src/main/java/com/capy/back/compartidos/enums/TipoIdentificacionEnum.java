package com.capy.back.compartidos.enums;

public enum TipoIdentificacionEnum {

    TI("TI"),
    CC("CC"),
    CE("CE");

    private final String tipoIdentificacion;

    TipoIdentificacionEnum(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }
}
