package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Diego
 */

// Bean para el centro de trabajo
@Entity
public class CentroDeTrabajo implements Serializable{
    // Atributos de la tabla Centro de trabajo
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Basic(optional = false)
        private int idCentroDeTrabajo;
        private String nombreCentroTrabajo;
        // Lo siguiente es para crear la relacion con la tabla Carrera
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
        private Collection<Carrera> Carreras;

    @Override
    public String toString() {
        return "CentroDeTrabajo{" + "idCentroDeTrabajo=" + idCentroDeTrabajo + ", nombreCentroTrabajo=" + nombreCentroTrabajo + '}';
    }

    /**
     * @return the idCentroDeTrabajo
     */
    public int getIdCentroDeTrabajo() {
        return idCentroDeTrabajo;
    }

    /**
     * @param idCentroDeTrabajo the idCentroDeTrabajo to set
     */
    public void setIdCentroDeTrabajo(int idCentroDeTrabajo) {
        this.idCentroDeTrabajo = idCentroDeTrabajo;
    }

    /**
     * @return the nombreCentroTrabajo
     */
    public String getNombreCentroTrabajo() {
        return nombreCentroTrabajo;
    }

    /**
     * @param nombreCentroTrabajo the nombreCentroTrabajo to set
     */
    public void setNombreCentroTrabajo(String nombreCentroTrabajo) {
        this.nombreCentroTrabajo = nombreCentroTrabajo;
    }

    /**
     * @return the Carreras
     */
    public Collection<Carrera> getCarreras() {
        return Carreras;
    }

    /**
     * @param Carreras the Carreras to set
     */
    public void setCarreras(Collection<Carrera> Carreras) {
        this.Carreras = Carreras;
    }
    
}
