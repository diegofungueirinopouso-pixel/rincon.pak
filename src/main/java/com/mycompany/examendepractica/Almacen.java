/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examendepractica;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Almacen {

    // 1. Muelle físico: array bidimensional 3x3
    private Paquete[][] muelle;

    // 2. Registro de seguridad: HashSet para evitar duplicados
    private HashSet<String> registroCodigos;

    // 3. Cola de salida: ArrayList con paquetes despachados
    private ArrayList<Paquete> colaSalida;

    // 4. Estadísticas: HashMap destino -> número de paquetes enviados
    private HashMap<String, Integer> estadisticas;

    public Almacen() {
        muelle = new Paquete[3][3];
        registroCodigos = new HashSet<>();
        colaSalida = new ArrayList<>();
        estadisticas = new HashMap<>();
    }

    // Recepcionar un paquete en la posición indicada del muelle
    public void recepcionarPaquete(Paquete p, int fila, int col) {
        // Verificar si el código ya existe
        if (registroCodigos.contains(p.getCodigo())) {
            System.out.println("ERROR: Ya existe un paquete con el código " + p.getCodigo());
            return;
        }

        // Verificar si la posición está libre
        if (muelle[fila][col] != null) {
            System.out.println("ERROR: La posición [" + fila + "][" + col + "] ya está ocupada.");
            return;
        }

        // Almacenar el paquete y registrar su código
        muelle[fila][col] = p;
        registroCodigos.add(p.getCodigo());
        System.out.println("OK: " + p + " recepcionado en posición [" + fila + "][" + col + "]");
    }

    // Enviar el paquete de una posición del muelle al camión
    public void enviarACamion(int fila, int col) {
        Paquete p = muelle[fila][col];

        if (p == null) {
            System.out.println("ERROR: No hay ningún paquete en la posición [" + fila + "][" + col + "]");
            return;
        }

        // Retirar del muelle
        muelle[fila][col] = null;

        // Añadir a la cola de salida
        colaSalida.add(p);

        // Actualizar estadísticas
        String destino = p.getDestino();
        if (estadisticas.containsKey(destino)) {
            estadisticas.put(destino, estadisticas.get(destino) + 1);
        } else {
            estadisticas.put(destino, 1);
        }

        System.out.println("OK: " + p + " enviado al camión.");
    }

    // Eliminar de la cola de salida los paquetes que superen el peso máximo
    public void mantenimientoSeguridad(double pesoMaximo) {
        System.out.println("\n-- Mantenimiento de seguridad (peso máximo: " + pesoMaximo + "kg) --");

        Iterator<Paquete> it = colaSalida.iterator();
        while (it.hasNext()) {
            Paquete p = it.next();
            if (p.getPeso() > pesoMaximo) {
                System.out.println("Eliminado por exceso de peso: " + p);
                it.remove();
            }
        }

        System.out.println("Mantenimiento completado.");
    }

    // Mostrar el informe de estadísticas
    public void mostrarEstadisticas() {
        System.out.println("\n=== INFORME DE ENVÍOS POR DESTINO ===");
        for (Map.Entry<String, Integer> entrada : estadisticas.entrySet()) {
            System.out.println("  Destino: " + entrada.getKey() + " -> " + entrada.getValue() + " paquete(s)");
        }
    }

    // Mostrar el estado actual de la cola de salida
    public void mostrarColaSalida() {
        System.out.println("\n=== COLA DE SALIDA ===");
        if (colaSalida.isEmpty()) {
            System.out.println("  La cola está vacía.");
        } else {
            for (Paquete p : colaSalida) {
                System.out.println("  " + p);
            }
        }
    }

    // Mostrar el estado del muelle
    public void mostrarMuelle() {
        System.out.println("\n=== ESTADO DEL MUELLE ===");
        for (int i = 0; i < muelle.length; i++) {
            for (int j = 0; j < muelle[i].length; j++) {
                if (muelle[i][j] != null) {
                    System.out.println("  [" + i + "][" + j + "] -> " + muelle[i][j]);
                } else {
                    System.out.println("  [" + i + "][" + j + "] -> (vacío)");
                }
            }
        }
    }
}