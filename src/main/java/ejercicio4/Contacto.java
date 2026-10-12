/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Usuario
 */
public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String grupo;
    
    public Contacto(String pNombre, String pTelefono, String pEmail,String pGrupo){
            nombre=pNombre;
            telefono= pTelefono;
            email= pEmail;
            grupo= pGrupo;
}
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getGrupo(){
        return grupo;
    }
    public void mostrarInfo(){
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Telefono:"+ getTelefono());
        System.out.println("Email (Correo): "+ getEmail());
    }
    
}
