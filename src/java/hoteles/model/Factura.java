package hoteles.model;
// Generated 10/06/2013 06:00:09 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private Integer idFactura;
     private Reserva reserva;
     private Date fecha;
     private Double total;

    public Factura() {
    }

	
    public Factura(Reserva reserva, Date fecha) {
        this.reserva = reserva;
        this.fecha = fecha;
    }
    public Factura(Reserva reserva, Date fecha, Double total) {
       this.reserva = reserva;
       this.fecha = fecha;
       this.total = total;
    }
   
    public Integer getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }




}


