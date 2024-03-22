import java.util.Map;
import java.util.Scanner;

public class Main {
//Hora Inicion 12:04 AM
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Boolean activo = true;

        while (activo) {
            System.out.println("Bienvenido a la Biblioteca");
            System.out.println("\nMenú");
            System.out.println("(1) Agregar Libro");
            System.out.println("(2) Prestar Libro" );
            System.out.println("(3) Devolver Libro");
            System.out.println("(4) Cátalogo libros");
            System.out.println("(5) Libros Prestados");
            System.out.println("(6) Salir");
            System.out.println("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                System.out.println("Titulo del libro: ");
                String titulo = scanner.nextLine();

                System.out.println("Autor del libro: ");
                String autor = scanner.nextLine();
                
                System.out.println("Año de publicación del libro: ");
                String añoP = scanner.nextLine();

                System.out.println("\nSe agrego el libro con exito :D ");

                biblioteca.agregarLibroCatalogo(new Libro(titulo, autor, añoP));
                    break;

                case 2:
                Libro libroPrestado = null;

                System.out.println("Usuario a quien se presta el libro: ");
                String usuario =  scanner.nextLine();

                System.out.println("Libro a prestar: ");
                String libroP = scanner.nextLine();

                Usuario usuarioLibroPrestado = new Usuario(1, usuario);
                for(Libro libro : biblioteca.librosDisponibles()){
                    if (libro.getTitulo().equals(libroP)) {
                        libroPrestado = libro;
                        System.out.println("\n Disfruta tu libro");
                        break;
                        
                    }
                }
                if (libroPrestado != null) {
                    try{
                        biblioteca.prestarLibro(usuarioLibroPrestado, libroPrestado);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }else{
                    System.out.println("Libro no disponible, escoge otro ");
                }
                    break;
                
                case 3:
                System.out.println("Usuario quien devuelve el libro: ");
                String usuarioDevuelve = scanner.nextLine();

                System.out.println("Libro a devolver: ");
                String libroDevolver = scanner.nextLine();

                biblioteca.devolverLibro(usuarioDevuelve, libroDevolver);

                break;

                case 4:
                biblioteca.catalogoLibros();
                    break; 
                
                case 5:
                biblioteca.mostrarLibrosPrestados();
                    break;
                
                case 6:
                System.out.println("Adios");
                activo=false;
                    break;

                default:
                System.out.println("Ingrese una opción valida");
                    break;
            }

        }

    }
}