/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author USUARIO
 */
public class Clientes {
    private String nombre;
    private String email;
    
    public Clientes(String pNombre, String pEmail){
        nombre= pNombre;
        email=pEmail;
    }
    
    public String getnombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
}
