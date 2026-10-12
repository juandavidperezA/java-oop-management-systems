/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author USUARIO
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    
    public CuentaCorriente(String titular, double saldo, int pin, double limiteSobregiro){
        super(titular,saldo,pin);
        this.limiteSobregiro=limiteSobregiro;
    }
    
    @Override
    public boolean retirar(double monto){
        if(monto>0 && monto<= saldo+limiteSobregiro){
            saldo-=monto;
            registrarMovimiento("retiro: -$"+monto);
            return true;
        }return false;
    }
}
