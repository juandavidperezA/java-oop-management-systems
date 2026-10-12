/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author USUARIO
 */
public class ProductoAlimenticio extends Productos{
    private String fechaCaducidad;
    
    public ProductoAlimenticio(String pNombre, double pPrecio, int pStock, String pCategoria,String pFechaCaducidad){
        super(pNombre,pPrecio,pStock,pCategoria);
        fechaCaducidad=pFechaCaducidad;
    }
    
    public String getMesesCaducidad(){
        return fechaCaducidad;
    }
}
