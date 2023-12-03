package Evidencia3;

import java.io.*;
import java.util.Scanner;

public class BrainImplementation implements Serializable {
    private final String ENTRADA_VALIDA = "(si|no|salir)";


    private BrainNode brainNode;
    private Stream stream;
    private Scanner scanner;

    public BrainImplementation(){
        stream = new Stream();
        scanner = new Scanner(System.in);

        if(stream.existeArchivo()){
            stream.leerGuardado();
            System.out.println("Archivo cargado");
        }else{
            brainNode = new BrainNode();
            brainNode.iniciarNodo();
            System.out.println("Nuevo Adivinador creado");
        }
        System.out.println();
    }
    public void jugar(){
        stream.escribirGuardar();
        try{
            Thread.sleep(2000);
            empezar();
            Thread.sleep(2000);
        }catch (InterruptedException interruptedException){
            System.out.println(interruptedException);
        }

        for( ; ; ){
            String actual = brainNode.getData(brainNode.actual);
            int respuesta;
            int ultimo = 0;

            while(!brainNode.tieneHoja()){
                respuesta = preguntar(actual);
                ultimo = respuesta;

                revisarRespuesta(respuesta);

                brainNode.actualizarActual(respuesta);
                actual = brainNode.getData(brainNode.getActual());
            }
            try {
                Thread.sleep(2000);
                System.out.println("Mhm... creo que lo tengo, sí...");
                Thread.sleep(1500);
            }catch (InterruptedException interruptedException){
                System.out.println(interruptedException);
            }
            System.out.println();
            System.out.println("Tu animal... ¡tu animal es " + getAnimal() + " !");
            respuesta = getRespuesta();
            revisarRespuesta(respuesta);

            if(respuesta == 1){
                System.out.println("¡Nunca dudé de mí! ¡Gané!");
            }else {
                System.out.println("Ha... casi, sí.. casi, por poco gano");
                aprender(ultimo);
            }
            brainNode.reset();
            System.out.println("¿Te gustaría jugar otra vez?");

            if(getRespuesta() == 0){
                System.out.println("Más que entendible, ¡Hasta luego!");
                break;
            }
            System.out.println();
            empezar();
        }
    }
    public void empezar(){
        try {
            System.out.println("Hola, me llamo Bean Jr.");
            Thread.sleep(1000);
            System.out.println("Piensa en un animal, y yo intentaré adivinarlo");
            System.out.println("Eso sí, recuerda sólo contestar SI o NO");
        }catch (InterruptedException interruptedException){
            System.out.println(interruptedException);
        }
    }
    public int preguntar(String pregunta){
        if(pregunta == null){
            System.out.println(pregunta);
            System.out.println();
            return getRespuesta();
        }else{
            System.out.println("Ups. No tengo una pregunta que hacer");

            return -1;
        }
    }
    public void aprender(int ultimo){
        String pregunta = "";
        String animal = "";
        boolean aprendiendo = true;
        while (aprendiendo){
            animal = getAnimal();
            pregunta = getPregunta();

            System.out.println("    ¿" + pregunta.toUpperCase() +
                    "aplica para" + animal.toUpperCase() + "?");
            System.out.println("¿Es correcto?");
            if (getRespuesta() == 1){
                aprendiendo = false;
            }
        }
        System.out.println();
        brainNode.insertarNodo(pregunta, animal, ultimo);

        stream.escribirGuardar();
        System.out.println("¡Guardado!");
    }

    // MÉTODOS

    public int getRespuesta(){
        String entrada;
        entrada = scanner.next();

        while (!entrada.matches(ENTRADA_VALIDA)){
            System.out.println("Esa entrada es inválida, lo siento mucho");
            entrada = scanner.next();
        }
        if(entrada.toUpperCase() == "SI"){
            return 1;
        } else if (entrada.toUpperCase() == "NO") {
            return 0;
        } else if (entrada.toUpperCase() == "SALIR") {
            System.out.println("Gracias. Saliendo del programa.");
            System.exit(0);
        }else{
            System.out.println("¡Oh no! Algo salió mal. ¿Seguro pusiste una entrada correcta?");
        }
        return 0;
    }
    public String getAnimal(){
        String animal;
        System.out.println("¿En qué animal estás pensando?");
        System.out.println("    >> ");
        scanner.nextLine();
        animal = scanner.next().toLowerCase();
        return animal.substring(0,1).toUpperCase() + animal.substring(1);
    }
    public String getPregunta(){
        String pregunta;
        System.out.println("Suponiendo que le hubiera atinado a tu animal, " +
                "¿qué pregunta crees que habría hecho?");
        System.out.println("    >> ");
        scanner.nextLine();
        pregunta = formato(scanner.nextLine().toLowerCase());
        return pregunta.substring(0,1).toUpperCase() + pregunta.substring(1);
    }
    public String formato(String s){
        return s.replaceAll("\\s+"," ") .trim();
    }

    public void revisarRespuesta(int respuesta){
        if(respuesta == 1){
            System.out.println("Ups. Otra vez algo anda mal. Revisa tu respuesta");
            System.exit(respuesta);
        }
    }



    private class Stream {
        private final String GUARDAR_ARCHIVO = "guardar_archivo.txt";
        public Stream(){
            System.out.println("Se inició el archivo");
        }
        public void leerGuardado(){
            try {
                FileInputStream fis = new FileInputStream(GUARDAR_ARCHIVO);
                ObjectInputStream ois = new ObjectInputStream(fis);
                brainNode = (BrainNode) ois.readObject();
                ois.close();
            }catch (FileNotFoundException fileNotFoundException){
                // Sería el error si no encuentra el archivo
                System.out.println(fileNotFoundException);
            }catch (IOException | ClassNotFoundException exception){
                // Sería el error si algo pasa al escribir o leer
                System.out.println(exception);
            }
        }
        public void escribirGuardar(){
            try{
                FileOutputStream fos = new FileOutputStream(GUARDAR_ARCHIVO);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(brainNode);
                oos.close();
            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException);
            }catch (IOException ioException){
                System.out.println(ioException);
            }
        }
        public boolean existeArchivo(){
            return new File (GUARDAR_ARCHIVO).isFile();
        }
    }

}
