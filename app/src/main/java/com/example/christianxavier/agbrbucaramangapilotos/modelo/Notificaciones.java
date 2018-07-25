package com.example.christianxavier.agbrbucaramangapilotos.modelo;

/**
 * Created by christianxavier on 20/07/2017.
 */

public class Notificaciones {

    private String id;
    private String nombre;
    private String contenido;
    private String evento;

    public Notificaciones() {
    }

    public Notificaciones(String id, String nombre, String contenido, String evento) {
        this.id = id;
        this.nombre = nombre;
        this.contenido = contenido;
        this.evento = evento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
}
