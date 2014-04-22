package com.ipn.controlador;

import com.ipn.modelo.Beans.Alumnos;
import com.ipn.modelo.Beans.Carrera;
import com.ipn.modelo.Beans.CentroDeTrabajo;
import com.ipn.modelo.Beans.Evaluacion;
import com.ipn.modelo.Beans.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Diego
 */
public class MainP01 {
        private final EntityManagerFactory factory;
        private final  EntityManager em;
    
    public MainP01()
    {
    // Inicializar entity manager
        factory = Persistence.createEntityManagerFactory("Practica_WADPU");
        em = factory.createEntityManager();
    }

    public static void main(String[] args) {
        
        MainP01 m = new MainP01();
        //Crear Centro de trabajo
        //m.createCentroDeTrabjo();
        //Crear Carrera
        //m.createCarrera();
        //Crear Materia
        //m.createMateria();
        //Crear Alumno
        //m.createAlumno(); 
        m.findAlumno();
        //Crear Evaluacion
        //m.createEvaluacion();
        
    }

    private void createCarrera() {
        try{
        System.out.println("CREA CARRERA");
        // Preparar entidad
        Carrera c = new Carrera();
        c.setNombreCarrera("ESCOM");
        c.setDuracion(5);
        
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        CentroDeTrabajo ct= em.find(CentroDeTrabajo.class, 1);
        c.setCDT(ct);
        em.persist(c);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
            factory.close();
        }
    }

    private void createMateria() {
        try{
        System.out.println("CREA MATERIA");
        // Preparar entidad
        Materia m = new Materia();
        m.setNombre("WAD");
        m.setCreditos(6);
        m.setAlummnos(null);
        m.setEvaluacion(null);
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        em.persist(m);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
            factory.close();
        }
    }

    private void createAlumno() {
        System.out.println("CREA ALUMNO");
        // Empezar transaccion
        em.getTransaction().begin();
        // Preparar entidad
        Alumnos a = new Alumnos();
        a.setNombre("Diego");
        a.setPaterno("Aguilar");
        a.setMaterno("Mayen");
        a.setEmail("d@live.com");
        Carrera c=em.find(Carrera.class, 1);
        a.setCarrera(c);
        Materia m= em.find(Materia.class, 1);
        List<Materia> l = new ArrayList<>();
        l.add(m);
        a.setMaterias(l);
        // Guardar entidad
        em.persist(a);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        em.close();
        factory.close();
    }

    private void createCentroDeTrabjo() {
        try{
        System.out.println("CREA CENTRO DE TRABAJO");
        // Empezar transaccion
        em.getTransaction().begin();
        // Preparar entidad
        CentroDeTrabajo ct = new CentroDeTrabajo();
        ct.setNombreCentroTrabajo("IPN");
        // Guardar entidad
        em.persist(ct);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
            factory.close();
        }
    }

    private void createEvaluacion() {
        try{
        System.out.println("CREA EVALUACION");
        // Empezar transaccion
        em.getTransaction().begin();
        // Preparar entidad
        Evaluacion e= new Evaluacion();
        e.setEvaluacioncol("Primera evaluacion");
        Materia m = em.find(Materia.class, 1);
        e.setM(m);
        e.setPreguntas(null);
        // Guardar entidad
        em.persist(e);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
            factory.close();
        }
    }

    private void findAlumno() {
        try{
        System.out.println("ENCUENTRA ALUMNO");
        // Empezar transaccion
        em.getTransaction().begin();
        // Preparar entidad
        Alumnos a=em.find(Alumnos.class, 1);
            System.out.println(a.getNombre()+" "+a.getPaterno());
        // Guardar entidad
        List<Materia> materias=a.getMaterias();
        System.out.println(materias.get(1).toString());
        Materia m=em.find(Materia.class,1);
            System.out.println(m.toString());
        //em.persist(c);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
            factory.close();
        }
    }
}
