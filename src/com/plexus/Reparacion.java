package com.plexus;

import java.util.Date;

public class Reparacion {

    private int idCliente;
    private int idVehiculo;
    private String descripcion;
    private Date fecha;
    private String tiempo;
    private float totalReparacion;

    public Reparacion(int idCliente, int idVehiculo, String descripcion, Date fecha, String tiempo, float totalReparacion) {
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.totalReparacion = totalReparacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public float getTotalReparacion() {
        return totalReparacion;
    }

    public void setTotalReparacion(float totalReparacion) {
        this.totalReparacion = totalReparacion;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "idCliente=" + idCliente +
                ", idVehiculo=" + idVehiculo +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", tiempo='" + tiempo + '\'' +
                ", totalReparacion=" + totalReparacion +
                '}';
    }

}
