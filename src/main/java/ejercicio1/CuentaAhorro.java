/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author USUARIO
 */
public class CuentaAhorro extends CuentaBancaria{
    
    public CuentaAhorro (String pTitular, double pSaldo, int pPin){
        super(pTitular,pSaldo,pPin);
    }
    @Override
    public void depositar(double monto){
        if(monto>0){
            super.depositar(monto);
            double interes= monto*0.02;
            super.depositar(interes);
            
        }
    }
}
