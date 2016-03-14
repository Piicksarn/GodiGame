package com.godi.godigame.com.godi.godigame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.godi.godigame.Assets;
import com.godi.godigame.GodiGame;


public class GameSettingView implements Screen {
    private GodiGame game;
    SpriteBatch batch;

    Stage stage;
    TextButton backButton;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    public GameSettingView(GodiGame game) {
        this.game = game;
    }

    @Override
    public void show () {
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        FreeTypeFontGenerator generator = Assets.manager.get(Assets.CaviarDreams_font, FreeTypeFontGenerator.class);

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 96;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);

        skin = new Skin();
        // buttonAtlas = new TextureAtlas(Gdx.files.internal("texture/btn/rect_btn.pack"));
        buttonAtlas = Assets.manager.get(Assets.rect_btn_pack, TextureAtlas.class);

        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up_btn");
        textButtonStyle.down = skin.getDrawable("down_btn");
        backButton = new TextButton("Back", textButtonStyle);
        backButton.setPosition(Gdx.graphics.getWidth() - backButton.getWidth(),
                0);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartView(game));
            }
        });

        stage.addActor(backButton);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {


    }

    @Override
    public void hide() {


    }

    @Override
    public void pause() {


    }

    @Override
    public void resume() {


    }

    @Override
    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }
    }
}