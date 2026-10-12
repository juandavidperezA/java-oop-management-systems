/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class Menu {
    Scanner sc =new Scanner(System.in);
    private CuentaBancaria cuenta;
    private Banco banco;
    
    public Menu(CuentaBancaria cuenta, Banco banco){
        this.cuenta=cuenta;
        this.banco=banco;
    }
    
    public void mostrarMenu(){
        boolean accesoPermitido=false;
        for(int i=1; i<=3; i++){
            System.out.println("Ingrese su Pin");
            while(!sc.hasNextInt()){
                System.out.println("el pin es numerico");
                sc.next();
            }
            int pin= sc.nextInt();
            
            if(banco.validarpin(cuenta.getTitular(), pin)){
                
                System.out.println("acceso permitido");
                accesoPermitido=true;
                break;
            }
            System.out.println("Pin incorrecto");
            System.out.println("Intentos restantes: "+(3-i));
        }
        if(!accesoPermitido){
            System.out.println("Cuenta bloqueada");
            return;
        }
        
        int opcion=0;
        
        while(opcion!=6){
            System.out.println("=========    menu del Cajero     =========");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. transferir dinero");
            System.out.println("5. Consultar Movimientos");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opcion:");
            
        while(!sc.hasNextInt()){
            System.out.println("la opcion debe ser numerica");
            sc.nextLine();
            System.out.println("Selecciona una opcion:");
        }
        opcion=sc.nextInt();
        
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $"+cuenta.consultaSaldo());
                    break;
                case 2:
                    System.out.print("ingresa el monto que quieras retirar: $");
                    while(!sc.hasNextDouble()){
                        System.out.println("el valor debe ser numerico");
                        sc.nextLine();
                        System.out.print("ingresa el monto que quieras retirar: $");
                    }
                    double retiro= sc.nextDouble();
                    
                    if(retiro<=0){
                        System.out.println("el valor debe ser mayor a cero");
                    }else if(cuenta.retirar(retiro)){
                        System.out.println("Se realizo el retiro correctamente. ");
                        System.out.println("saldo actualizado: $"+cuenta.consultaSaldo());
                    }else{
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.println("ingresa el monto a depositar: $");
                    while(!sc.hasNextDouble()){
                        System.out.println("El valor del monto debe ser numerico");
                        sc.nextLine();
                        System.out.println("ingresa el monto a depositar: $");
                    }
                    double deposito= sc.nextDouble();
                    
                    if(deposito<=0){
                        System.out.println("el valor debe ser mayor de cero");
                    }else{
                        cuenta.depositar(deposito);
                        System.out.println("Deposito realizado exitosamente :D");
                        System.out.println("saldo actual: $"+cuenta.consultaSaldo());
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el titular de la cuenta a transferir: ");
                    String destinatario= sc.next();
                    
                    CuentaBancaria cuentadestino= banco.buscarcuenta(destinatario);
                    if(cuentadestino == null){
                        System.out.println("no se encontro esa cuenta ");
                    }else if(cuentadestino== cuenta){
                        System.out.println("no puedes transferir a tu propia cuenta");
                    }else{
                        
                        System.out.println("Ingresa el monto a transferir: ");
                    while(!sc.hasNextDouble()){
                        System.out.println("el valor debe ser numerico");
                        sc.nextLine();
                        System.out.println("Ingresa el monto a transferir: ");
                    }
                    double montotranferir= sc.nextDouble();
                    
                    if(montotranferir<=0){
                        System.out.println("el valor debe ser mayor de 0");
                    }else if(cuenta.transferir(cuentadestino, montotranferir)){
                        System.out.println("Transferencia exitosa ");
                        System.out.println("Nuevo saldo: $"+cuenta.consultaSaldo());
                        System.out.println("saldo de "+cuentadestino.getTitular() +": $"+ cuentadestino.consultaSaldo());
                    }else{
                        System.out.println("No se pudo realizar la transferencia");
                    }
                    }
                    break;
                case 5:
                    cuenta.mostrarmovimientos();
                    break;
                case 6:
                    System.out.println("Gracias por visitarnos :D saliendo del programa...");
                    break;
                default:
                    System.out.println("opcion invalida. seleccione del 1 al 6 ");
            }
        }
    }
    
}
