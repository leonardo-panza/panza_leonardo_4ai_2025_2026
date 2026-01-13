package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.files.FileHandle;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private int mouseX;
    private BitmapFont font;
    private String text;
    private boolean leftpressed;

    @Override
    //Qui carico file, risorse, immagini ecc.
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("lightbulb.png");
        FileHandle file = new FileHandle("prova.txt");
        text = file.readString();
        font = new BitmapFont();
    }


    @Override
    //Nel render non devo caricare file
    //Qui si sviluppa tutto il programma
    //Posso creare lampadine, ma non caricare sul momento la sua foto
    public void render() {
        //Lo suddivido in due parti: update e render. Update sistemo e aggiorno le variabili,
        //In render preparo la schermata adattata alle nuove variabili
        // Update application
        mouseX = Gdx.input.getX();
        leftpressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);

        // Render image
        ScreenUtils.clear(0,0,0,0); //reset
        batch.begin(); //avvio
        batch.draw(image, 0, 0);
        font.draw(batch, "Hello, World!", 100, 100); //Carico
        font.draw(batch, text, 100, 300);
        System.out.println("MouseX: " + mouseX + "Premuto: " + leftpressed);
        batch.end(); //Fine
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
