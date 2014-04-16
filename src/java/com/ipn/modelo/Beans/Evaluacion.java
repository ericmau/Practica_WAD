/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipn.modelo.Beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author eric
 */

@Entity
@Table(name="Evaluacion")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;
    private String Evaluacioncol;

    public Evaluacion() {
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getEvaluacioncol() {
        return Evaluacioncol;
    }

    public void setEvaluacioncol(String Evaluacioncol) {
        this.Evaluacioncol = Evaluacioncol;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "idEvaluacion=" + idEvaluacion + ", Evaluacioncol=" + Evaluacioncol + '}';
    }
    
    
    
}
