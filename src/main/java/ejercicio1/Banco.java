/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class Banco {
    private ArrayList<CuentaBancaria> cuentas;
    
    public Banco(){
        cuentas=new ArrayList<>();
    }
    
    public void agregarcuenta(CuentaBancaria cuenta){
        cuentas.add(cuenta);
    }
    
    public CuentaBancaria buscarcuenta(String titular){
    for(int i =0; i<cuentas.size();i++){
        CuentaBancaria actual = cuentas.get(i);
    if(titular.equalsIgnoreCase(actual.getTitular())){
        return actual;
    }
    }
    return null;
    }
    
    public boolean validarpin(String titular, int pin){
        CuentaBancaria encontrada=buscarcuenta(titular);
        
        if(encontrada!=null){
            return encontrada.validarpin(pin);
        }
        return false;
    }
}

