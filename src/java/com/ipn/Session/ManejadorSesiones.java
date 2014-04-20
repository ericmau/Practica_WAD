package com.ipn.Session;

import com.ipn.modelo.Beans.Alumnos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Diego
 */
public class ManejadorSesiones {
 
    //MODIFICAR PARA QUE PUEDA SUBIR UN OBJETO
    
    public static final String NOMBRE="nombre";
    public static final String ID="id";
    
    public void createSession(HttpServletRequest request,HttpServletResponse response,
            String nombreU)
    {
        HttpSession s=request.getSession(true);
        s.setAttribute(NOMBRE, nombreU);
    }
    
    public String returnName(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession s=request.getSession(true);
        return s.getAttribute(NOMBRE).toString();
        
    }
    
    public void createSession(HttpServletRequest request,HttpServletResponse response,
            Alumnos a)
    {
        HttpSession s=request.getSession(true);
        s.setAttribute(NOMBRE, a.getNombre());
        s.setAttribute(ID, a.getIdAlumnos());
    }
    
    public void removeSession(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession s=request.getSession(true);
        s.removeAttribute(NOMBRE);
        s.removeAttribute(ID);
        if(s!=null)
        {
            s.invalidate();
        }
    }
    
    public boolean isSession(HttpServletRequest request)
    {
        HttpSession s=request.getSession(false);
        if(s==null)
        {return false;}
        else
            return s.getAttribute(NOMBRE)!=null;
    }
}
