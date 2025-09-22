//Creo una funzione Capitalize

public static String capitalize(String stringa){

    String risultato = "";
    char carattere;

    for(int i = 0; i < stringa.length(); i++){

        char c = stringa.charAt(i);

        if (i == 0 || stringa.charAt(i - 1) == ' ') {

            carattere = Character.toUpperCase(c);

        } else {

            carattere = c;

        }

        risultato = risultato + carattere;
    }

    return risultato;
}

void main(){
    String stringa = " prova della funzione     con spazi  Prova";
    String cambiata = capitalize(stringa);
    IO.println(stringa);
    IO.println(cambiata);
}