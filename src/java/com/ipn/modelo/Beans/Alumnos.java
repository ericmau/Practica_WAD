package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eric
 */

// Bean para los alumnos
@Entity
@Table(name="Alumnos")
public class Alumnos implements Serializable {
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idAlumnos;
        private String Nombre;
        private String Paterno;
        private String Materno;
        private String email;
        @Basic(optional = true)
        private byte[] foto;
        @Basic(optional = true)
        private String tipoFoto;
        
        // Lo siguiente es para relacion con la tabla Carrera, es de "muchos a uno"
        @ManyToOne(optional = false, fetch=FetchType.LAZY)
        @JoinColumn(name = "Carrera_idCarrera",referencedColumnName = "idCarrera",
        nullable = false)
        private  Carrera Carrera;
        
        // Lo siguiente es para crear la relacion con la tabla Materia
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "Alumnos_has_Materia", 
        joinColumns = { 
               @JoinColumn(name = "Alumnos_idAlumnos", referencedColumnName = "idAlumnos")
        }, 
        inverseJoinColumns = { 
               @JoinColumn(name = "Materia_idMateria", referencedColumnName = "idMateria")
        }
        )
        private List<Materia> materias;

    /**
     * @return the idAlumnos
     */
    public int getIdAlumnos() {
        return idAlumnos;
    }

    /**
     * @param idAlumnos the idAlumnos to set
     */
    public void setIdAlumnos(int idAlumnos) {
        this.idAlumnos = idAlumnos;
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
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * @return the tipoFoto
     */
    public String getTipoFoto() {
        return tipoFoto;
    }

    /**
     * @param tipoFoto the tipoFoto to set
     */
    public void setTipoFoto(String tipoFoto) {
        this.tipoFoto = tipoFoto;
    }

    /**
     * @return the Carrera
     */
    public Carrera getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the materias
     */
    public List<Materia> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "idAlumnos=" + idAlumnos + ", Nombre=" + Nombre + ", Paterno=" + Paterno + ", Materno=" + Materno + ", email=" + email + '}';
    }

    
}