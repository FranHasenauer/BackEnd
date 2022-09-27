package com.portfolio.Fran.Security.Model;

import javax.validation.constraints.NotBlank;

public class DtoExperienciaLaboral {

    @NotBlank
    private String nombreEmpresa;
    private String fechaIn;
    private String fechaOut;
    private String puestoEmpresa;
    private String domicilioEmpresa;
    private String descripcionEmpresa;
    private String urlEmpresa;

    //Constructor 
    public DtoExperienciaLaboral() {
    }

    public DtoExperienciaLaboral(String nombreEmpresa, String fechaIn, String fechaOut, String desempeñoEmpresa, String domicilioEmpresa, String descripcionEmpresa, String urlEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.puestoEmpresa = desempeñoEmpresa;
        this.domicilioEmpresa = domicilioEmpresa;
        this.descripcionEmpresa = descripcionEmpresa;
        this.urlEmpresa = urlEmpresa;
    }
    //Getters Setters

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(String fechaIn) {
        this.fechaIn = fechaIn;
    }

    public String getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(String fechaOut) {
        this.fechaOut = fechaOut;
    }

    public String getPuestoEmpresa() {
        return puestoEmpresa;
    }

    public void setPuestoEmpresa(String puestoEmpresa) {
        this.puestoEmpresa = puestoEmpresa;
    }

    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }

    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public String getUrlEmpresa() {
        return urlEmpresa;
    }

    public void setUrlEmpresa(String urlEmpresa) {
        this.urlEmpresa = urlEmpresa;
    }

   

}
