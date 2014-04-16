/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipn.modelo.Beans;

/**
 *
 * @author eric
 */
public class Respuestas {
    private int idRespuestas;
    private String Respuestas;

    public Respuestas() {
    }

    public int getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(int idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public String getRespuestas() {
        return Respuestas;
    }

    public void setRespuestas(String Respuestas) {
        this.Respuestas = Respuestas;
    }

    @Override
    public String toString() {
        return "Respuestas{" + "idRespuestas=" + idRespuestas + ", Respuestas=" + Respuestas + '}';
    }
    
    
}
