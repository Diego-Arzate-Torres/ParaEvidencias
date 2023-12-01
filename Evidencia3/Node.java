package Evidencia3;
public class Node {
    String pregunta;
    String respuestaSi;
    String respuestaNo;
    Nodo hijoSi;
    Nodo hijoNo;

    public Node(String pregunta, String respuestaSi, String respuestaNo) {
        this.pregunta = pregunta;
        this.respuestaSi = respuestaSi;
        this.respuestaNo = respuestaNo;
    }
}
