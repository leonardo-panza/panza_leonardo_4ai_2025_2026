import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Hanoi {

    Stack[] torri = new Stack[3];
    Stack<Integer> torre1 = new Stack<Integer>();
    Stack<Integer> torre2 = new Stack<Integer>();
    Stack<Integer> torre3 = new Stack<Integer>();
    private final int max_blocchi = 3;

    public Hanoi(){
        for(int i = 0; i<3; i++){
            torre1.push((3-i));
        }

        for(int i = 0; i<3; i++){
            torre2.push(0);
        }

        for(int i = 0; i<3; i++){
            torre3.push(0);
        }

        torri[0] = torre1;
        torri[1] = torre2;
        torri[2] = torre3;
    }

    public void inserisciBlocco(int col_rim, int col_add){
        col_rim--;
        col_add--;
        Object elem = torri[col_rim].pop();

        boolean appost = false;
        while(!appost) {
            if (torri[col_rim].size() != 3) {
                torri[col_rim].push(0);
            }else{
                appost = true;
            }
        }

        int blocco = (int) elem;

        boolean trovato = false;
        while(!trovato) {
            if (torri[col_add].peek().equals(0) && !torri[col_add].isEmpty()) {
                torri[col_add].pop();
                IO.println("Fatto");
                IO.println(torri[col_add]);
                IO.println(torri[col_add].isEmpty());
            }else{
                torri[col_add].push(blocco);
                trovato = true;
            }
        }

        appost = false;
        while(!appost) {
            if (torri[col_add].size() != 3) {
                torri[col_add].push(0);
            }else{
                appost = true;
            }
        }
    }

    public String toString(){
        return "-----\nStack 1: " + torre1.toString() + "\nStack 2: " + torre2.toString() + "\nStack 3: " + torre3.toString();
    }

}
