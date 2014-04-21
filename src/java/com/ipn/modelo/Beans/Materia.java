package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Diego
 */

// Bean para las materias
@Entity
@Table(name="Materia")
 
public class Materia implements Serializable {
    
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idMateria;
        private String Nombre;
        private int Creditos;
    
    // Lo siguiente es para crear la relacion "ManyToMany" con la tabla Alumnos
        @ManyToMany(fetch = FetchType.LAZY,mappedBy = "materias")
        private List<Alumnos> alummnos;
        
     // Lo siguiente es para crear la relacion con la tabla Evaluacion
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "M")
        private List<Evaluacion> evaluacion;

    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Creditos
     */
    public int getCreditos() {
        return Creditos;
    }

    /**
     * @param Creditos the Creditos to set
     */
    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }

    /**
     * @return the alummnos
     */
    public List<Alumnos> getAlummnos() {
        return alummnos;
    }

    /**
     * @param alummnos the alummnos to set
     */
    public void setAlummnos(List<Alumnos> alummnos) {
        this.alummnos = alummnos;
    }

    /**
     * @return the evaluacion
     */
    public List<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    /**
     * @param evaluacion the evaluacion to set
     */
    public void setEvaluacion(List<Evaluacion> evaluacion) {
        this.evaluacion = evaluacion;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", Nombre=" + Nombre + ", Creditos=" + Creditos + '}';
    }
    
}
