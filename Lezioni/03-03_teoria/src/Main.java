
public int Fattoriale(int n){
    if(n==1) return 1;
    IO.println(n);
    Fattoriale(n-1);
    return n;
}

public int Fibonacci(int n){
    if(n==1 || n==2){
        return 1;
    }

    return 2;

}

void main() {

    Fattoriale(10);

}
