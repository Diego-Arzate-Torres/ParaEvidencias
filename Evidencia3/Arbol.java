package Evidencia3;
import java.util.Scanner;

public class Arbol {
    Node raiz;
    Scanner scanner = new Scanner(System.in);

    public Arbol() {
        raiz = new Node("¿Tiene cuernos?", "La vaca", "El perro");
    }

    public void jugar() {
        jugar(raiz);
    }

    private void jugar(Node node) {
        System.out.println(node.pregunta);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("sí")) {
            if (node.hijoSi == null) {
                System.out.println("¿Es " + node.respuestaSi + "?");
                respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("¿Qué animal estabas pensando?");
                    String nuevoAnimal = scanner.nextLine();
                    System.out.println("¿Qué pregunta distinguiría a " + nuevoAnimal + " de " + node.respuestaSi + "?");
                    String nuevaPregunta = scanner.nextLine();
                    node.hijoSi = new Nodo(nuevaPregunta, nuevoAnimal, node.respuestaSi);
                }
            } else {
                jugar(node.hijoSi);
            }
        } else {
            if (node.hijoNo == null) {
                System.out.println("¿Es " + node.respuestaNo + "?");
                respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("¿Qué animal estabas pensando?");
                    String nuevoAnimal = scanner.nextLine();
                    System.out.println("¿Qué pregunta distinguiría a " + nuevoAnimal + " de " + node.respuestaNo + "?");
                    String nuevaPregunta = scanner.nextLine();
                    node.hijoNo = new Nodo(nuevaPregunta, nuevoAnimal, node.respuestaNo);
                }
            } else {
                jugar(node.hijoNo);
            }
        }
    }
}
