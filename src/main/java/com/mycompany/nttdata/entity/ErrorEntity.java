package com.mycompany.nttdata.entity;

public class ErrorEntity {

    private String codigo;
    private String mensaje;

    public ErrorEntity(String codigoCons, String mensajeCons) {
        codigo = codigoCons;
        mensaje = mensajeCons;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
