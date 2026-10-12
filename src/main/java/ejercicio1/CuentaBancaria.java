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
public class CuentaBancaria extends Cuenta {
    private ArrayList<String> historial;
    
    public CuentaBancaria(String pTitular, double pSaldo, int pPin){
        super(pTitular, pSaldo, pPin);
        historial= new ArrayList<>();
    }
    
    public String getTitular() {
        return titular;
    }
    public double consultaSaldo(){
        return saldo;
    }
    
    public void depositar(double monto){
        if(monto>0){
            saldo+=monto;
            registrarMovimiento("Deposito: +$"+monto);
        }
    }
    
    public boolean retirar(double monto){
        if(monto>0 && monto<=saldo){
            saldo-=monto;
            registrarMovimiento("retiraste: -$"+monto);
            return true;
        }return false;
    }
    

    public boolean validarpin(int pinIngresado){
        return pin== pinIngresado;
    }
    
    public void registrarMovimiento(String movimiento){
        historial.add(movimiento);
        
        if(historial.size()>5){
            historial.remove(0);
        }
    }
    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {

            if (cuentaDestino == null || cuentaDestino == this || monto <= 0) {
                 return false;
            }

            if (saldo < monto) {
                return false;
            }

            saldo -= monto;
            cuentaDestino.saldo += monto;

            registrarMovimiento("Transferencia enviada: -$" + monto);
            cuentaDestino.registrarMovimiento("Transferencia recibida: +$" + monto);

            return true;
        }
    public void mostrarmovimientos(){
        
        if(historial.isEmpty()){
            System.out.println("No hay movimientos registrados");
            return;
        }
        System.out.println("==========      Historial de Movimientos      ==========");
        for(int i =0; i<historial.size();i++){
            System.out.println(historial.get(i));
        }
    }
}
