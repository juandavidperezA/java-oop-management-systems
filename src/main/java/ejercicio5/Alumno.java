/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

/**
 *
 * @author USUARIO
 */
public class Alumno {
    private String nombre;
    private double notaOriginal;
    private double notaFinal;
    private double notaParcial1;
    private double notaParcial2;
    private double examenFinal;
            
            
    public Alumno(String pNombre, double pNotaParcial1, double pNotaParcial2, double pExamenFinal){
        nombre= pNombre;
        notaParcial1= pNotaParcial1;
        notaParcial2 = pNotaParcial2;
        examenFinal= pExamenFinal;
        calcularNotaOriginal();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getnotaOriginal(){
        return notaOriginal;
    }
    
    public double getNotafinal(){
        return notaFinal;
    }
    
    
    public void aplicarCurva(double puntos){
       notaFinal+=puntos;
       if(notaFinal>10){
           notaFinal=10;
       }
    }
    
    public void aplicarCurvaPorcentual(double porcentaje){
        double aumento = notaFinal*(porcentaje/100);
        notaFinal+= aumento;
        
        if(notaFinal>10){
            notaFinal=10;
        }
    }
    
    public boolean estaaprobado(){
    if(notaFinal>=6){
        return true;
    }else{
        return false;
    }
    }
    
    public void calcularNotaOriginal(){
        notaOriginal= (notaParcial1* 0.30)+ (notaParcial2*0.30)+ (examenFinal*0.40);
        notaFinal= notaOriginal;
    }
}
