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
import hoteles.model.Reserva;


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
    
    @Override
    public Reserva Reservar(Reserva _reserva,int _idHotel,int _idEmpleado,int _idCliente)
    {
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaccion = sesion.beginTransaction();
            
            Hoteles h = (Hoteles)sesion.createQuery("from Hoteles where idHotel="+_idHotel).list().get(0);
            Empleados e = (Empleados)sesion.createQuery("from Empleados where idEmpleado="+_idEmpleado).list().get(0);
            Clientes c = (Clientes)sesion.createQuery("from Clientes where idCliente="+_idCliente).list().get(0);
            
            if(h != null && e != null && c !=null){
            
            _reserva.setHoteles(h);
            _reserva.setEmpleados(e);
            _reserva.setClientes(c);
            sesion.save(_reserva);
            transaccion.commit();
            
            
            Reserva r = (Reserva)sesion.createQuery("from Reserva where idHabitacion="+_reserva.getIdHabitacion()+" and tiempoEntrada="+_reserva.getTiempoEntrada()+"").list().get(0);
            return r;}
            else{return null;}
        }
        catch(Exception ex){
            System.out.println("ERROR:"+ ex.getMessage());
            return null;}
    }

    @Override
    public ArrayList<Habitacionxhotel> ListaHabXHotel(int _idHotel) {
        try{
            Session sesionl;
            Transaction transac;
            sesionl = HibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Habitacionxhotel>)sesionl.createQuery("from Habitacionxhotel where hoteles.idHotel="+_idHotel).list();
        }catch(Exception ex){
            return null;
        }
    }
    
    
    
    
    
}
