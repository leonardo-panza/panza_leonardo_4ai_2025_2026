/**
 * Classe NodoChat
 * Rappresenta un singolo nodo dell'albero binario.
 */
public class NodoChat {

    int valore;           // Valore contenuto nel nodo
    NodoChat sinistra;    // Riferimento al figlio sinistro
    NodoChat destra;      // Riferimento al figlio destro

    /**
     * Costruttore del nodo.
     * Quando creo un nodo, inizialmente non ha figli.
     */
    public NodoChat(int valore) {
        this.valore = valore;
        this.sinistra = null;
        this.destra = null;
    }
}