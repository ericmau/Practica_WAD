package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author eric
 */

// Bean para los alumnos
@Entity
public class Alumnos implements Serializable {
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idAlumnos;
        private String Nombre;
        private String Paterno;
        private String Materno;
        private String email;
        private byte[] foto;
        private String tipoFoto;
        
        // Lo siguiente es para relacion con la tabla Carrera, es de "muchos a uno"
        @JoinColumn(name = "Carrera_idCarrera",referencedColumnName = "idCarrera",
        nullable = false)
        @ManyToOne(optional = false)
        private  Carrera Carrera_isCarrera;
        
        // Lo siguiente es para crear la relacion con la tabla Carrera
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "USER_GROUP", 
           joinColumns = { @JoinColumn(name = "userid") }, 
           inverseJoinColumns = { @JoinColumn(name = "groupid") })
        private Collection<Materia> materias;

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
     * @return the Carrera_isCarrera
     */
    public Carrera getCarrera_isCarrera() {
        return Carrera_isCarrera;
    }

    /**
     * @param Carrera_isCarrera the Carrera_isCarrera to set
     */
    public void setCarrera_isCarrera(Carrera Carrera_isCarrera) {
        this.Carrera_isCarrera = Carrera_isCarrera;
    }

    /**
     * @return the materias
     */
    @ManyToMany
    public Collection<Materia> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(Collection<Materia> materias) {
        this.materias = materias;
    }
        
    
}