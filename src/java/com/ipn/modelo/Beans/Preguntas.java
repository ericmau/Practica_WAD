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
public class Preguntas {
    private int idPreguntas;
    private String Pregunta;

    public Preguntas() {
    }

    public int getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    @Override
    public String toString() {
        return "Preguntas{" + "idPreguntas=" + idPreguntas + ", Pregunta=" + Pregunta + '}';
    }
    
    
}
