
package ejercicio4;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Agenda {

    private ArrayList<Contacto> contactos;
    private int cantidadContactos;

    // Constructor
    public Agenda() {
        contactos = new ArrayList<>();
        cantidadContactos = 0;
    }

    // 1. Agregar contacto
    public void agregarContacto(Contacto c) {
        if(!c.getTelefono().matches("[0-9]{9}")){
            System.out.println("el telefono debe tener exactamente 9 numeros");
            return;
        }
        
        if(!c.getEmail().contains("@") || !c.getEmail().contains(".")){
            System.out.println("el correo electronico no es valido. ");
            return;
        }


        for (int i = 0; i < contactos.size(); i++) {

            if (contactos.get(i).getNombre().equalsIgnoreCase(c.getNombre())
                    || contactos.get(i).getTelefono().equals(c.getTelefono())) {

                System.out.println("El contacto ya existe");
                return;
            }
        }

        contactos.add(c);
        System.out.println("Contacto agregado correctamente");
    }

    // 2. Buscar contacto
    public ArrayList<Contacto> buscarContacto(String nombre) {
        
        ArrayList<Contacto> encontrados= new ArrayList<>();
        boolean encontrado = false;

        for (int i = 0; i < contactos.size(); i++) {

            if (contactos.get(i).getNombre().toLowerCase().trim().contains(nombre.toLowerCase().trim())) {

                encontrados.add(contactos.get(i));
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado");
        }
        return encontrados;
    }

    // 3. Mostrar todos los contactos
    public void mostrarTodos() {

        if (contactos.size() == 0) {
            System.out.println("La agenda esta vacia");
            return;
        }

        for (int i = 0; i < contactos.size(); i++) {

            System.out.println("Contacto #" + (i + 1));
            contactos.get(i).mostrarInfo();
            System.out.println("---------------------");
        }
    }

    // 4. Eliminar contacto
public void eliminarContacto(String nombre) {

    for (int i = 0; i < contactos.size(); i++) {

        if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {

            contactos.remove(i);

            System.out.println("Contacto eliminado correctamente");
            return;
        }
    }

    System.out.println("Contacto no encontrado");
}
    
            public void mostrarContactosPorGrupo(String grupo){
                boolean encontrado= false;
            for(int i =0;i<contactos.size();i++){
                if(contactos.get(i).getGrupo().equalsIgnoreCase(grupo)){
                    contactos.get(i).mostrarInfo();
                    encontrado=true;
                }
            }
            if(!encontrado){
                System.out.println("no existe contactos en ese grupo.");
            }
        }
            
            public void guardarEnArchivo(){
                try (PrintWriter archivo = new PrintWriter("contactos.txt")){
                    for(int i =0 ; i<contactos.size(); i++){
                        Contacto c= contactos.get(i);
                        archivo.println(c.getNombre() + "\t" + c.getTelefono() + "\t" + c.getEmail() + "\t" + c.getGrupo()); // \t coloca una tabulacion para separar los datos
                    }
                    System.out.println("agenda guardada correctamente");
                }catch(IOException e){
                    System.out.println("Error al guardar los contactos: "+ e.getMessage());
                    
                }
            }
            public void cargarDesdeArchivo(){
                try(BufferedReader archivo= new BufferedReader(new FileReader("contactos.txt"))){
                    String linea;
                    while((linea=archivo.readLine())!= null){
                        String[] datos= linea.split("\t", -1);
                        if(datos.length==4){
                            Contacto c = new Contacto(datos[0], datos[1], datos[2], datos[3]);
                            agregarContacto(c);
                                    
                        }
                    }
                    System.out.println("Agenda cargada correctamente. ");
                }catch(IOException e){
                    System.out.println("Error al cargar los contactos: "+ e.getMessage());
                }
            }
}
