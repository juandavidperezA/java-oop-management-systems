/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author USUARIO
 */
public abstract class Cuenta {
    protected String titular;
    protected double saldo;
    protected int pin;
    
    public Cuenta(String titular, double saldo, int pin) {
    this.titular = titular;
    this.saldo = saldo;
    this.pin = pin;
}
}
