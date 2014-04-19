
package com.ipn.modelo.Beans;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @Basic(optional = true)
    private String Evaluacioncol;
    
    // Lo siguiente es para relacion con la tabla Materia, es de "muchos a uno"
        @ManyToOne(optional = false)
        @JoinColumn(name = "Materia_idMateria",referencedColumnName = "idMateria",
        nullable = false)
        private  Materia M;
        
         // Lo siguiente es para crear la relacion con la tabla Evaluacion
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
        private List<Preguntas> preguntas;

    @Override
    public String toString() {
        return "Evaluacion{" + "idEvaluacion=" + getIdEvaluacion() + ", Evaluacioncol=" + getEvaluacioncol() + '}';
    }

    /**
     * @return the idEvaluacion
     */
    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    /**
     * @param idEvaluacion the idEvaluacion to set
     */
    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    /**
     * @return the Evaluacioncol
     */
    public String getEvaluacioncol() {
        return Evaluacioncol;
    }

    /**
     * @param Evaluacioncol the Evaluacioncol to set
     */
    public void setEvaluacioncol(String Evaluacioncol) {
        this.Evaluacioncol = Evaluacioncol;
    }

    /**
     * @return the M
     */
    public Materia getM() {
        return M;
    }

    /**
     * @param M the M to set
     */
    public void setM(Materia M) {
        this.M = M;
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
