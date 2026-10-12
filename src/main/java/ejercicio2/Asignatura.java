/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author USUARIO
 */
public class Asignatura {
    private String nombre;
    private double notafinal;
    
    public Asignatura(String pNombre, double pNotafinal){
        nombre= pNombre;
        notafinal= pNotafinal;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getNotaFinal(){
        return notafinal;
    }
    
    public void setnotasfinales(double nuevanota){
        this.notafinal=nuevanota;
    }
}


