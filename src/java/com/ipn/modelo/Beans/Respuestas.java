/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipn.modelo.Beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eric
 */
@Entity
@Table(name="Respuestas")
public class Respuestas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuestas;
    private Character Respuesta;
    
    // Relacion con la tabla Preguntas ""OneToOne
     @OneToOne(optional=false, mappedBy="respuesta")
     private Preguntas pregunta;

    public Respuestas() {
    }

    public int getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(int idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public Character getRespuestas() {
        return Respuesta;
    }

    public void setRespuestas(Character Respuestas) {
        this.Respuesta = Respuestas;
    }

    @Override
    public String toString() {
        return "Respuestas{" + "idRespuestas=" + getIdRespuestas() + ", Respuestas=" + Respuestas + '}';
    }

    /**
     * @return the Respuesta
     */
    public Character getRespuesta() {
        return Respuesta;
    }

    /**
     * @param Respuesta the Respuesta to set
     */
    public void setRespuesta(Character Respuesta) {
        this.Respuesta = Respuesta;
    }

    /**
     * @return the pregunta
     */
    public Preguntas getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(Preguntas pregunta) {
        this.pregunta = pregunta;
    }
    
    
}
