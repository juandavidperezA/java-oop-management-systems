/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class Inventario {
    private ArrayList<Productos> producto;
    
    public Inventario(){
        producto= new ArrayList<>();
    }
    
    public void agregarProducto(Productos p){
        producto.add(p);
    }
    
    public boolean haystock(Productos p, int cantidad){
        if(producto.contains(p)){
            return p.hayStock(cantidad);
        }return false;
    }   
    
    public void disminuirStock(Productos p, int cantidad){
        if(haystock(p, cantidad)){
            p.disminuirstock(cantidad);
        }
    }
}
