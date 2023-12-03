package Evidencia3;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Arbol arbol = new Arbol();
        String jugarOtraVez;

        do {
            System.out.println("-----------------------------------------");
            System.out.println("|        Adivinador de animales         |");
            System.out.println("-----------------------------------------");
            System.out.println("|            ¿Deseas jugar?             |");
            System.out.println("|                                       |");
            System.out.println("|        Si                   No        |");
            System.out.println("-----------------------------------------");

            jugarOtraVez = scanner.nextLine().toLowerCase();

            if (jugarOtraVez.equals("si") || jugarOtraVez.equals("sí")) {
                arbol.jugar();
            } else if (jugarOtraVez.equals("no")) {
                System.out.println("Tenga un buen día");
                scanner.close(); // Cerrar el Scanner
                return;
            } else {
                System.out.println("Esa opción no es válida, por favor ingrese una respuesta correcta.");
            }

        } while (true);
    }
}