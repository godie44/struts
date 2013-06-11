/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteles.AD;

import java.util.List;
import hoteles.model.Empleados;
import hoteles.model.Clientes;
import hoteles.model.Hoteles;
import hoteles.model.Reserva;
import hoteles.model.Estancia;

/**
 *
 * @author diego
 */
public interface IHoteles {
    public boolean Agregar(Empleados _empleado);
    public Empleados VerificaUsuario(Empleados _empleado);
    public List<Empleados> ListaUsuarios();
    public List<Hoteles> ListaHoteles();
}
