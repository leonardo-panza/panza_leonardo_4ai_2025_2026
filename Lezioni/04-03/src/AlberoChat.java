/**
 * Classe AlberoChat
 * Implementa un Albero Binario di Ricerca (BST).
 *
 * PROPRIETA' DEL BST:
 * - Tutti i numeri minori del nodo vanno nel sottoalbero sinistro
 * - Tutti i numeri maggiori del nodo vanno nel sottoalbero destro
 */
public class AlberoChat {

    private NodoChat radice; // Nodo principale dell'albero

    /**
     * Costruttore.
     * Il primo numero inserito diventa la radice.
     */
    public AlberoChat(int valoreIniziale) {
        radice = new NodoChat(valoreIniziale);
    }

    /**
     * Metodo pubblico per aggiungere un numero.
     * Chiama il metodo ricorsivo privato.
     */
    public void aggiungiNumero(int n) {
        radice = aggiungiRicorsivo(radice, n);
    }

    /**
     * Metodo ricorsivo per inserire un numero.
     *
     * ALGORITMO:
     * 1. Se il nodo corrente è null → creo un nuovo nodo.
     * 2. Se n < valore del nodo → vado a sinistra.
     * 3. Se n > valore del nodo → vado a destra.
     * 4. Restituisco il nodo aggiornato.
     */
    private NodoChat aggiungiRicorsivo(NodoChat corrente, int n) {

        // Caso base: ho trovato una posizione vuota
        if (corrente == null) {
            return new NodoChat(n);
        }

        // Se il numero è minore → vai a sinistra
        if (n < corrente.valore) {
            corrente.sinistra = aggiungiRicorsivo(corrente.sinistra, n);
        }
        // Se il numero è maggiore → vai a destra
        else if (n > corrente.valore) {
            corrente.destra = aggiungiRicorsivo(corrente.destra, n);
        }

        // Se è uguale non facciamo nulla (evitiamo duplicati)

        return corrente;
    }

    // =============================
    // METODI DI VISITA DELL'ALBERO
    // =============================

    /**
     * VISITA INORDER
     * Sinistra → Nodo → Destra
     *
     * Nei BST stampa i numeri in ordine crescente!
     */
    public void stampaInOrder() {
        stampaInOrderRic(radice);
        System.out.println();
    }

    private void stampaInOrderRic(NodoChat nodo) {
        if (nodo != null) {
            stampaInOrderRic(nodo.sinistra);
            System.out.print(nodo.valore + " ");
            stampaInOrderRic(nodo.destra);
        }
    }

    /**
     * VISITA PREORDER
     * Nodo → Sinistra → Destra
     */
    public void stampaPreOrder() {
        stampaPreOrderRic(radice);
        System.out.println();
    }

    private void stampaPreOrderRic(NodoChat nodo) {
        if (nodo != null) {
            System.out.print(nodo.valore + " ");
            stampaPreOrderRic(nodo.sinistra);
            stampaPreOrderRic(nodo.destra);
        }
    }

    /**
     * VISITA POSTORDER
     * Sinistra → Destra → Nodo
     */
    public void stampaPostOrder() {
        stampaPostOrderRic(radice);
        System.out.println();
    }

    private void stampaPostOrderRic(NodoChat nodo) {
        if (nodo != null) {
            stampaPostOrderRic(nodo.sinistra);
            stampaPostOrderRic(nodo.destra);
            System.out.print(nodo.valore + " ");
        }
    }

}