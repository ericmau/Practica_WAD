
package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Diego
 */

// Bean de la tabla Carrera
@Entity
public class Carrera implements Serializable{
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idCarrera;
        private String nombreCarrera;
        private int duracion;
        // Lo siguiente es para relacion con la tabla Centro de trabajo, es de "muchos a uno"
        @JoinColumn(name = "CentroDeTrabajo_idCentroDeTrabajo",referencedColumnName = "idCentroDeTrabajo",
        nullable = false)
        @ManyToOne(optional = false)
        private  CentroDeTrabajo CentroDeTrabajo_idCentroDeTrabajo;
        
         // Lo siguiente es para crear la relacion con la tabla Alumno
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlumnos")
        private List<Alumnos> alumnos;

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
     * @return the CentroDeTrabajo_idCentroDeTrabajo
     */
    public CentroDeTrabajo getCentroDeTrabajo_idCentroDeTrabajo() {
        return CentroDeTrabajo_idCentroDeTrabajo;
    }

    /**
     * @param CentroDeTrabajo_idCentroDeTrabajo the CentroDeTrabajo_idCentroDeTrabajo to set
     */
    public void setCentroDeTrabajo_idCentroDeTrabajo(CentroDeTrabajo CentroDeTrabajo_idCentroDeTrabajo) {
        this.CentroDeTrabajo_idCentroDeTrabajo = CentroDeTrabajo_idCentroDeTrabajo;
    }

    /**
     * @return the alumnos
     */
    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
}