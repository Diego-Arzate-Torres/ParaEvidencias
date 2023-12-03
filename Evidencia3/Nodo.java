package Evidencia3;


public class Nodo {
    String pregunta;
    String respuestaSi;
    String respuestaNo;

    Nodo hijoSi;
    Nodo hijoNo;

    public Nodo(String pregunta, String respuestaSi, String respuestaNo) {
        this.pregunta = pregunta;
        this.respuestaSi = respuestaSi;
        this.respuestaNo = respuestaNo;
        this.hijoSi = null;
        this.hijoNo = null;
    }
}