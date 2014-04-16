
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
        @JoinColumn(name = "idClientes",referencedColumnName = "idClientes",
        nullable = false)
        @ManyToOne(optional = false)
        private CentroDeTrabajo CentroDeTrabajo_idCentroDeTrabajo;
}
