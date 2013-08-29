/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteles.controller;

import com.opensymphony.xwork2.ActionContext;
import hoteles.model.Hoteles;
import hoteles.model.Clientes;
import hoteles.model.Empleados;
import hoteles.model.Reserva;
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
    Reserva reserva = new Reserva();
    
    int idHotel=0;

    
    
    ArrayList<Clientes> listaClientes = new ArrayList();
    ArrayList<Hoteles> listaHoteles = new ArrayList();
    ArrayList<Empleados> listaEmpleados = new ArrayList();
    
    HotelesAd hotelesAd = new HotelesAd();
    
    String msj = "Buenos dias";
    
    @Override
    public Empleados getModel() {
        return empleado;
    }
    
    
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    
    public String getMsj() {
        return msj;
    }
    
    public Reserva getReserva(){
        return reserva;
    }
    
    public void setReserva(Reserva _reserva){
        this.reserva = _reserva;        
    }
    
    public ArrayList<Clientes> getListaClientes(){
        return listaClientes;
    }
    
    public ArrayList<Hoteles> getListaHoteles(){
        return listaHoteles;
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
    
    public String ListaHoteles()
    {
        //List<Usuario> listClientes=null;
        try
        {
            listaHoteles = hotelesAd.ListaHoteles();
        }
        catch(Exception e)
        {
            msj = "Error al consultar por los usuarios.";
        }
        return "fin";
    }
    
    public String goCliente(){
        return "exito";
    }
    
    public String goReserva(){
        listaHoteles = hotelesAd.ListaHoteles();
        listaClientes = hotelesAd.ListaClientes();
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
