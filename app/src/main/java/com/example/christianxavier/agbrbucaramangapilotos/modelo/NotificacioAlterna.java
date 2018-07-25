package com.example.christianxavier.agbrbucaramangapilotos.modelo;

/**
 * Created by christianxavier on 20/07/2017.
 */

public class NotificacioAlterna {

    private String motivo;
    private String enlace;

    public NotificacioAlterna() {
    }

    public NotificacioAlterna(String motivo, String enlace) {
        this.motivo = motivo;
        this.enlace = enlace;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
