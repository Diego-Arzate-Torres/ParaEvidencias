package Evidencia3;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class BrainImplementation {
    private final String ENTRADA_VALIDA = "{1}?(si)|{1}?(no)|{1}?(sali)";
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
            int respuesta = -1;
            int ultimo = -1;

            while(!brainNode.tieneHoja()){
                respuesta =
            }
        }
    }
    public void empezar()
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
