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
import hoteles.model.Habitacionxhotel;
import hoteles.AD.HotelesAd;

import com.opensymphony.xwork2.ModelDriven;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author diego
 */
public class HotelesController implements ModelDriven<Empleados> {

    Map sesionVar = ActionContext.getContext().getSession();
    Hoteles hotel = new Hoteles();
    Empleados empleado = new Empleados();
    Clientes cliente = new Clientes();
    Reserva reserva = new Reserva();
    Habitacionxhotel habXHotel = new Habitacionxhotel();
    int idHotel = 0;
    String nombreHotel = "";
    String nombreEmpleado = "";
    int idEmpleado = 0;
    int idCliente = 0;
    String tiempoEntrada = "";
    String tiempoSalida = "";
    ArrayList<Clientes> listaClientes = new ArrayList();
    ArrayList<Hoteles> listaHoteles = new ArrayList();
    ArrayList<Empleados> listaEmpleados = new ArrayList();
    ArrayList<Habitacionxhotel> listaHabitaciones = new ArrayList();
    HotelesAd hotelesAd = new HotelesAd();
    String msj = "Buenos dias";

    @Override
    public Empleados getModel() {
        return empleado;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getTiempoEntrada() {
        return tiempoEntrada;
    }

    public void setTiempoEntrada(String tiempoEntrada) {
        this.tiempoEntrada = tiempoEntrada;
    }

    public String getTiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(String tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Hoteles getHotel() {
        return hotel;
    }

    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }

    public Habitacionxhotel getHabXHotel() {
        return habXHotel;
    }

    public void setHabXHotel(Habitacionxhotel habXHotel) {
        this.habXHotel = habXHotel;
    }

    public ArrayList<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public ArrayList<Habitacionxhotel> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacionxhotel> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public String getMsj() {
        return msj;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva _reserva) {
        this.reserva = _reserva;
    }

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Hoteles> getListaHoteles() {
        return listaHoteles;
    }

    public String Valida() {
        try {
            System.out.println("ENtra");
            Empleados emp = hotelesAd.VerificaUsuario(empleado);
            if (emp != null) {
                sesionVar.put("empleado", emp.getUsuario());
                sesionVar.put("idHotel", emp.getHoteles().getIdHotel());
                sesionVar.put("idEmpleado", emp.getIdEmpleado());
                sesionVar.put("hotel", emp.getHoteles().getNombre());
                msj = "Bienvenido al Sistema de administracion Hotelera.";
                return "exito";
            } else {
                msj = "No se encontro un usuario con esas credenciales";
                return "error";
            }
        } catch (Exception ex) {
            System.out.println("AQUI ESTA EL ERROR!!!!!------: " + ex.getMessage());
            return "error";
        }
    }

    public String RegEmpleado() {
        try {
            hotelesAd.Agregar(empleado);
        } catch (Exception ex) {
            msj = "Error al insertar el empleado";
        }
        return "exito";
    }

    public String RegCliente() {
        try {
            boolean est = hotelesAd.AgregarCliente(cliente);
            if (est) {
                msj = "Insercion con exito";
                return "exito";
            } else {
                msj = "No se inserto el usuario";
                return "fallo";
            }
        } catch (Exception ex) {
            msj = "Error al insertar el empleado";
            return "fallo";
        }

    }

    public String Reservar() {
        try {


            ArrayList<Reserva> resXHab = hotelesAd.ReservasXHabitacion(reserva.getIdHabitacion());
            Boolean reservada = false;
            Date hoy = new Date();

            //Verifica que la habitacion deseada no este reservada para las fechas solicitadas
            for (int i = 0; i < resXHab.size(); i++) {
                if ((reserva.getTiempoEntrada().after(resXHab.get(i).getTiempoEntrada()) && reserva.getTiempoSalida().before(resXHab.get(i).getTiempoEntrada()))
                        && (reserva.getTiempoSalida().after(resXHab.get(i).getTiempoEntrada()) && reserva.getTiempoSalida().before(resXHab.get(i).getTiempoEntrada()))
                        && (resXHab.get(i).getTiempoSalida().after(hoy))) 
                {
                    reservada = true;
                    break;
                }
            }

            if (reservada) {

                SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
                reserva.setTiempoEntrada(formato.parse(tiempoEntrada));
                reserva.setTiempoSalida(formato.parse(tiempoSalida));
                //hoy.setDate(Calendar.DATE);
                if (reserva.getTiempoEntrada().after(hoy) && reserva.getTiempoSalida().after(reserva.getTiempoEntrada())) {
                    Reserva est = hotelesAd.Reservar(reserva, (Integer) ActionContext.getContext().getSession().get("idHotel"), (Integer) ActionContext.getContext().getSession().get("idEmpleado"), idCliente);
                    if (est != null) {
                        msj = "Numero de reservacion: " + est.getIdReserva() + "<br/>"
                                + "Numero de habitacion reservada: " + est.getIdHabitacion() + "<br/>"
                                + "Fecha de ingreso: " + est.getTiempoEntrada().toString();
                        return "exito";
                    } else {
                        msj = "No se pudo realizar la reservacion, intentelo de nuevo o comuniquese con su administrador";
                        return "fallo";
                    }
                } else {
                    msj = "No se pudo realizar la reservacion, revise que las fechas administradas esten dentro del rango permitido";
                    return "error";
                }
            }else
            {
                msj = "No se pudo realizar la reservacion, la habitacion ya esta reservada para las fechas solicitadas. "+
                      "A continucaion se muestran las fechas reservadas de esta habitacion:";
                for(int j=0;j<resXHab.size();j++)
                {
                    if(resXHab.get(j).getTiempoSalida().after(hoy)) 
                {
                    msj+="<br/>Entrada:"+resXHab.get(j).getTiempoEntrada()+" - Salida: "+resXHab.get(j).getTiempoSalida()+".";
                }
                }
                return "error";
            }
        } catch (Exception ex) {
            msj = "Error al realizar reservacion";
            return "fallo";
        }

    }

    public String ListaHoteles() {
        //List<Usuario> listClientes=null;
        try {
            listaHoteles = hotelesAd.ListaHoteles();
        } catch (Exception e) {
            msj = "Error al consultar por los usuarios.";
        }
        return "fin";
    }

    public String ListaHabitaciones() {
        //List<Usuario> listClientes=null;
        try {
            listaHabitaciones = hotelesAd.ListaHabXHotel((Integer) ActionContext.getContext().getSession().get("idHotel"));
        } catch (Exception e) {
            msj = "Error al consultar por los usuarios.";
        }
        return "fin";
    }

    public String goCliente() {
        return "exito";
    }

    public String goReserva() {
        listaHoteles = hotelesAd.ListaHoteles();
        listaClientes = hotelesAd.ListaClientes();
        listaHabitaciones = hotelesAd.ListaHabXHotel((Integer) ActionContext.getContext().getSession().get("idHotel"));
        nombreHotel = (String) ActionContext.getContext().getSession().get("hotel");
        msj = "";
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
