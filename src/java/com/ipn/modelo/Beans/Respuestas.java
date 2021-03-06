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
    private String RespuestaA;
    private String RespuestaB;
    private String RespuestaC;
    private Character RCorrecta;
    
    // Relacion con la tabla Preguntas ""OneToOne
     @OneToOne(optional=false, mappedBy="respuesta")
     private Preguntas pregunta;

    @Override
    public String toString() {
        return "Respuestas{" + "idRespuestas=" + idRespuestas + ", RespuestaA=" + RespuestaA + ", RespuestaB=" + RespuestaB + ", RespuestaC=" + RespuestaC + ", RCorrecta=" + RCorrecta + ", pregunta=" + pregunta + '}';
    }

    /**
     * @return the idRespuestas
     */
    public int getIdRespuestas() {
        return idRespuestas;
    }

    /**
     * @param idRespuestas the idRespuestas to set
     */
    public void setIdRespuestas(int idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    /**
     * @return the RespuestaA
     */
    public String getRespuestaA() {
        return RespuestaA;
    }

    /**
     * @param RespuestaA the RespuestaA to set
     */
    public void setRespuestaA(String RespuestaA) {
        this.RespuestaA = RespuestaA;
    }

    /**
     * @return the RespuestaB
     */
    public String getRespuestaB() {
        return RespuestaB;
    }

    /**
     * @param RespuestaB the RespuestaB to set
     */
    public void setRespuestaB(String RespuestaB) {
        this.RespuestaB = RespuestaB;
    }

    /**
     * @return the RespuestaC
     */
    public String getRespuestaC() {
        return RespuestaC;
    }

    /**
     * @param RespuestaC the RespuestaC to set
     */
    public void setRespuestaC(String RespuestaC) {
        this.RespuestaC = RespuestaC;
    }

    /**
     * @return the RCorrecta
     */
    public Character getRCorrecta() {
        return RCorrecta;
    }

    /**
     * @param RCorrecta the RCorrecta to set
     */
    public void setRCorrecta(Character RCorrecta) {
        this.RCorrecta = RCorrecta;
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
