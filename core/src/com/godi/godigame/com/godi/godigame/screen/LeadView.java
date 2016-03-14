package com.godi.godigame.com.godi.godigame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.godi.godigame.Assets;
import com.godi.godigame.GodiGame;

public class LeadView implements Screen {
    private GodiGame game;

    SpriteBatch batch;

    Stage stage;
    TextButton skipButton;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    public LeadView(GodiGame game) {
        this.game = game;
    }


    @Override
    public void show () {
        batch = new SpriteBatch();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

//        FileHandle fontFile = Gdx.files.internal("data/CaviarDreams.ttf");
//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator generator = Assets.manager.get(Assets.CaviarDreams_font, FreeTypeFontGenerator.class);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 96;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
        skin = new Skin();
        //buttonAtlas = new TextureAtlas(Gdx.files.internal("texture/btn/rect_btn.pack"));
        buttonAtlas = Assets.manager.get(Assets.rect_btn_pack, TextureAtlas.class);
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up_btn");
        textButtonStyle.down = skin.getDrawable("down_btn");
        skipButton = new TextButton("Skip", textButtonStyle);
        skipButton.setPosition(Gdx.graphics.getWidth() - skipButton.getWidth(),
                0);

        skipButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartView(game));
            }
        });

        stage.addActor(skipButton);

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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