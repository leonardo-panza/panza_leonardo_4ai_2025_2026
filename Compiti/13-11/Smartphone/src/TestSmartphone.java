

void main() {

    Smartphone smartphone1 = new Smartphone();
    smartphone1.setMarca(IO.readln("Marca del telefono: "));
    smartphone1.setModello(IO.readln("Modello del telefono: "));
    smartphone1.setNumPollici(Double.parseDouble(IO.readln("Numero di pollici: ")));
    smartphone1.setPrezzoDiLancio(Double.parseDouble(IO.readln("Prezzo di lancio dello smartphone: ")));
    smartphone1.setRam(Double.parseDouble(IO.readln("RAM dello smartphone: ")));

    boolean touch = false;
    String a = IO.readln("Ha il touchscreen? (si o no): ");
    if(a.equals("si") || a.equals("sì")) touch = true;
    smartphone1.setTouchscreen(touch);


    String marca = IO.readln("Marca del telefono: ");
    String modello = IO.readln("Modello del telefono: ");
    String p = IO.readln("Numero di pollici: ");
    double pollici = Double.parseDouble(p);
    String prz = IO.readln("Prezzo di lancio dello smartphone: ");
    double prezzo = Double.parseDouble(prz);
    String r = IO.readln("RAM dello smartphone: ");
    double ram = Double.parseDouble(r);

    boolean touch2 = false;
    String b = IO.readln("Ha il touchscreen? (si o no): ");
    if(b.equals("si") || b.equals("sì")) touch2 = true;
    smartphone1.setTouchscreen(touch2);


    Smartphone smartphone2 = new Smartphone(marca, modello, prezzo, pollici, ram, touch2);



}
