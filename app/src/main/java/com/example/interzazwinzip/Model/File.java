package com.example.interzazwinzip.Model;

public class File {
    private String nombre="";
    private String descripcion="";
    private String date="";
    private Boolean directorio;

    public File(String nombre, String descripcion, String date, Boolean directorio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.date = date;
        this.directorio = directorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String items) {
        this.descripcion = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Boolean directorio) {
        this.directorio = directorio;
    }
}
