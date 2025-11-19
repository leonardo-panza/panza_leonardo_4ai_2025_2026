

void main() {


    //Stampo le istruzioni
    IO.println("""
            
            ----- Benvenuto/a al gioco del TRIS -----
            Si giocherà a turni, prima giocatore 1 (X), poi giocatore 2 (O)
            Per inserire il tuo simbolo, utilizza il tastierino numerico come se fosse la tabella di tris
            In questo modo:
            7 | 8 | 9 |
            ----------|
            4 | 5 | 6 |
            ----------|
            1 | 2 | 3 |
            Dopo aver inserito la casella desiderata, premere INVIO per confermare la scelta
            
            ----- PREMI INVIO PER COMINCIARE -----
            """);

    IO.readln();
    int celle_occupate = 0;
    boolean running = true;
    boolean err;
    int num = 0;
    char vinci = ' ';
    Griglia a = new Griglia();
    a.mostraGriglia();

    while (running ) {

        err = true;
        while (err) {
            err = false;
            IO.print("Giocatore 1 (X): ");
            String in = IO.readln();
            try {
                num = Integer.parseInt(in);
                if (num < 1 || num > 9) {
                    IO.println("Imposta un numero da 1 a 9");
                    err = true;
                }
            } catch (Exception e) {
                IO.println("Devi inserire un numero");
                err = true;
            }

            //Se va tutto bene provo a mettere la X
            if(!err) {
                try {
                    a.aggiungiX(num);
                } catch (Exception e) {
                    IO.println("Cella già occupata, scegli una cella libera!");
                    err = true;
                }
            }
        }

        //Dopo i controlli inserisco la X e mostro la griglia, incremento le celle occupate
        a.mostraGriglia();
        celle_occupate++;
        if(celle_occupate>=9){
            running  = false;
            IO.println("Pareggio!");
        }

        //Controllo se qualcuno ha vinto se ho fatto più di 2 turni
        if(celle_occupate>2) {
            vinci = a.check();
            if (vinci == 'X') {
                IO.println("\nVince la X!");
                running  = false;
            } else if (vinci == 'O') {
                IO.println("\nVince la O!");
                running  = false;
            }
        }

        //Controllo se X ha vinto durante la sua giocata
        if(running ){
            err = true;
            while (err) {
                err = false;
                IO.print("Giocatore 2 (O): ");
                String in = IO.readln();
                try {
                    num = Integer.parseInt(in);
                    if (num < 1 || num > 9) {
                        IO.println("Imposta un numero da 1 a 9");
                        err = true;
                    }
                } catch (Exception e) {
                    IO.println("Devi inserire un numero");
                    err = true;
                }

                //Se va tutto bene provo a mettere la X
                if(!err) {
                    try {
                        a.aggiungiO(num);
                    } catch (Exception e) {
                        IO.println("Cella già occupata, scegli una cella libera!");
                        err = true;
                    }
                }
            }

            //Mostro la griglia e incremento
            a.mostraGriglia();
            celle_occupate++;
            if(celle_occupate>=9){
                running  = false;
                IO.println("Pareggio!");
            }

            if(celle_occupate>2) {
                vinci = a.check();
                if (vinci == 'X') {
                    IO.println("\nVince la X!");
                    running  = false;
                } else if (vinci == 'O') {
                    IO.println("\nVince la O!");
                    running  = false;
                }
            }
        }

    }
}
