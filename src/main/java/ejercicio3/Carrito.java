/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Carrito {
    private Productos[] productos;
    private int[] cantidades;
    private int cantidadProductos;
    private Clientes clientes;
    private Inventario inventario;
    
    public Carrito(int cantidad, Clientes pClientes, Inventario pInventario){
        
        productos= new Productos[cantidad];
        cantidades= new int[cantidad];
        cantidadProductos=0;
        clientes=pClientes;
        inventario=pInventario;
    }
    
    public void mostrarProducto(){
        for(int i =0; i<cantidadProductos;i++){
            System.out.println("el producto es: "+ productos[i].getnombre() +
                    " por el valor de: "+ productos[i].getPrecio()+ " disponibles: "+cantidades[i]);
        }
    }
    
    public boolean agregarproductos(Productos producto, int cantidad){
        if(cantidadProductos<productos.length && inventario.haystock(producto, cantidad)){
            productos[cantidadProductos]=producto;
            cantidades[cantidadProductos]= cantidad;
            cantidadProductos++;
            inventario.disminuirStock(producto, cantidad);
            return true;
        }return false;
        }
    
    public double calcularsubtotal(){
        double subtotal=0;
        for(int i = 0; i<cantidadProductos;i++){
        subtotal+= productos[i].getPrecio()* cantidades[i];
        }
        return subtotal;
    }
    
    public double calculardescuento(){
        double subtotal=calcularsubtotal();
        double descuento= 0;
        if(subtotal>1000000){
            descuento+= subtotal*0.10;
        }
        return descuento;
    }
    public double calcularTotal(){
        double subtotal=calcularsubtotal();
        double descuento=calculardescuento();
        double totalfinal= subtotal-descuento;
        return totalfinal;
    }
    
    public void Factura(){
        System.out.println("================    FACTURA     ================");
        System.out.println("Cliente: "+ clientes.getnombre());
        System.out.println("Email: "+clientes.getEmail());
        
        for(int i =0; i<cantidadProductos;i++){
            System.out.println("nombre del producto: "+ productos[i].getnombre()+
                    " precio del producto: "+ productos[i].getPrecio()+
                    " cantidad: "+cantidades[i]);
            
        }
        System.out.printf(Locale.of("es","CO"),"Subtotal: $%,.2f%n", calcularsubtotal());
        System.out.printf(Locale.of("es","CO"),"Descuento: $%,.2f%n", calculardescuento());
        System.out.printf(Locale.of("es","CO"),"total a pagar: $%,.2f%n", calcularTotal());
    }
    }
