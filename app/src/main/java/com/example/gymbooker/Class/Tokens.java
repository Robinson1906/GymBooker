package com.example.gymbooker.Class;

import java.io.Serializable;

public class Tokens implements Serializable {
    private int idToken;
    private String theToken;
    private String fVencimiento;
    private String fCreacion;
    private boolean isLimited;

    public Tokens(int idToken, String theToken, String fVencimiento, String fCreacion, boolean isLimited) {
        this.idToken = idToken;
        this.theToken = theToken;
        this.fVencimiento = fVencimiento;
        this.fCreacion = fCreacion;
        this.isLimited = isLimited;
    }

    public int getIdToken() {
        return idToken;
    }public void setIdToken(int idToken) {
        this.idToken = idToken;
    }

    public String getTheToken() {
        return theToken;
    }public void setTheToken(String theToken) {
        this.theToken = theToken;
    }

    public String getfVencimiento() {
        return fVencimiento;
    } public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;

    }public String getfCreacion() {
        return fCreacion;
    } public void setfCreacion(String fCreacion) {
        this.fCreacion = fCreacion;
    }

    public boolean isLimited() {
        return isLimited;
    } public void setLimited(boolean limited) {
        isLimited = limited;
    }
}
