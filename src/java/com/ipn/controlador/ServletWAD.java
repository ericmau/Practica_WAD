package com.ipn.controlador;

import com.ipn.Session.ManejadorSesiones;
import com.ipn.modelo.Beans.Alumnos;
import com.ipn.modelo.Beans.Evaluacion;
import com.ipn.modelo.Beans.Materia;
import com.ipn.modelo.Beans.Preguntas;
import com.ipn.modelo.Beans.Respuestas;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class ServletWAD extends HttpServlet {
    private Alumnos a;
    EntityManagerFactory emf;
    EntityManager em;
    ManejadorSesiones sesion;
    
    public void initServlet()
    {
        a=null;
        emf=(EntityManagerFactory)getServletContext().getAttribute("emf");
        em = emf.createEntityManager();
        sesion = new ManejadorSesiones();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        initServlet();
        // Aqui va toda la logica del negocio, usaremos el atributo "accion" para ver que se tiene que hacer
        switch (accion) {
            case "Ingresar":
                if((a=em.find(Alumnos.class,Integer.parseInt(request.getParameter("password"))))==null)
                {muestraError(request,response);}
                else
                {
                    if(sesion.isSession(request)==false)
                    {
                        sesion.createSession(request, response, a);
                    }
                    else
                    {
                        sesion.removeSession(request, response);
                        sesion.createSession(request, response, a);
                    }
                    muestraIndex(request,response);
                }
                break;
            case "inicio":
                if(sesion.isSession(request))
                {
                    muestraIndex(request, response);
                }
                else
                {
                    muestraError(request, response);
                }
                break;
            case "materias":
                if(sesion.isSession(request))
                {
                    muestraMaterias(request,response);
                }
                else
                {
                    muestraError(request, response);
                }
                break;
            case "evaluar":
                if(sesion.isSession(request))
                {
                    muestraPreguntas(request,response);
                }
                else
                {
                    muestraError(request, response);
                }
                break;
            case "finalizado":
                if(sesion.isSession(request))
                {
                    muestraRespuestas(request,response);
                }
                else
                {
                    muestraError(request, response);
                }
                break;
            default:
                muestraError(request,response);
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void muestraMaterias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
        System.out.println("LISTA MATERIAS");
        // Preparar entidad
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        a=em.find(Alumnos.class,sesion.returnID(request, response));
        List materias=a.getMaterias();
        //em.persist(c);
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        request.setAttribute("materias", materias);
        request.getRequestDispatcher("/listaMaterias.jsp").forward(request, response);
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
        }
    }

    private void muestraPreguntas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        System.out.println("MUESTRA CUESTIONARIO");
        // Preparar entidad
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        a=em.find(Alumnos.class,sesion.returnID(request, response));
        Materia m=em.find(Materia.class,Integer.parseInt(request.getParameter("mat")));
        List evaluacion=m.getEvaluacion();
        Evaluacion e=(Evaluacion) evaluacion.get(0);
        List preguntas = e.getPreguntas();
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        request.setAttribute("mm", m);
        request.setAttribute("preguntas", preguntas);
        request.getRequestDispatcher("/Cuestionario.jsp").forward(request, response);
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
        }
    }

    private void muestraRespuestas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        System.out.println("MUESTRA RESPUESTAS");
        // Preparar entidad
        // Empezar transaccion
        em.getTransaction().begin();
        // Guardar entidad
        a=em.find(Alumnos.class,sesion.returnID(request, response));
        String seleccion1=request.getParameter("seleccion1");
        String seleccion2=request.getParameter("seleccion2");
        String seleccion3=request.getParameter("seleccion3");
        int correctas=0;
        Materia m=em.find(Materia.class,Integer.parseInt(request.getParameter("mat")));
        List evaluacion=m.getEvaluacion();
        Evaluacion e=(Evaluacion) evaluacion.get(0);
        List<Preguntas> preguntas = e.getPreguntas();
        for(Preguntas p: preguntas)
        {
            if(seleccion1.equals(p.getRespuesta().getRCorrecta().toString()))
            {
            
            }
            if(seleccion2.equals(p.getRespuesta().getRCorrecta().toString()))
            {
            
            }
            if(seleccion3.equals(p.getRespuesta().getRCorrecta().toString()))
            {
            
            }
        }
        // Hacer un commit
        em.getTransaction().commit();
        // Cerrar coneccion
        request.setAttribute("mm", m);
        request.setAttribute("preguntas", preguntas);
        request.getRequestDispatcher("/Cuestionario.jsp").forward(request, response);
        }finally{
            if(em.getTransaction().isActive())
            {   em.getTransaction().rollback();}
            em.close();
        }
    }

    private void muestraError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("de", "SevletWAD");
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    private void muestraIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
