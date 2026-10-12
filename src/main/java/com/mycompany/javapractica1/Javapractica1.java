/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.javapractica1;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */

public class Javapractica1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {

            System.out.println("\n========== PRACTICA JAVA ==========");
            System.out.println("1. Cajero automatico");
            System.out.println("2. Registro academico");
            System.out.println("3. Tienda online");
            System.out.println("4. Agenda de contactos");
            System.out.println("5. Sistema de notas con curva");
            System.out.println("6. Salir");
            System.out.println("===================================");
            System.out.println("Selecciona una opcion:");

            if (!sc.hasNextInt()) {
                System.out.println("Error: debes ingresar un numero entero.");
                sc.nextLine();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    ejercicio1.Cajero.main(new String[0]);
                    break;

                case 2:
                    ejercicio2.MenuEstudiantes.main(new String[0]);
                    break;

                case 3:
                    ejercicio3.MenuTienda.main(new String[0]);
                    break;

                case 4:
                    ejercicio4.MenuContacto.main(new String[0]);
                    break;

                case 5:
                    ejercicio5.menualumno.main(new String[0]);
                    break;

                case 6:
                    System.out.println("Gracias por utilizar la practica Java.");
                    break;

                default:
                    System.out.println("Opcion invalida. Intenta nuevamente.");
            }
        }
    }
}
