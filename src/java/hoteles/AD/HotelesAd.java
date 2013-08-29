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
import hoteles.model.Clientes;


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
            System.out.println("ESTE ES EL ERROR!!!!"+ex.toString());
            return null;
            
        }
    }
    
    @Override
    public List<Empleados> ListaUsuarios()
    {
        try{
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
        List<Empleados> emp;
        emp =sesion.createQuery("from Empleados").list();
        //_hoteles.setHoteless(h);
        //sesion.save(h);
        transaccion.commit();
          
            return emp;
        }
        catch(Exception ex)
        {
            String x ="";
            return null;
        }
    }
    
    @Override
    public ArrayList<Hoteles> ListaHoteles()
    {
        try{
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
        ArrayList<Hoteles> h;
        h =(ArrayList<Hoteles>)sesion.createQuery("from Hoteles").list();
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
    
    @Override
    public boolean AgregarCliente(Clientes _cliente)
    {
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaccion = sesion.beginTransaction();
            sesion.save(_cliente);
            transaccion.commit();
            return true;
        }catch(Exception ex){System.out.println("Error insertando cliente: "+ex.getMessage());return false;}
    }
    
    @Override
    public ArrayList<Clientes> ListaClientes()
    {
        try{
            Session sesionl;
            Transaction transac;
            sesionl = HibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Clientes>)sesionl.createQuery("from Clientes").list();
            }
        catch(Exception ex){return null;}
    }
    
    
    
    
    
    
}
