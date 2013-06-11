package hoteles.model;
// Generated 10/06/2013 06:00:09 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empleados generated by hbm2java
 */
public class Empleados  implements java.io.Serializable {


     private Integer idEmpleado;
     private Hoteles hoteles;
     private String nombre;
     private String direccion;
     private String cedula;
     private String titulo;
     private String usuario;
     private String password;
     private Set reservas = new HashSet(0);

    public Empleados() {
    }

	
    public Empleados(Hoteles hoteles, String nombre, String direccion, String cedula, String titulo, String usuario) {
        this.hoteles = hoteles;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.titulo = titulo;
        this.usuario = usuario;
    }
    public Empleados(Hoteles hoteles, String nombre, String direccion, String cedula, String titulo, String usuario, String password, Set reservas) {
       this.hoteles = hoteles;
       this.nombre = nombre;
       this.direccion = direccion;
       this.cedula = cedula;
       this.titulo = titulo;
       this.usuario = usuario;
       this.password = password;
       this.reservas = reservas;
    }
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Hoteles getHoteles() {
        return this.hoteles;
    }
    
    public void setHoteles(Hoteles hoteles) {
        this.hoteles = hoteles;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }




}

