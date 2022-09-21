package com.portfolio.Fran.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEmpresa;
    private String fechaIn;
    private String fechaOut;
    private String puestoEmpresa;
    private String domicilioEmpresa;
    private String descripcionEmpresa;
    private String urlEmpresa;

    //Constructores
    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreEmpresa, String fechaIn, String fechaOut, String puestoEmpresa, String domicilioEmpresa, String descripcionEmpresa, String urlEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.puestoEmpresa = puestoEmpresa;
        this.domicilioEmpresa = domicilioEmpresa;
        this.descripcionEmpresa = descripcionEmpresa;
        this.urlEmpresa = urlEmpresa;
    }
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
