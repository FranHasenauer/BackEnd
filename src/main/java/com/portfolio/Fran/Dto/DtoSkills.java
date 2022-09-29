package com.portfolio.Fran.Dto;

import javax.validation.constraints.NotBlank;

public class DtoSkills {

    @NotBlank
    private String nombre;
    private int porcentaje;

    //Constructor
    public DtoSkills() {
    }

    public DtoSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
