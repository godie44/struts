/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteles.AD;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hoteles.model.Hoteles;
import hoteles.model.Empleados;
import hoteles.model.Habitacionxhotel;


/**
 *
 * @author diego
 */
public class HotelesAd implements IHoteles{

    Transaction transaccion;
    Session sesion;
    
    @Override
    public Empleados VerificaUsuario(Empleados _empleado) {
        try
        {
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transac = sesion.beginTransaction();
            
            //Empleados tmp = new Empleados();
            if(!sesion.createQuery("from Empleados where usuario ='"+_empleado.getUsuario() +"' and password ='"+_empleado.getPassword()+"'").list().isEmpty())
            {return (Empleados)sesion.createQuery("from Empleados where usuario ='"+_empleado.getUsuario() +"' and password ='"+_empleado.getPassword()+"'").list().get(0);}
            else{return null;}
        }
        catch(Exception ex)
        {
            String exc = ex.toString();
            return null;
            
        }
    }
    
    @Override
    public List<Empleados> ListaUsuarios()
    {
        List<Empleados> empleados = null;
        
        return empleados;
    }
    
    @Override
    public List<Hoteles> ListaHoteles()
    {
        try{
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
        List<Hoteles> h;
        h =sesion.createQuery("from Hoteles").list();
        //_hoteles.setHoteless(h);
        //sesion.save(h);
        transaccion.commit();
          
            return h;
        }
        catch(Exception ex)
        {
            String x ="";
            return null;
        }
    }

    @Override
    public boolean Agregar(Empleados _empleado) {
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaccion = sesion.beginTransaction();
            sesion.save(_empleado);
            transaccion.commit();
            return true;
        }
        catch(Exception ex){return false;}
    }
    
    
    
    
}
