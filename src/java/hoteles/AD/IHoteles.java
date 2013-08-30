/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteles.AD;

import java.util.*;
import hoteles.model.Empleados;
import hoteles.model.Clientes;
import hoteles.model.Hoteles;
import hoteles.model.Reserva;
import hoteles.model.Estancia;
import hoteles.model.Habitacionxhotel;

/**
 *
 * @author diego
 */
public interface IHoteles {
    public boolean Agregar(Empleados _empleado);
    public boolean AgregarCliente(Clientes _cliente);
    public Reserva Reservar(Reserva _reserva,int _idHotel,int _idEmpleado,int _idCliente);
    public Empleados VerificaUsuario(Empleados _empleado);
    public List<Empleados> ListaUsuarios();
    public List<Hoteles> ListaHoteles();
    public ArrayList<Clientes> ListaClientes();
    public ArrayList<Habitacionxhotel> ListaHabXHotel(int idHotel);
}
