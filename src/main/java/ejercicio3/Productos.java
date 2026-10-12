/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Usuario
 */
public class Productos {
     private String nombre;
    private double precio;
    private int stock;
    private String Categoria;
    
    
   public Productos(String pNombre, double pPrecio, int pStock, String pCategoria){
       nombre=pNombre;
       precio=pPrecio;
       stock=pStock;
       Categoria= pCategoria;
   }
   
   public String getnombre(){
       return nombre;
   }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    public String getCategoria(){
        return Categoria;
    }
   
   public boolean hayStock(int cantidad){
        return cantidad <= stock && cantidad >0;
   }
   
   public void disminuirstock(int cantidad){
       if(hayStock(cantidad)){
           stock-= cantidad;
       }
   }
}

