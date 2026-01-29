package io.github.some_example_name;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Random r;



    private SpriteBatch batch;
    private Texture image;
    private int mouseX;
    private int mouseY;
    private BitmapFont font;
    private String text;
    private boolean leftpressed;
    private boolean nome = false;
    private boolean prima = false;
    private Texture auto;
    private TextureRegion bianca, rossa, nera, gialla;
    private Texture strada;
    private Texture bottoni;
    private TextureRegion nuovo, elimina;
    boolean spawnRossa = false;
    boolean spawnGialla = false;
    boolean spawnNera = false;
    private float xRossa = 0;
    private float xNera = 0;
    private float xGialla = 0;
    private int mRossa = 0;
    private int mNera = 0;
    private int mGialla = 0;
    private boolean avantiRossa, avantiGialla, avantiNera;
    float velocita;


    //Qui carico file, risorse, immagini ecc.
    public void create() {
        r = new Random();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2f);
        image = new Texture("auto.png");
        auto = new Texture("auto.png");
        strada = new Texture("road.png");
        bottoni = new Texture("bottoni.png");
        bianca = new TextureRegion(auto, 0, 0, 500,314);
        rossa = new TextureRegion(auto, 0, 910, 500, 275);
        nera = new TextureRegion(auto, 0, 596,500, 314);
        gialla = new TextureRegion(auto, 0, 315,500, 281);
        nuovo = new TextureRegion(bottoni, 145, 0, 146, 146);
        elimina = new TextureRegion(bottoni, 290, 0, 146, 146);

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
        mouseY = Gdx.input.getY();
        leftpressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
        boolean pPressed = Gdx.input.isKeyPressed(Input.Keys.P);
        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean enter = Gdx.input.isKeyPressed(Keys.ENTER);
        if(isAPressed) nome = true;
        if(enter) nome = false;

        // Render image


        ScreenUtils.clear(Color.MAGENTA); //reset
        batch.begin(); //avvio

        batch.draw(strada, 0, 400, 800, 200);
        batch.draw(strada, 0, 200, 800, 200);
        batch.draw(strada, 0, 0, 800, 200);
        batch.draw(nuovo, 20, 550, 30, 30);
        batch.draw(nuovo, 20, 350, 30, 30);
        batch.draw(nuovo, 20, 150, 30, 30);
        batch.draw(elimina, 760, 150, 30, 30);
        batch.draw(elimina, 760, 350, 30, 30);
        batch.draw(elimina, 760, 550, 30, 30);

        if(leftpressed && mouseX<50 && mouseX>20 && mouseY<450 && mouseY>420) spawnNera = true;
        if(leftpressed && mouseX<50 && mouseX>20 && mouseY<250 && mouseY>220) spawnGialla = true;
        if(leftpressed && mouseX<50 && mouseX>20 && mouseY<50 && mouseY>20) spawnRossa = true;

        if(leftpressed && mouseX<790 && mouseX>760 && mouseY<450 && mouseY>420) {
            spawnNera = false;
            xNera = 0;
        }
        if(leftpressed && mouseX<790 && mouseX>760 && mouseY<250 && mouseY>220) {
            spawnGialla = false;
            xGialla = 0;
        }
        if(leftpressed && mouseX<790 && mouseX>760 && mouseY<50 && mouseY>20) {
            spawnRossa = false;
            xRossa = 0;
        }

        if(spawnRossa) disegnaRossa();
        if(spawnGialla) disegnaGialla();
        if(spawnNera) disegnaNera();

        font.draw(batch, "Metri percorsi: " + mRossa, 260, 580);
        font.draw(batch, "Metri percorsi: " + mGialla, 260, 380);
        font.draw(batch, "Metri percorsi: " + mNera, 260, 180);

        batch.end(); //Fine

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    void disegnaRossa(){
        batch.draw(rossa, xRossa, 420, 150, 75);
        if(xRossa >= 650){
            avantiRossa = false;
        }else if(xRossa <= 0){
            avantiRossa = true;
        }
        if(avantiRossa) xRossa += 3; else xRossa -= 3;

        if(xRossa%30==0) mRossa++;
    }

    void disegnaGialla(){
        batch.draw(gialla, xGialla, 220, 150, 75);
        if(xGialla >= 650){
            avantiGialla = false;
        }else if(xGialla <= 0){
            avantiGialla = true;
        }
        if(avantiGialla) xGialla += 3; else xGialla-= 3;

        if(xGialla%30==0) mGialla++;
    }

    void disegnaNera(){
        batch.draw(nera, xNera, 20, 150, 75);
        if(xNera >= 650){
            avantiNera = false;
        }else if(xNera <= 0){
            avantiNera = true;
        }
        if(avantiNera) xNera += 3; else xNera -= 3;
        if(xNera%30==0) mNera++;

    }
}
