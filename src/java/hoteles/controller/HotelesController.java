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
    Clientes cliente = new Clientes();
    
    HotelesAd hotelesAd = new HotelesAd();
    
    String msj = "";
    
    @Override
    public Empleados getModel() {
        return empleado;
    }
    
    
    public String Valida()
    {
        try{
            System.out.println("ENtra");
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
    
    public String RegCliente(){
        try{
        boolean est = hotelesAd.AgregarCliente(cliente);
        if(est){
        msj = "Insercion con exito";
        return "exito";
        }else{
            msj = "No se inserto el usuario";
            return "fallo";}
        }catch(Exception ex){msj ="Error al insertar el empleado";return "fallo";}
        
    }
    
    public String goCliente(){
        return "exito";
    }
    
    public void setEmpleado(Empleados _empleado) {
        this.empleado = _empleado;
    }
 
    public Empleados getEmpleado() {
        return empleado;
    }
    
    public void setCliente(Clientes _cliente) {
        this.cliente = _cliente;
    }
 
    public Clientes getCliente() {
        return cliente;
    }
    
}
