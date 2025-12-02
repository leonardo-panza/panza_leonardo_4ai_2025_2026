

void main() {

    List<Integer> dischi = new ArrayList<>();
    dischi.add(2);
    dischi.add(1);

    Rastrelliera r = new Rastrelliera(3, 5, dischi);

    IO.println("""
            
            --- ISTRUZIONI DI GIOCO ---
            In questa versione "orizzontale" di Hanoi, le colonne sono 
            mostrate come delle righe, in questo modo, in base al numero di colonne scelte: 
            1: [X, X, X]
            2: []
            3: []
            ...
            
            "X" indicano i numeri delle colonne, che indicano la grandezza del disco.
            Per esempio, come un disco grande non può essere posizionato sul disco piccolo
            nella versione grafica di Hanoi, il numero 5 (per esempio) non può essere 
            posizionato sopra (a destra) del numero 2.
            
            Le regole del gioco Hanoi si possono trovare qui:
            https://it.wikipedia.org/wiki/Torre_di_Hanoi
            
            <<< BUON DIVERTIMENTO >>>
            """);

    boolean err = true;
    boolean running = true;
    while(running) {
        IO.println(r.toString());
        err = true;
        while(err) {
            err = false;
            try {
                String a = IO.readln("Disco da estrarre: ");
                int a_pos = Integer.parseInt(a);
                String b = IO.readln("Torre dove inserirlo: ");
                int b_pos = Integer.parseInt(b);

                try {
                    r.spostaDisco(a_pos, b_pos);
                }catch(Exception e){
                    IO.println(e.getMessage());
                    err = true;
                }

            }catch(Exception e){
                IO.println("Inserisci un numero intero!");
                err = true;
            }
        }

        boolean vincita = r.vittoria();
        if(vincita){
            IO.println(r.toString());
            IO.println("Hai vinto! Congratulazioni!");
            running = false;
//        }else{
//            IO.println("Prosegui!");
        }
    }
}
