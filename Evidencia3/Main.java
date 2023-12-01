package Evidencia3;
public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        String jugarOtraVez;
        do {
            arbol.jugar();
            System.out.println("¿Quieres jugar otra vez?");
            jugarOtraVez = arbol.scanner.nextLine();
        } while (jugarOtraVez.equalsIgnoreCase("sí"));
    }
}