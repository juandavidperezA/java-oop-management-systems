/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Cajero {
    public static void main(String[] args){

        CuentaBancaria cuenta = new CuentaAhorro("juan", 500000, 1234);
        CuentaBancaria cuentamaria = new CuentaCorriente("maria", 200000, 4123, 50000);
        
        Banco banco = new Banco();
        
        banco.agregarcuenta(cuenta);
        banco.agregarcuenta(cuentamaria);
        /*
        ArrayList<CuentaBancaria> cuentas= new ArrayList<>();
        cuentas.add(cuenta);
        cuentas.add(cuentamaria);*/
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Ingresa el titular de la cuenta: ");
        String titularnombre= sc.nextLine();
        
        CuentaBancaria cuentaencontrada= banco.buscarcuenta(titularnombre);
        if(cuentaencontrada==null){
            System.out.println("La cuenta no existe");
            return;
        }

        Menu menu=new Menu(cuentaencontrada, banco);
        menu.mostrarMenu();
    }
}
