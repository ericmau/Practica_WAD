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
        @JoinColumn(name = "Evaluacion_idEvaluacion",referencedColumnName = "idEvaluacion",
        nullable = false)
        @ManyToOne(optional = false)
        private Evaluacion Evaluacion_idEvaluacion;
        
    // Lo siguiente es para la relacion con "OneToOne" con respuesta
        @OneToOne(fetch=FetchType.LAZY,optional=false)
        @JoinColumn(name="Respuestas_idRespuestas")
        private Respuestas respuesta;

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
