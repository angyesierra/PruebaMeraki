import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Biblioteca {

    private List<Libro> librosDisponibles;
    private Map<Usuario, Libro> librosPrestados;



    public Biblioteca() {
        librosDisponibles = new ArrayList<>();
        librosPrestados = new HashMap<>();
    }

    public void agregarLibroCatalogo(Libro libro){
        librosDisponibles.add(libro);
    }

    public void prestarLibro(Usuario usuario, Libro libro){
        if (librosDisponibles.contains(libro)) {
            librosDisponibles.remove(libro);
            librosPrestados.put(usuario, libro);
        }else{
            System.out.println("El libro no esta disponible");
        }
    }

    //TODO:Devolver libro
    public void devolverLibro(String usuarioD, String libroD) {
        Iterator<Map.Entry<Usuario, Libro>> iterator = librosPrestados.entrySet().iterator();
        boolean libroDevuelto = false;
    
        while (iterator.hasNext()) {
            Map.Entry<Usuario, Libro> entry = iterator.next();
            Usuario usuario = entry.getKey();
            Libro libro = entry.getValue();
    
            if (libro.getTitulo().equals(libroD) && usuario.getNombre().equals(usuarioD)) {
                iterator.remove();
                librosDisponibles.add(libro);
                libroDevuelto = true;
                break; 
            }
        }
    
        if (libroDevuelto) {
            System.out.println("El libro ha sido devuelto con éxito.");
        } else {
            System.out.println("El libro no está prestado a este usuario.");
        }
    }
    

    

    public void catalogoLibros(){
        System.out.println("Catalogo de Libros");
        for(Libro libro: librosDisponibles){
            System.out.println("Titulo: " + libro.getTitulo() + 
            " Autor: " + libro.getAutor() +
            " Año Publicación: " + libro.getAñoPublicacion());
        }
    }

    public List<Libro> librosDisponibles() {
        return new ArrayList<>(librosDisponibles);
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados actualmente:");
        for (Map.Entry<Usuario, Libro> entry : librosPrestados.entrySet()) {
            Usuario usuario = entry.getKey();
            Libro libro = entry.getValue()  ;
            System.out.println("Libro: " + libro.getTitulo() + " prestado a: " + usuario.getNombre());
        }
    }


}