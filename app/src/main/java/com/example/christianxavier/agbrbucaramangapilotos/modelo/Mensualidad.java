package com.example.christianxavier.agbrbucaramangapilotos.modelo;

/**
 * Created by christianxavier on 20/07/2017.
 */

public class Mensualidad {

    private String nombres;
    private String apodo;
    private String codigo;
    private String estado;
    private String fallas;
    private String mes;
    private String falla1;
    private String falla2;
    private String falla3;
    private String otros;

    public Mensualidad() {
    }

    public Mensualidad(String nombres, String apodo, String codigo, String estado, String fallas, String mes, String falla1, String falla2, String falla3, String otros) {
        this.nombres = nombres;
        this.apodo = apodo;
        this.codigo = codigo;
        this.estado = estado;
        this.fallas = fallas;
        this.mes = mes;
        this.falla1 = falla1;
        this.falla2 = falla2;
        this.falla3 = falla3;
        this.otros = otros;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFallas() {
        return fallas;
    }

    public void setFallas(String fallas) {
        this.fallas = fallas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFalla1() {
        return falla1;
    }

    public void setFalla1(String falla1) {
        this.falla1 = falla1;
    }

    public String getFalla2() {
        return falla2;
    }

    public void setFalla2(String falla2) {
        this.falla2 = falla2;
    }

    public String getFalla3() {
        return falla3;
    }

    public void setFalla3(String falla3) {
        this.falla3 = falla3;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }
}
