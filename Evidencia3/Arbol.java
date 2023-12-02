package Evidencia3;
import java.util.Scanner;


public class Arbol {

    Nodo raiz;
    Scanner scanner;

    public Arbol() {
        raiz = new Nodo("¿Tiene cuernos?", null, null);
        scanner = new Scanner(System.in); // Inicializa el Scanner
    }

    public void jugar() {
        jugar(raiz);
        preguntarSiJugarDeNuevo();
    }

    private void jugar(Nodo node) {
        if (node == null) {
            System.out.println("¡Error! El nodo es nulo.");
            return;
        }

        System.out.println(node.pregunta);
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("si")) {
            if (node.hijoSi == null) {
                System.out.println("¿Es " + node.respuestaSi + "?");
                respuesta = scanner.nextLine().toLowerCase();

                if (respuesta.equals("no")) {
                    System.out.println("¿Qué animal estabas pensando?");
                    String nuevoAnimal = scanner.nextLine();
                    System.out.println("¿Qué pregunta distinguiría a " + nuevoAnimal + " de " + node.respuestaSi + "?");
                    String nuevaPregunta = scanner.nextLine();
                    // Actualiza el nodo hijoSi correctamente
                    node.hijoSi = new Nodo(nuevaPregunta, nuevoAnimal, node.respuestaSi);
                } else {
                    // Importante: Si la respuesta es "si", simplemente juega con el nodo hijoSi existente
                    jugar(node.hijoSi);
                }
            } else {
                // Si el nodo hijoSi no es nulo, simplemente juega con él
                jugar(node.hijoSi);
            }
        } else if (respuesta.equals("no")) {
            if (node.hijoNo == null) {
                System.out.println("¿Es " + node.respuestaNo + "?");
                respuesta = scanner.nextLine().toLowerCase();

                if (respuesta.equals("no")) {
                    System.out.println("¿Qué animal estabas pensando?");
                    String nuevoAnimal = scanner.nextLine();
                    System.out.println("¿Qué pregunta distinguiría a " + nuevoAnimal + " de " + node.respuestaNo + "?");
                    String nuevaPregunta = scanner.nextLine();
                    // Actualiza el nodo hijoNo correctamente
                    node.hijoNo = new Nodo(nuevaPregunta, nuevoAnimal, node.respuestaNo);
                } else {
                    // Importante: Si la respuesta es "no", simplemente juega con el nodo hijoNo existente
                    jugar(node.hijoNo);
                }
            } else {
                // Si el nodo hijoNo no es nulo, simplemente juega con él
                jugar(node.hijoNo);
            }
        } else {
            System.out.println("Respuesta no válida. Por favor, responde 'si' o 'no'.");
            jugar(node); // Llamada recursiva para volver a preguntar
        }
    }

    private void preguntarSiJugarDeNuevo() {
        System.out.println("¿Deseas jugar de nuevo?");
        String opcion = scanner.nextLine();

        if (opcion.equals("si") || opcion.equals("sí")) {
            jugar();
        } else if (opcion.equals("no")) {
            System.out.println("Entendido, buen día!");
            scanner.close(); // Cierra el Scanner
        } else {
            System.out.println("Opción no válida, volviendo al menú principal.");
        }
    }
}