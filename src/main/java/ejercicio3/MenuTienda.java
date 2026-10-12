/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MenuTienda {
     public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
         System.out.println("--->           BIENVENIDOS A TECKNO MARKET         <---");
         System.out.println("Ingresa el nombre del usuario: ");
         String nombre = sc.nextLine();
         
         System.out.println("ingresa el correo electronico: ");
         String correo= sc.nextLine();
         
         Clientes cliente = new Clientes(nombre, correo);
        
        Productos[] productos= new Productos[5];
        
        productos[0]=new ProductoElectronico("Teclado",100000,10, "Perifericos",12);
        productos[1]= new ProductoElectronico("Mouse inalambrico",150000,5, "Perifericos",12);
        productos[2]= new ProductoElectronico("Monitor MSI 32 pulgadas", 1500000,11, "Monitores",12);
        productos[3]= new ProductoAlimenticio("papa criolla", 2000, 100, "alimento", "2026-10-15");
        productos[4]= new ProductoAlimenticio("pan de perro", 10000,32, "Alimento", "2026-10-20");
                
        Inventario inventario = new Inventario();
        for(int i=0; i<productos.length;i++){
            inventario.agregarProducto(productos[i]);
        }
        Carrito carrito=new Carrito(10,cliente, inventario);
        
        int opcion= 0;
        while(opcion!=4){
            System.out.println("=======tienda Online=============");
            System.out.println("1. Ver productos");
            System.out.println("2. comprar producto");
            System.out.println("3. ver facturas");
            System.out.println("4. salir");
            System.out.println("Selecciona una opcion: ");
            
            while(!sc.hasNextInt()){
                System.out.println("opcion equivocada vuelve a intentar debes ingresar numeros");
                sc.nextLine();
                System.out.println("selecciona una opcion: ");
            }
            opcion= sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                     System.out.println("Productos disponibles: ");
                     
                            for(int i =0; i<productos.length;i++){
                            System.out.println("producto "+(i+1)+" :"+productos[i].getnombre()+ 
                                    " precio: $"+productos[i].getPrecio()+
                                    " cantidad disponible: "+productos[i].getStock()+" unidades."
                                            + "categoria: "+ productos[i].getCategoria());
        }
                    break;
                case 2:
                    System.out.println("Ingresa la categoria que deseas consultar: ");
                    String categoriabuscada= sc.nextLine();
                    boolean encontrado= false;
                    for(int i =0;i<productos.length;i++){
                        if(productos[i].getCategoria().equalsIgnoreCase(categoriabuscada)){
                            System.out.println((i+1)+". "+productos[i].getnombre());
                            encontrado= true;
                        }
                    } 
                    if(!encontrado){
                        System.out.println("el producto no fue encontrado por esa categoria ");
                        break;
                    }
                    
                    System.out.println("ingresa el numero del producto que deseas comprar: ");
                    while(!sc.hasNextInt()){
                        System.out.println("la opcion debe ser numerica");
                        sc.nextLine();
                        System.out.println("ingresa el producto que deseas comprar");
                    }
                    int produc= sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Ingresa la cantidad del producto que deseas comprar: ");
                    while(!sc.hasNextInt()){
                        System.out.println("la cantidad debe ser numerica");
                        sc.nextLine();
                        System.out.println("Ingresa la cantidad del producto que deseas comprar: ");
                    }
                    
                    int cantiproduc= sc.nextInt();
                    sc.nextLine();
                    
                    
                    if(produc>=1 && produc <=productos.length){
                        Productos productoseleccionado= productos[produc-1];
                        if(productoseleccionado.getCategoria().equalsIgnoreCase(categoriabuscada)){
                        if(carrito.agregarproductos(productoseleccionado, cantiproduc)){
                            System.out.println("el producto se agrego correctamente en su carrito");
                        }else{
                            System.out.println("No se pudo agregar: stock insuficiente, cantidad invalida o carrito lleno");
                        }
                        }else{
                            System.out.println("el producto no pertenece a la categoria seleccionada");
                        }
                    }else{
                        System.out.println("el producto no existe verifique con cuidado");
                    }
                    break;
                case 3: 
                    carrito.Factura();
                    break;
                case 4: 
                    System.out.println("gracias por visitarnos");
                    break;
                default:
                    System.out.println("opcion invalida");
                    System.out.println("las opciones deben ser del 1 al 4");
            }
        }
    }
}


