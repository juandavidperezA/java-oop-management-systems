/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author USUARIO
 */
public class menualumno {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("cuantos alumnos desea registrar? ");
            while(!sc.hasNextInt()){
                System.out.println("el valor debe ser numerico");
                sc.nextLine();
                System.out.println("cuantos alumnos desea registrar? ");
            }
            int cantidad= sc.nextInt();
            while(cantidad<=0 || cantidad>10){
                System.out.println("debe ingresar una cantidad entre 1 y 10");
                System.out.println("cuantos alumnos desea registrar? ");                
                while(!sc.hasNextInt()){
                    System.out.println("la cantidad debe ser numerico y numero entero");
                    sc.nextLine();
                }
                cantidad=sc.nextInt();
            }
            
            sc.nextLine();
            Alumno[] alumnos = new Alumno[cantidad];
            
            for(int i =0; i<alumnos.length; i++){
                System.out.println("ingresando el estudiante #"+(i+1));
                System.out.println("ingresa el nombre del estudiante: ");

                String nombrealumno= sc.nextLine();
                
                double notaparcial1=0.0;
                boolean notavalida=false;
                    while(!notavalida){
                        System.out.println("ingresa la nota del primer parcial del estudiante: ");
                        
                        try {
                            notaparcial1=sc.nextDouble();
                            
                            if(notaparcial1>=0 && notaparcial1<=10){
                                notavalida=true;
                            }else{
                                System.out.println("La nota debe estar entre 0 y 10.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("error: debes ingresar un numero."+ e.getMessage());
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                double notaparcial2=0.0;
                boolean notavalida2=false;
                
                while(!notavalida2){
                    System.out.println("ingresa la nota del segundo parcial del estudiante: ");
                    
                    try {
                        notaparcial2=sc.nextDouble();
                        
                        if(notaparcial2>=0 && notaparcial2<=10){
                            notavalida2=true;
                        }else{
                            System.out.println("La nota debe estar entre 0 y 10.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: debes ingresar un numero"+ e.getMessage());
                        sc.nextLine();
                    }
                }
                sc.nextLine();
                
                double examenfinal=0.0;
                boolean notavalida3= false;
                
                while(!notavalida3){
                    System.out.println("ingresa la nota del examen final del estudiante: ");
                    
                    try {
                        examenfinal= sc.nextDouble();
                        if(examenfinal>=0 && examenfinal<=10){
                            notavalida3=true;
                        }else{
                            System.out.println("La nota debe estar entre 0 y 10.");
                        }                        
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: debes ingresar un numero"+ e.getMessage());
                        sc.nextLine();
                    }
                }sc.nextLine();
                alumnos[i]=new Alumno(nombrealumno, notaparcial1, notaparcial2,examenfinal);
            }

            
            double sumanotas=0.0;
            
            for(int i =0; i<alumnos.length;i++){
            sumanotas += alumnos[i].getnotaOriginal();
            }
            double promedio = sumanotas / alumnos.length;
// MENÚ DE CURVAS
        int opcionCurva = 0;

        while (opcionCurva < 1 || opcionCurva > 4) {

            System.out.println("========== MENU DE CURVAS ==========");
            System.out.println("1. No aplicar curva");
            System.out.println("2. Curva fija (+2 puntos)");
            System.out.println("3. Curva porcentual (10%)");
            System.out.println("4. Curva segun la nota mas alta");
            System.out.println("====================================");
            System.out.println("Selecciona una opcion:");

            if (sc.hasNextInt()) {
                opcionCurva = sc.nextInt();

                if (opcionCurva < 1 || opcionCurva > 4) {
                    System.out.println("Opcion fuera de rango.");
                }

            } else {
                System.out.println("Debes ingresar un numero entero.");
                sc.nextLine();
            }
        }

        switch (opcionCurva) {

            case 1:
                System.out.println("No se aplicara ninguna curva.");
                break;

            case 2:
                if (promedio < 6) {
                    for (int i = 0; i < alumnos.length; i++) {
                        alumnos[i].aplicarCurva(2);
                    }
                    System.out.println("Curva fija aplicada.");
                } else {
                    System.out.println("No se aplica curva: promedio igual o superior a 6.");
                }
                break;

            case 3:
                if (promedio < 6) {
                    for (int i = 0; i < alumnos.length; i++) {
                        alumnos[i].aplicarCurvaPorcentual(10);
                    }
                    System.out.println("Curva porcentual aplicada.");
                } else {
                    System.out.println("No se aplica curva: promedio igual o superior a 6.");
                }
                break;

            case 4:
                if (promedio < 6) {

                    double notaMayor = alumnos[0].getnotaOriginal();

                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i].getnotaOriginal() > notaMayor) {
                            notaMayor = alumnos[i].getnotaOriginal();
                        }
                    }

                    double puntosCurva = 10 - notaMayor;

                    for (int i = 0; i < alumnos.length; i++) {
                        alumnos[i].aplicarCurva(puntosCurva);
                    }

                    System.out.println("Curva segun la nota mas alta aplicada.");

                } else {
                    System.out.println("No se aplica curva: promedio igual o superior a 6.");
                }
                break;
                    }
            

            double sumaFinal= 0.0;
            for(int i =0 ; i<alumnos.length ;i++){
                sumaFinal+= alumnos[i].getNotafinal();
            }
            double promediofinal= sumaFinal / alumnos.length;
            
            
            int contador=0;
            
            for(int i =0;i<alumnos.length;i++){
                if(alumnos[i].getnotaOriginal()<6 && alumnos[i].getNotafinal()>=6){
                    contador++;
                }
            }
              System.out.println("Alumnos que aprobaron gracias a la curva: "+contador);
              
            double sumaDiferencias = 0.0;

                for (int i = 0; i < alumnos.length; i++) {
                    double diferencia = alumnos[i].getNotafinal() - promediofinal;

                    sumaDiferencias += diferencia * diferencia;
                }

                double varianza = sumaDiferencias / alumnos.length;
                double desviacionEstandar = Math.sqrt(varianza);

                System.out.printf("Desviacion estandar: %.2f%n", desviacionEstandar);
              
            System.out.printf("Promedio original: %.2f%n", promedio);
            System.out.printf("Promedio final: %.2f%n", promediofinal);
            System.out.println("========================    RESULTADOS FIANLES  ========================");
            
            for(int i=0; i<alumnos.length;i++){

                System.out.println("nombre del estudiante: "+ alumnos[i].getNombre());
                System.out.printf("nota original: %.2f%n",alumnos[i].getnotaOriginal());
                System.out.printf("nota final: %.2f%n", alumnos[i].getNotafinal());
                
                if(alumnos[i].estaaprobado()){
                    System.out.println("Estado: Aprobado");
                }else{
                    System.out.println("Estado: Reprobado");
                }
                
                System.out.println("---------------------------------------------------------------------------------");
            }
        }
}
