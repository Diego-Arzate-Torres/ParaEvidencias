package evidencia1;

import evidencia1.ui.CLI;

/**
 * La clase Main es la clase principal de la aplicación.
 */
public class Main {

    /**
     * El método main es el punto de entrada de la aplicación.
     *
     * @param args Los argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.start();
    }
}