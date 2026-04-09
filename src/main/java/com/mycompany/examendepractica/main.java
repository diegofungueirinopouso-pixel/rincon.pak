/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examendepractica;

/**
 *
 * @author holab
 */
public class main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        System.out.println("=== SISTEMA DE GESTIÓN DE MUELLE ===\n");

        // 1. Entrada de paquetes (4 paquetes, uno con código duplicado)
        System.out.println("-- Recepción de paquetes --");

        Paquete p1 = new Paquete("PKG001", 5.2, "Madrid");
        Paquete p2 = new Paquete("PKG002", 12.0, "Barcelona");
        Paquete p3 = new Paquete("PKG003", 8.5, "Madrid");
        Paquete p4 = new Paquete("PKG001", 3.1, "Valencia"); // Código duplicado: debe mostrar error

        almacen.recepcionarPaquete(p1, 0, 0);
        almacen.recepcionarPaquete(p2, 0, 1);
        almacen.recepcionarPaquete(p3, 1, 0);
        almacen.recepcionarPaquete(p4, 1, 1); // Error esperado por código duplicado

        almacen.mostrarMuelle();

        // 2. Despacho de 2 paquetes hacia la cola de salida
        System.out.println("\n-- Despacho al camión --");
        almacen.enviarACamion(0, 0); // PKG001 (5.2 kg) -> Madrid
        almacen.enviarACamion(0, 1); // PKG002 (12.0 kg) -> Barcelona

        almacen.mostrarColaSalida();

        // 3. Mantenimiento de seguridad (elimina paquetes con más de 10 kg)
        almacen.mantenimientoSeguridad(10.0);

        almacen.mostrarColaSalida();

        // 4. Informe final con estadísticas por destino
        almacen.mostrarEstadisticas();
    }
}
