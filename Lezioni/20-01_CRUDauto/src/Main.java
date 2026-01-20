package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Main extends ApplicationAdapter {

    private Stage stage;
    private Skin skin;
    private TextField textField;
    private TextButton btnScrivi, btnFine;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        // Bottone che mostra il campo di testo
        btnScrivi = new TextButton("Scrivi", skin);
        btnScrivi.setPosition(50, 400);

        // Bottone che nasconde il campo di testo
        btnFine = new TextButton("Fine", skin);
        btnFine.setPosition(150, 400);

        // Campo di testo (inizialmente nascosto)
        textField = new TextField("", skin);
        textField.setMessageText("Scrivi qui...");
        textField.setPosition(50, 350);
        textField.setSize(200, 40);
        textField.setVisible(false);

        // Listener bottone "Scrivi"
        btnScrivi.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                textField.setVisible(true);
                textField.setText("");
                textField.setFocusTraversal(true);
                stage.setKeyboardFocus(textField);
            }
        });

        // Listener bottone "Fine"
        btnFine.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                textField.setVisible(false);
                stage.setKeyboardFocus(null);
                System.out.println("Hai scritto: " + textField.getText());
            }
        });

        stage.addActor(btnScrivi);
        stage.addActor(btnFine);
        stage.addActor(textField);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
