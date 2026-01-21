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
    private boolean nome = false;
    private boolean prima = false;
    private Texture auto;
    private TextureRegion bianca, rossa, nera, gialla;
    private Texture bottoni;
    private TextureRegion nuovo, modifica, elimina, cerca;
    private Texture griglia;
    private int volteAccese;

    //TextField
    private Stage stage;
    private TextField textField;


    //Qui carico file, risorse, immagini ecc.
    public void create() {
        r = new Random();
        batch = new SpriteBatch();
        stage = new Stage();
        font = new BitmapFont();

        // === STAGE ===
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // === SFONDO DEL TEXTBOX ===
        Pixmap pm = new Pixmap(300, 40, Pixmap.Format.RGBA8888);
        pm.setColor(Color.WHITE);
        pm.fill();
        Drawable background = new TextureRegionDrawable(new TextureRegion(new Texture(pm)));
        pm.dispose();

        // === STILE DEL TEXTFIELD ===
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = font;
        style.fontColor = Color.BLACK;
        style.background = background;

        // === TEXTFIELD ===
        textField = new TextField("", style);
        textField.setMessageText("Scrivi qui...");
        textField.setPosition(50, 300);
        textField.setSize(300, 40);

        stage.addActor(textField);

        image = new Texture("auto.png");
        auto = new Texture("auto.png");
        bottoni = new Texture("bottoni.png");
        griglia = new Texture("griglia.png");
        bianca = new TextureRegion(auto, 0, 0, 500,314);
        rossa = new TextureRegion(auto, 0, 910, 500, 275);
        nera = new TextureRegion(auto, 0, 596,500, 314);
        gialla = new TextureRegion(auto, 0, 315,500, 281);
        modifica = new TextureRegion(bottoni, 0, 0, 143, 146);
        nuovo = new TextureRegion(bottoni, 145, 0, 147, 146);
        elimina = new TextureRegion(bottoni, 295, 0, 139, 146);
        cerca = new TextureRegion(bottoni, 444, 0, 138, 146);

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
        boolean enter = Gdx.input.isKeyPressed(Keys.ENTER);
        if(isAPressed) nome = true;
        if(enter) nome = false;

        // Render image

        // aggiornamento stage
        stage.act();

        ScreenUtils.clear(Color.MAGENTA); //reset
        batch.begin(); //avvio

        /*
        batch.draw(rossa, 0, 0, 250, 150);
        batch.draw(gialla, 250, 0, 250, 150);
        batch.draw(nera, 0, 150, 250, 150);
        batch.draw(bianca, 250, 150, 250, 150);
        */

        batch.draw(nuovo, 250, 300, 25,25);
        batch.draw(modifica, 300, 300, 25, 25);
        batch.draw(elimina, 350, 300, 25, 25);
        batch.draw(cerca, 400, 300, 25, 25);


        batch.end(); //Fine

        // disegna UI (textbox)
        if(nome) {
            stage.draw();
        }

        // tuo codice
        if(enter) {
            System.out.println("Hai scritto: " + textField.getText());
        }


    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

}
