package com.godi.godigame.com.godi.godigame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.godi.godigame.Assets;
import com.godi.godigame.GodiGame;


public class StartView implements Screen {
    private GodiGame game;

    SpriteBatch batch;

    Stage stage;
    TextButton startButton, settingButton;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas startButtonAtlas, settingButtonAtlas;

    public StartView(final GodiGame game) {
        this.game = game;
    }

    @Override
    public void show () {
        batch = new SpriteBatch();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        FreeTypeFontGenerator generator = Assets.manager.get(Assets.CaviarDreams_font, FreeTypeFontGenerator.class);

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 144;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
        // generator.dispose();
        skin = new Skin();
        // startButtonAtlas = new TextureAtlas(Gdx.files.internal("texture/btn/circle_btn.pack"));
        startButtonAtlas = Assets.manager.get(Assets.circle_btn_pack, TextureAtlas.class);

        skin.addRegions(startButtonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up_btn");
        textButtonStyle.down = skin.getDrawable("down_btn");

        startButton = new TextButton("Start", textButtonStyle);
        startButton.setPosition(Gdx.graphics.getWidth() / 2 - startButton.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - startButton.getHeight() / 2);


        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameView(game));
            }
        });

        parameter.size = 96;
        font = generator.generateFont(parameter);

        skin.dispose();

        skin = new Skin();

        // settingButtonAtlas = new TextureAtlas(Gdx.files.internal("texture/btn/circle_btn_small.pack"));
        settingButtonAtlas = Assets.manager.get(Assets.circle_btn_small_pack, TextureAtlas.class);

        skin.addRegions(settingButtonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up_btn");
        textButtonStyle.down = skin.getDrawable("down_btn");

        settingButton = new TextButton("Conf", textButtonStyle);
        settingButton.setPosition(Gdx.graphics.getWidth() - settingButton.getWidth(), 0);

        settingButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameSettingView(game));
            }
        });


        stage.addActor(startButton);
        stage.addActor(settingButton);
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