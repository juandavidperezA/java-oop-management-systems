/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author USUARIO
 */
public class ProductoElectronico extends Productos{
    private int mesesGarantia;
    
    public ProductoElectronico(String pNombre, double pPrecio, int pStock, String pCategoria, int pMesesGarantia){
        super(pNombre,pPrecio,pStock,pCategoria);
        mesesGarantia= pMesesGarantia;
    }
    
    public int getmesesgarantia(){
        return mesesGarantia;
    }
}
