package com.ipn.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Diego
 */
public class ManejadorSesiones {
 
    //MODIFICAR PARA QUE PUEDA SUBIR UN OBJETO
    
    public static final String NOMBRE="nombre";
    public static final String TIPO="";
    
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
    
    /*public void createSession(HttpServletRequest request,HttpServletResponse response,
            Usuario u)
    {
        HttpSession s=request.getSession(true);
        s.setAttribute(NOMBRE, u.getNombre());
        s.setAttribute(TIPO, u.getTipo());
    }*/
    
    public void removeSession(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession s=request.getSession(true);
        s.removeAttribute(NOMBRE);
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
