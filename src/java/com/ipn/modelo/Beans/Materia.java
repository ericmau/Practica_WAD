package com.ipn.modelo.Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Diego
 */

// Bean para las materias
@Entity
public class Materia implements Serializable {
    
    // Atributos de la tabla Carrera
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idMateria;
        private String Nombre;
        private int Creditos;
    
    // Lo siguiente es para crear la relacion "ManyToMany" con la tabla Materia
        @ManyToMany(fetch = FetchType.LAZY,mappedBy = "materias")
        private List<Alumnos> alummnos;
    
}
