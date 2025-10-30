import java.util.LinkedList;
import java.util.Scanner;

public class Colas {
    private LinkedList<String> elementos;
    private Scanner scanner;

    public Colas() {
        this.elementos = new LinkedList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public int buscar(String elemento) {
        return elementos.indexOf(elemento);
    }
    
    public void mostrar() {
        if (elementos.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Elementos en la cola: " + elementos);
        }
    }

    
    public String eliminar() {
        if (!elementos.isEmpty()) {
            return elementos.removeFirst();
        } else {
            System.out.println("La cola está vacía. No hay elementos para eliminar.");
            return null;
        }
    }
    
    public void agregar(String elemento) {
        elementos.addLast(elemento);
        System.out.println("Elemento '" + elemento + "' agregado a la cola.");
    }
    
    public void menu() {
        int opcion;
        do {
            System.out.println("\n Menú de Cola ");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Mostrar cola");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String elementoAgregar = scanner.nextLine();
                    agregar(elementoAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a buscar: ");
                    String elementoBuscar = scanner.nextLine();
                    int posicion = buscar(elementoBuscar);
                    if (posicion != -1) {
                        System.out.println("El elemento '" + elementoBuscar + "' está en la posición: " + posicion);
                    } else {
                        System.out.println("El elemento '" + elementoBuscar + "' no está en la cola.");
                    }
                    break;
                case 3:
                    mostrar();
                    break;
                case 4:
                    String eliminado = eliminar();
                    if (eliminado != null) {
                        System.out.println("Elemento eliminado: " + eliminado);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    public static void main(String[] args) {
        Colas cola = new Colas();
        cola.menu();
    }
}