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



    private SpriteBatch batch;
    private Texture image;
    private int mouseX;
    private BitmapFont font;
    private String text;
    private boolean leftpressed;
    private boolean accesa = false;
    private boolean prima = false;
    private Texture auto;
    private TextureRegion bianca, rossa, nera, gialla;
    private int volteAccese;

    @Override
    //Qui carico file, risorse, immagini ecc.
    public void create() {
        r = new Random();
        batch = new SpriteBatch();
        image = new Texture("auto.png");
        font = new BitmapFont();

        auto = new Texture("auto.png");
        bianca = new TextureRegion(auto, 0, 0, 500,314);
        rossa = new TextureRegion(auto, 0, 910, 500, 275);
        nera = new TextureRegion(auto, 0, 596,500, 314);
        gialla = new TextureRegion(auto, 0, 315,500, 281);


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

        batch.draw(rossa, 0, 0, 250, 150);
        batch.draw(gialla, 250, 0, 250, 150);
        batch.draw(nera, 0, 150, 250, 150);
        batch.draw(bianca, 250, 150, 250, 150);

        batch.end(); //Fine
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

}
