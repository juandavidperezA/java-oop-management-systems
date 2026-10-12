/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 *
 * @author USUARIO
 */
public class Curso {
    private ArrayList<Estudiantes> estudiantes;
    
    public Curso(){
        this.estudiantes=new ArrayList<>();
    }
    
    public void agregarEstudiantes(Estudiantes estudiante){
        estudiantes.add(estudiante);
    }
    
    public double promediocurso(){
         if(estudiantes.size()== 0){
             return 0;
        }
        
        double suma= 0;
        for(int i =0; i<estudiantes.size();i++){
            suma+= estudiantes.get(i).getPromedio();
        }
        double promediogeneral=suma/estudiantes.size();
        return promediogeneral;
    }
    
    public int contaraprobados(){
        int aprobados=0;
        
        if(estudiantes.size()==0){
            System.out.println("no hay estudiantes");
            return 0;
        }
        for(int i =0 ; i<estudiantes.size();i++){
            if(estudiantes.get(i).aprobo()){
                aprobados++;
            }
        }return aprobados;
    }
    
    public int contarReprobados(){
    return estudiantes.size() - contaraprobados();
    }
    
    public Estudiantes obtenermayorpromedio(){
        
        if(estudiantes.size()==0){
            System.out.println("no se encuentra estudiantes registrados");
            return null;
        }
        Estudiantes mayor= estudiantes.get(0);
        for(int i =0; i<estudiantes.size(); i++){
        if(estudiantes.get(i).getPromedio()> mayor.getPromedio()){
            mayor=estudiantes.get(i);
        }
        }
        return mayor;
    }
    
    public Estudiantes obtenerMenorPromedio(){
        if(estudiantes.size()==0){
            System.out.println("no se encuentra estudiantes registrados");
            return null;
        }
        Estudiantes menor= estudiantes.get(0);
        for(int i =0; i<estudiantes.size(); i++){
            if(estudiantes.get(i).getPromedio()<menor.getPromedio()){
                menor=estudiantes.get(i);
            }
        }
        return menor;
    }
    
    public void mostrarestudiantes(){
        if(estudiantes.size()==0){
            System.out.println("no hay estudiantes registrados");
            return;
        }
        
        for(int i =0; i<estudiantes.size();i++){
            estudiantes.get(i).mostrarinfo();
        }
    }
    
    public void guardarReporte(String nombreArchivo){
            PrintWriter archivo=null;
        try {
            archivo = new PrintWriter(nombreArchivo);
            archivo.println("=======================    REPORTE DE CAMPERS DE CAMPUSLAND BUCARAMANGA    =======================");
            for(int i =0; i<estudiantes.size(); i++){
                archivo.println("Nombre del estudiante: "+ estudiantes.get(i).getNombre());
                archivo.println("Promedio del estudiante: "+ estudiantes.get(i).getPromedio());
            }
            archivo.println("\n--------------------------------------------------------------------------------------------");
            archivo.println("promedio general del grupo: "+ promediocurso());
            archivo.println("cantidad de aprobados: "+contaraprobados());
            archivo.println("cantidad de reprobados: "+ contarReprobados());
        } catch (FileNotFoundException e) {
            System.out.println("error al crear el reporte: "+ e.getMessage());
        }catch(Exception e){
            System.out.println("error general: "+ e.getMessage());
        }finally{
            if(archivo !=null){
            archivo.close();
            }
        }
    }
    
    public Estudiantes buscarEstudiante(String nombre){
        for(int i =0; i<estudiantes.size(); i++){
            if(estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)){
                return estudiantes.get(i);
            }
        }return null;
    }
    
    public void modificarNota(String nombreEstudiante, String nombreAsignatura, double nuevaNota){
        Estudiantes estudiante= buscarEstudiante(nombreEstudiante);
        if(estudiante!= null){
            Asignatura materia = estudiante.buscarAsignatura(nombreAsignatura);
            if(materia!=null){
                if(nuevaNota<0 || nuevaNota>10){
                   System.out.println("la nota debe estar entre 0 y 10");
                   return;
               }
               materia.setnotasfinales(nuevaNota);
               estudiante.calcularPromedio();
                System.out.println("Nota actualizada correctamente :D");

            }else{
                System.out.println("asignatura no encontrada");
            }
        }else{
            System.out.println("estudiante no encontrado");
        } 
    }
}
