package hoteles.model;
// Generated 10/06/2013 06:00:09 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Tipohabitacion generated by hbm2java
 */
public class Tipohabitacion  implements java.io.Serializable {


     private Integer idTipoHabitacion;
     private String nombre;
     private String ubicacion;
     private Set habitacionxhotels = new HashSet(0);

    public Tipohabitacion() {
    }

	
    public Tipohabitacion(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public Tipohabitacion(String nombre, String ubicacion, Set habitacionxhotels) {
       this.nombre = nombre;
       this.ubicacion = ubicacion;
       this.habitacionxhotels = habitacionxhotels;
    }
   
    public Integer getIdTipoHabitacion() {
        return this.idTipoHabitacion;
    }
    
    public void setIdTipoHabitacion(Integer idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Set getHabitacionxhotels() {
        return this.habitacionxhotels;
    }
    
    public void setHabitacionxhotels(Set habitacionxhotels) {
        this.habitacionxhotels = habitacionxhotels;
    }




}


