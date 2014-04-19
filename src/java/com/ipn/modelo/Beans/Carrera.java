
package com.ipn.modelo.Beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Diego
 */

// Bean de la tabla Carrera
@Entity
@Table(name="Carrera")
public class Carrera implements Serializable{
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idCarrera;
        private String nombreCarrera;
        private int duracion;
        // Lo siguiente es para relacion con la tabla Centro de trabajo, es de "muchos a uno"
        @ManyToOne(optional = false, fetch=FetchType.LAZY)
        @JoinColumn(name = "CentroDeTrabajo_idCentroDeTrabajo",referencedColumnName = "idCentroDeTrabajo",
        nullable = false)
        private  CentroDeTrabajo CDT;
        
         // Lo siguiente es para crear la relacion con la tabla Alumno
        /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "Carrera")
        private List<Alumnos> alumnos;*/


    @Override
    public String toString() {
        return "Carrera{" + "idCarrera=" + getIdCarrera() + ", nombreCarrera=" + getNombreCarrera() + ", duracion=" + getDuracion() + '}';
    }

    /**
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * @param idCarrera the idCarrera to set
     */
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    /**
     * @return the nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * @param nombreCarrera the nombreCarrera to set
     */
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the CDT
     */
    public CentroDeTrabajo getCDT() {
        return CDT;
    }

    /**
     * @param CDT the CDT to set
     */
    public void setCDT(CentroDeTrabajo CDT) {
        this.CDT = CDT;
    }

   
}