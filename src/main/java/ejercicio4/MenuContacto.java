/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class MenuContacto {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    Agenda agenda= new Agenda();
    agenda.cargarDesdeArchivo();
    int opcion=0;
    
        while(opcion!=6){
        System.out.println("==========  Menu de contactos   ==========");
        System.out.println("1. Registrar contacto");
        System.out.println("2. buscar contacto");
        System.out.println("3. listar contactos");
        System.out.println("4. eliminar contacto");
        System.out.println("5. mostrar contactos por grupo");
        System.out.println("6. salir");
        System.out.println("Seleccione una opcion: ");
                    
            while(!sc.hasNextInt()){
                System.out.println("opcion equivocada vuelve a intentar debes ingresar numeros");
                sc.nextLine();
                System.out.println("selecciona una opcion: ");
            }
            opcion= sc.nextInt();
            sc.nextLine();
        
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del contacto:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el telefono del contacto:");
                    String telefono = sc.nextLine();
                    System.out.println("Ingrese el correo electronico:");
                    String email = sc.nextLine();
                    System.out.println("ingresa el grupo que quieres asignarle: ");
                    String grupof= sc.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono, email, grupof);
                    agenda.agregarContacto(nuevoContacto);
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del contacto que desea buscar: ");
                    String nombrebuscar= sc.nextLine();
                    if(nombrebuscar.trim().isEmpty()){
                        System.out.println("debes ingresar un nombre para buscar");
                    }else{
                    ArrayList<Contacto> encontrados= agenda.buscarContacto(nombrebuscar);
                    if(encontrados.isEmpty()){
                        System.out.println("no se encontro un usuario con ese nombre");
                    }else{
                        for(int i=0; i<encontrados.size();i++){
                        encontrados.get(i).mostrarInfo();
                        }
                    }
                    }
                    break;
                case 3:
                    System.out.println("==========  Lista de contactos  ==========");
                    agenda.mostrarTodos();
                    break;
                case 4:
                    System.out.println("ingrese el nombre del contacto que desea eliminar: ");
                    String eliminarcontacto= sc.nextLine();
                    agenda.eliminarContacto(eliminarcontacto);
                    break;
                case 5:
                    System.out.println("ingresa el grupo que deseas consultar: ");
                    String buscargrupo= sc.nextLine();
                    agenda.mostrarContactosPorGrupo(buscargrupo);
                    break;
                case 6:
                    agenda.guardarEnArchivo();
                    System.out.println("saliendo del programa...");
                    break;
                default:
                    System.out.println("opcion invalida. ingrese un nuero del 1 al 5");
                    break;
            }
        }
    }
}