/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Estudiantes {
  private String Nombre;
    private ArrayList<Asignatura> asignaturas;
    private double promedio;
    private int faltas;

    public Estudiantes(String nombre, int faltas){
        this.Nombre= nombre;
        this.asignaturas=new ArrayList<>();
        this.faltas= faltas;
    }

    public String getNombre(){
        return Nombre;
    }

    public double getPromedio(){
        return promedio;
    }
    
    public int getfaltas(){
        return faltas;
    }
    
    public void agregarAsignatura(Asignatura materia){
        asignaturas.add(materia);
    }

    public void calcularPromedio(){
        if(asignaturas.isEmpty()){
            System.out.println("no hay asignaturas en este momento registradas");
            promedio=0;
            return ;
        }
        
        double suma= 0;
        for(int i=0; i< asignaturas.size();i++){
            suma+=asignaturas.get(i).getNotaFinal();
        }
        this.promedio= suma / asignaturas.size();
    }

    public boolean aprobo(){
        return promedio>= 6 && faltas<10;
    }
    
    public void mostrarinfo(){
        System.out.println("Nombre del estudiante: "+ getNombre());
        System.out.println("Numero de faltas: "+getfaltas());
        for(int i = 0; i<asignaturas.size();i++){
            System.out.println("Asignatura: "+ asignaturas.get(i).getNombre()+" | "+"Nota: "+asignaturas.get(i).getNotaFinal());
        }
        System.out.println("el promedio de sus notas es de: " + getPromedio());
        if(aprobo()){
            System.out.println("Estado: Aprobo");
        }else{
            System.out.println("Estado: Reprobado");
        }
        System.out.println("\n\n===========================================\n");
    }
    
    public Asignatura buscarAsignatura(String name){
        for(int i=0; i<asignaturas.size();i++){
            if(asignaturas.get(i).getNombre().equalsIgnoreCase(name)){
                return asignaturas.get(i);
            }
        }return null;
    }
}