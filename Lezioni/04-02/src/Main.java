

void main() {

    Personaggio p1 = new Guerriero("Metrac");
    Personaggio p2 = new Guerriero("Templar");
    Mago p3 = new Mago("Merlino");


    Zombie zombie = new Zombie("Stratson");
    zombie.cattura(p1);
    zombie.cattura(p2);
    zombie.cattura(p3);

    IO.println(zombie);


}