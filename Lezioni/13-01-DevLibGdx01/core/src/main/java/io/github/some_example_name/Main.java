package io.github.some_example_name;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Random r;
    private List<Lampadina> archivio = new ArrayList<Lampadina>();



    private SpriteBatch batch;
    private Texture image;
    private int mouseX;
    private BitmapFont font;
    private String text;
    private boolean leftpressed;
    private boolean accesa = false;
    private boolean prima = false;
    private Texture lamp;
    private TextureRegion lampSpenta, lampAccesa, lampRotta;
    private int volteAccese;
    private Lampadina l1;

    @Override
    //Qui carico file, risorse, immagini ecc.
    public void create() {
        r = new Random();
        batch = new SpriteBatch();
        image = new Texture("lightbulb.png");
        FileHandle file = new FileHandle("prova.txt");
        text = file.readString();
        font = new BitmapFont();

        lamp = new Texture("lightbulb.png");
        lampSpenta = new TextureRegion(lamp, 0, 0, 250,423);
        lampAccesa = new TextureRegion(lamp, 306, 0, 250, 423);
        lampRotta = new TextureRegion(lamp, 624, 0,250, 423);

        for(int i=0; i<200; i++){
            l1 = new Lampadina();
            l1.posiziona(r.nextInt(0, 760), r.nextInt(0, 548));
            archivio.add(l1);
        }

    }


    @Override
    //Nel render non devo caricare file
    //Qui si sviluppa tutto il programma
    //Posso creare lampadine, ma non caricare sul momento la sua foto
    public void render() {

        //Lo suddivido in due parti: update e render. Update sistemo e aggiorno le variabili,
        //In render preparo la schermata adattata alle nuove variabili
        // Update application
        mouseX = Gdx.input.getX(); // posizione X del mouse
        leftpressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
        boolean pPressed = Gdx.input.isKeyPressed(Input.Keys.P);
        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);


        // Render image
        ScreenUtils.clear(Color.BLACK); //reset
        batch.begin(); //avvio

        disegnaLampadine(archivio);

        if(leftpressed){
            for(Lampadina l: archivio){
                l.posiziona(r.nextInt(0, 770), r.nextInt(0, 550));
            }
        }

        if(isAPressed){
            int x = 0;
            int y = 0;
            for(Lampadina l: archivio){
                l.posiziona(x, y);
                x+= 40;
                if(x>760){
                    x = 0;
                    y+= 52;
                }
            }
        }

        if(pPressed) interruttore(archivio);

        batch.end(); //Fine
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public void disegnaLampadine(List<Lampadina> a){

        for (Lampadina l : a) {
            switch(l.getStato()){
                case SPENTA: batch.draw(lampSpenta, l.getX(), l.getY(), 30, 50); break;
                case ACCESA: batch.draw(lampAccesa, l.getX(), l.getY(), 30, 50); break;
                case ROTTA: batch.draw(lampRotta, l.getX(), l.getY()); break;
            }
        }

        font.draw(batch, "Lampadine in archivio : " + String.valueOf(a.size()), 10, 590);
    }

    public void togliLampadeBruciate(List<Lampadina> a){
        for(Lampadina l: a){
            if(l.getStato()==StatoLamp.ROTTA){
                a.remove(l);
            }
        }
    }

    public void interruttore(List<Lampadina> a){
        for(Lampadina l:a){
            l.interruttore();
        }
    }

    /*
    public void interruttore(List<Lampadina> a){
        boolean spente = false;
        boolean trovato = false;
        boolean errore = false;
        int i = 0;
        while(!trovato){
            if(a.get(i).getStato() == StatoLamp.ACCESA){
                spente = false;
                trovato = true;
            }else if(a.get(i).getStato() == StatoLamp.SPENTA){
                spente = true;
                trovato = true;
            }
            i++;
            if(i>a.size()) {
                trovato = true;
                errore = true;
            }
        }

        if(!errore){
            for (Lampadina l : a) {
                if (spente) {
                    l.accendi();
                } else {
                    l.spegni();
                }
            }
        }
    }
    */

}
