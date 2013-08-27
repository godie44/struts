/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteles.controller;

import com.opensymphony.xwork2.ActionContext;
import hoteles.model.Hoteles;
import hoteles.model.Clientes;
import hoteles.model.Empleados;
import hoteles.AD.HotelesAd;

import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

/**
 *
 * @author diego
 */
public class HotelesController implements ModelDriven<Empleados>{
    
    Map sesionVar = ActionContext.getContext().getSession();
    Hoteles hotel = new Hoteles();
    Empleados empleado = new Empleados();
    
    HotelesAd hotelesAd = new HotelesAd();
    
    String msj = "";
    
    @Override
    public Empleados getModel() {
        return empleado;
    }
    
    
    public String Valida()
    {
        try{
        Empleados emp = hotelesAd.VerificaUsuario(empleado);
        if(emp != null)
        {
        sesionVar.put("empleado", empleado.getUsuario()); 
        msj = "Bienvenido al Sistema de administracion Hotelera.";
        return "exito";}
        else{
            msj = "No se encontro un usuario con esas credenciales";
            return "error";}
        }catch(Exception ex)
        {System.out.println("AQUI ESTA EL ERROR!!!!!------: "+ex.getMessage());
        return "error";}
    }
    
    public String RegEmpleado(){
        try{
        hotelesAd.Agregar(empleado);
        }catch(Exception ex){msj ="Error al insertar el empleado";}
        return "exito";
    }
    
    public String goReservar(){
        return "exito";
    }
    
}
