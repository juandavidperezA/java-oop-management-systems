/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class MenuEstudiantes {
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion=0;
        Curso curso =new Curso();
        Estudiantes[] estudiantes= null;
        while(opcion != 10){
            System.out.println("\n================= MENU DE ESTUDIANTES =================");
            System.out.println("1. agregar nuevo estudiante");
            System.out.println("2. mostrar estudiante");
            System.out.println("3. calcular promedio general");
            System.out.println("4. contar probado y reporbado");
            System.out.println("5. buscar mayor promedio");
            System.out.println("6. buscar menor promedio");
            System.out.println("7. Crear reporte");
            System.out.println("8. buscar estudiante. ");
            System.out.println("9. modificar nota");
            System.out.println("10. volver a menu principal");
            System.out.println("ingresa alguna opcion");
            
            while(!scanner.hasNextInt()){
                System.out.println("la opcion debe ser numerica");
                scanner.nextLine();
                System.out.println("ingresa alguna opcion");
            }
            opcion= scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    int cantidad;
                    do{
                        System.out.println("ingresa la cantidad de estudiantes");
                        while(!scanner.hasNextInt()){
                            System.out.println("la cantidad debe ser numerica");
                            scanner.next();
                            System.out.println("ingresa la cantidad de estudiantes: ");
                        }
                            cantidad= scanner.nextInt();
                            if(cantidad<=0){
                                System.out.println("la cantidad debe ser mayor de cero");
                            }
                        
                    }while(cantidad<=0);
                    scanner.nextLine();
                    estudiantes= new Estudiantes[cantidad];

                    
                    for(int i= 0; i<estudiantes.length; i++){
                        System.out.println("ingresa el nombre del estudiante: ");
                        String alumno = scanner.nextLine();
                        
                        int Numerofaltas=0;
                        System.out.println("ingresa la cantidad de faltas que tiene el estudiante: ");
                        while(!scanner.hasNextInt()){
                            System.out.println("la cantidad de faltas debe ser numerica");
                            scanner.nextLine();
                            System.out.println("ingresa la cantidad de faltas que tiene el estudiante: ");
                        }
                        Numerofaltas= scanner.nextInt();
                        while(Numerofaltas<0){
                            System.out.println("el numero de faltas no puede ser menor de 0");
                            System.out.println("ingresa la cantidad de faltas que tiene el estudiante: ");
                        while(!scanner.hasNextInt()){
                            System.out.println("la cantidad de faltas debe ser numerica: ");
                            scanner.nextLine();
                        }
                        Numerofaltas=scanner.nextInt();
                        }
                        scanner.nextLine();
                        
                        System.out.println("cuantas asignaturas desea registrar? ");
                        int cantiasig=0;
                        while(!scanner.hasNextInt()){
                            System.out.println("la cantidad debe ser numerica");
                            scanner.nextLine();
                            System.out.println("cuantas asignaturas desea registrar? ");
                        }
                        cantiasig=scanner.nextInt();
                        scanner.nextLine();
                        while(cantiasig<=0){
                            System.out.println("la cantidad no puede ser negativa");
                            System.out.println("cuantas asignaturas desea registrar? ");
                        while(!scanner.hasNextInt()){
                            System.out.println("la cantidad debe ser numerica");
                            scanner.nextLine();
                        }cantiasig=scanner.nextInt();
                         scanner.nextLine();
                        }
                        
                        estudiantes[i]=new Estudiantes(alumno,Numerofaltas);
                        for(int j=0; j<cantiasig;j++){
                        System.out.println("ingresa el nombre de la asignatura #"+(j+1));
                        String nameasignatura= scanner.nextLine();
                        
                        
                        double notafi=0.0;
                        System.out.println("ingresa la nota final de la asignatura");
                        while(!scanner.hasNextDouble()){
                            System.out.println("la nota debe ser numerico");
                            scanner.nextLine();
                            System.out.println("ingresa la nota final de la asignatura");
                        }
                        notafi = scanner.nextDouble();
                        while(notafi<0 || notafi>10){
                            System.out.println("el valor debe ser mayor de 0 y menor de 10 ");
                            System.out.println("ingresa la nota final de la asignatura");
                        while(!scanner.hasNextDouble()){
                            System.out.println("el valor debe ser numerico");
                            scanner.nextLine();
                        }
                        notafi=scanner.nextDouble();
                        }
                        scanner.nextLine();
                        
                        Asignatura materia= new Asignatura(nameasignatura, notafi);
                        estudiantes[i].agregarAsignatura(materia);
                    }
                        estudiantes[i].calcularPromedio();
                        curso.agregarEstudiantes(estudiantes[i]);
                    }
                    break;
                case 2:
                    curso.mostrarestudiantes();
                    break;
                case 3:
                    System.out.println("el promedio general del curso es: "+curso.promediocurso());
                    break;
                case 4:
                    System.out.println("hay "+curso.contaraprobados()+" estudiantes aprobados");
                    System.out.println("hay "+curso.contarReprobados()+" estudiantes desaprobados");
                    break;
                case 5:
                    Estudiantes mayor= curso.obtenermayorpromedio();
                    
                    if(mayor!=null){
                        System.out.println("Nombre del estudiante: "+ mayor.getNombre());
                        System.out.println("promedio del estudiante: "+mayor.getPromedio());
                    }else{
                        System.out.println("no hay estudiantes registrados");
                    }
                    break;
                case 6:
                    Estudiantes menor= curso.obtenerMenorPromedio();
                    
                    if(menor!=null){
                        System.out.println("Nombre del estudiante: "+menor.getNombre());
                        System.out.println("promedio del estudiante: "+ menor.getPromedio());
                    }else{
                        System.out.println("no hay estudiantes registrados");
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("ingresa el nombre del reporte: ");
                    String Nombrearchivo= scanner.nextLine();
                    if (!Nombrearchivo.toLowerCase().endsWith(".txt")) {
                           Nombrearchivo += ".txt";
                    }
                    curso.guardarReporte(Nombrearchivo);
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.println("ingresa el nombre del estudiante");
                    String nombreestudiante= scanner.nextLine();
                    
                    Estudiantes encontrado= curso.buscarEstudiante(nombreestudiante);
                    if(encontrado != null){
                        encontrado.mostrarinfo();
                    }else{
                        System.out.println("el estudiante no encontrado");
                    }
                    break;
                case 9:
                    scanner.nextLine();
                    System.out.println("para modificar la nota necesitamos que respondas estas preguntas: ");
                    System.out.println("ingresa el nombre del estudiante: ");
                    String Estudiantenombre= scanner.nextLine();
                    
                    System.out.println("ingresa el nombre de la Asignatura que deseas modificar");
                    String asignaturaseleccionada= scanner.nextLine();
                    
                    System.out.println("ingresa el valor de la nota para actualizarla: ");
                    while(!scanner.hasNextDouble()){
                        System.out.println("el valor debe ser numerico");
                        scanner.nextLine();
                        System.out.println("ingresa el valor de la nota para actualizar: ");
                    }
                    double newnota=scanner.nextDouble();
                    
                    curso.modificarNota(Estudiantenombre, asignaturaseleccionada, newnota);
                    break;
                case 10:
                    System.out.println("saliendo del programa...");
                    break;
                default:
                    System.out.println("opcion invalida");
                    System.out.println("la opcion debe ser del 1-8");
            }
        }
    }
}
