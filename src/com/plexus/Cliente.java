package com.plexus;

import java.util.Objects;

public class Cliente {

    private int idCliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    public Cliente(int idCliente, String dni, String nombre, String apellidos, int edad) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getIdCliente() == cliente.getIdCliente() && getEdad() == cliente.getEdad() && Objects.equals(getDni(), cliente.getDni()) && Objects.equals(getNombre(), cliente.getNombre()) && Objects.equals(getApellidos(), cliente.getApellidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente(), getDni(), getNombre(), getApellidos(), getEdad());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }

}
