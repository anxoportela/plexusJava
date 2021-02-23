package com.plexus;

public class Vehiculo {

    private int idVehiculo;
    private String matricula;
    private Marcas marcaVehiculo;
    private String modelo;
    private String ano;
    private String color;

    public Vehiculo(int idVehiculo, String matricula, Marcas marcaVehiculo, String modelo, String ano, String color) {
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
