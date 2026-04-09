/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examendepractica;

import java.util.Objects;

/**
 *
 * @author holab
 */
public class Paquete {

    private String codigo;
    private double peso;
    private String destino;

    public Paquete(String codigo, double peso, String destino) {
        this.codigo = codigo;
        this.peso = peso;
        this.destino = destino;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

    // Dos paquetes son iguales si tienen el mismo código
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paquete otro = (Paquete) obj;
        return this.codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return "Paquete{codigo='" + codigo + "', peso=" + peso + "kg, destino='" + destino + "'}";
    }
}