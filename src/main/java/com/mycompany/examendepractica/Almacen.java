/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examendepractica;



public class Almacen {

   Paquete [] [] muelle =new Paquete [3] [3];
   private HashSet<String> registroCodigos = new HashSet<>();
    private ArrayList<Paquete> colaSalida = new ArrayList<>();
    private HashMap<String, Integer> estadisticas = new HashMap<>();
    
    public void recepcionarPaquete(Paquete p, int fila, int col) {

    if (registroCodigos.contains(p.getCodigo())) {
        System.out.println("ERROR: Código duplicado -> " + p.getCodigo());
        return;
    }

    if (muelle[fila][col] != null) {
        System.out.println("ERROR: Posición ocupada en [" + fila + "," + col + "]");
        return;
    }

    muelle[fila][col] = p;
    registroCodigos.add(p.getCodigo());

    System.out.println("Paquete almacenado en [" + fila + "," + col + "]");
    }
}