package com.plexus;

import java.util.Objects;

public class Vehiculo {

    private int idVehiculo;
    private String matricula;
    private Marcas marcaVehiculo;
    private String modelo;
    private int ano;
    private String color;

    public Vehiculo(int idVehiculo, String matricula, Marcas marcaVehiculo, String modelo, int ano, String color) {
        this.idVehiculo = idVehiculo;
        this.matricula = matricula;
        this.marcaVehiculo = marcaVehiculo;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Marcas getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(Marcas marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getIdVehiculo() == vehiculo.getIdVehiculo() && getAno() == vehiculo.getAno() && Objects.equals(getMatricula(), vehiculo.getMatricula()) && getMarcaVehiculo() == vehiculo.getMarcaVehiculo() && Objects.equals(getModelo(), vehiculo.getModelo()) && Objects.equals(getColor(), vehiculo.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdVehiculo(), getMatricula(), getMarcaVehiculo(), getModelo(), getAno(), getColor());
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", matricula='" + matricula + '\'' +
                ", marcaVehiculo=" + marcaVehiculo +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
