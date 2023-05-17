package com.example.gymbooker.Tokens;

import java.io.Serializable;

public class Tokens implements Serializable {
    private boolean used;
    private int idToken,isLimited;
    private String theToken,fVencimiento,fCreacion;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Tokens(){}

    public Tokens(int idToken, String theToken,  String fCreacion,String fVencimiento, int isLimited,boolean used) {
        this.idToken = idToken;
        this.theToken = theToken;
        this.fVencimiento = fVencimiento;
        this.fCreacion = fCreacion;
        this.isLimited = isLimited;
        this.used = used;
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

    public int isLimited(int i) {
        return isLimited;
    } public void setLimited(int limited) {
        isLimited = limited;
    }
}
