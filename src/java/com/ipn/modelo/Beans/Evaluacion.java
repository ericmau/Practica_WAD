
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
import javax.persistence.Table;
/**
 *
 * @author eric
 */

@Entity
@Table(name="Evaluacion")
public class Evaluacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;
    private String Evaluacioncol;
    
    // Lo siguiente es para relacion con la tabla Materia, es de "muchos a uno"
        @JoinColumn(name = "Materia_idMateria",referencedColumnName = "idMateria",
        nullable = false)
        @ManyToOne(optional = false)
        private  Materia Materia_idMateria;
        
         // Lo siguiente es para crear la relacion con la tabla Evaluacion
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
        private List<Preguntas> preguntas;
    

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
        return "Evaluacion{" + "idEvaluacion=" + getIdEvaluacion() + ", Evaluacioncol=" + getEvaluacioncol() + '}';
    }

    /**
     * @return the Materia_idMateria
     */
    public Materia getMateria_idMateria() {
        return Materia_idMateria;
    }

    /**
     * @param Materia_idMateria the Materia_idMateria to set
     */
    public void setMateria_idMateria(Materia Materia_idMateria) {
        this.Materia_idMateria = Materia_idMateria;
    }

    /**
     * @return the preguntas
     */
    public List<Preguntas> getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(List<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }
    
    
    
}
