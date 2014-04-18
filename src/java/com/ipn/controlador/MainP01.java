package com.ipn.controlador;

import com.ipn.modelo.Beans.CentroDeTrabajo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Diego
 */
public class MainP01 {

    public static void main(String[] args) {
        
        MainP01 m = new MainP01();
        m.create(); 
        
    }

    private void create() {
        // Inicializar entity manager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Practica_WADPU");
        EntityManager em = factory.createEntityManager();
        System.out.println("PASO");
        // Preparar entidad
        CentroDeTrabajo ct = new CentroDeTrabajo();
        ct.setNombreCentroTrabajo("IPN");
        ct.setCarreras(null);
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        em.persist(ct);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        em.close();
        factory.close();
    }
}
