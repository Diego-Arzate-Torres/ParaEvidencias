package utilsMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Plantilla de menú para facilitar el ingreso de opciones en los demás proyectos, haciendo que no haya necesidad
 * de crear un menú en cada uno de ellos.
 * Crea los textos para elegir una opción, cuando el valor ingresado es incorrecto y cuando no es un número.
 *
 * @author eryxl
 * */

public class Menu {
    Scanner scanner = new Scanner(System.in);
        private final String Request_Option = "Por favor, ingrese una opción";

        private final String Type_Error = "El valor ingresado debe de ser un número, por favor introduzca un valor disponible.";

        private final String Invalid_Option = "Opción no disponible, por favor introduzca un número válido:";

        private ArrayList<String> optionList = new ArrayList<>();
        private ArrayList<MenuAction> actionList = new ArrayList<>();

        private boolean alive = true;

        public boolean isAlive(){
            return alive;
        }
        public void killMenu(){
            alive = false;
        }

    /**
     * Agregar una nueva opción al ArrayList
     * @param option la opción que se decide insertar desde otra clase
     * @return la opción
     */
    public Menu addOption(String option, MenuAction action) {
            optionList.add(option);
            actionList.add(action);
            return this;   //regresa el objeto, que en este caso sería la opción dentro del Arraylist
        }

        public void createMenu(){
            optionList.add("Terminar programa");
        }

       public void clearMenu() {
            optionList.clear();
        }


    /**
     * Imprime el menú con las opciones que se deseen, ya que esas se agregan como objetos del ArrayList
     */
        public void showMenu() {
            System.out.print("---- Menu ----\n");
            for (int i = 0; i < optionList.size(); i++){
                System.out.printf("%d.- %s\n", i + 1, optionList.get(i));
            }
            System.out.println();
            System.out.print(Request_Option);

        }

    /**
     * Lee el tipo de respuesta introducida por el usario, si no cuadra dentro del rango de opciones, marca opción inválida
     * Si es de un tipo diferente al que le estamos solicitando, marca opción no disponible
     *
     */
        public int readOption() {

            while (true) {

                try {
                    int numeroOpcion = scanner.nextInt(); scanner.nextLine();

                    if (numeroOpcion < 1 || numeroOpcion > actionList.size() + 1) {
                        System.out.print(Invalid_Option);
                        continue;
                    }
                    return numeroOpcion;
                } catch (InputMismatchException error) {
                    scanner.nextLine();
                    System.out.println(Type_Error);
                }
            }
        }
        public void selectAndRunOption(int option){
            if (option == optionList.size()){
                killMenu();
                System.out.println("Gracias \nSaliendo...");
                return;
            }
            actionList.get(option-1).run(scanner);
        }
    }
