/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipn.modelo.Beans;

import static com.oracle.jrockit.jfr.ContentType.Address;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eric
 */

@Entity
@Table(name="Preguntas")
public class Preguntas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreguntas;
    private String Pregunta;
    
     // Lo siguiente es para relacion con la tabla Evaluacion, es de "muchos a uno"
        @ManyToOne(optional = false)
        @JoinColumn(name = "Evaluacion_idEvaluacion",referencedColumnName = "idEvaluacion",
        nullable = false)
        private Evaluacion evaluacion;
        
    // Lo siguiente es para la relacion con "OneToOne" con la tabla Respuesta
        @OneToOne(fetch=FetchType.LAZY,optional=false)
        @JoinColumn(name="Respuestas_idRespuestas",referencedColumnName = "idRespuestas")
        private Respuestas respuesta;

    @Override
    public String toString() {
        return "Preguntas{" + "idPreguntas=" + getIdPreguntas() + ", Pregunta=" + getPregunta() + '}';
    }

    /**
     * @return the idPreguntas
     */
    public int getIdPreguntas() {
        return idPreguntas;
    }

    /**
     * @param idPreguntas the idPreguntas to set
     */
    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    /**
     * @return the Pregunta
     */
    public String getPregunta() {
        return Pregunta;
    }

    /**
     * @param Pregunta the Pregunta to set
     */
    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    /**
     * @return the evaluacion
     */
    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    /**
     * @param evaluacion the evaluacion to set
     */
    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * @return the respuesta
     */
    public Respuestas getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(Respuestas respuesta) {
        this.respuesta = respuesta;
    }

   
}
