package com.godi.godigame;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationListener;
import com.godi.godigame.com.godi.godigame.screen.LeadView;

public class GodiGame extends Game implements ApplicationListener {

    @Override
    public void create () {
        Assets.load();
        Assets.manager.finishLoading();

        setScreen(new LeadView(this));
    }

    @Override
    public void resize (int width, int height) {
    }


    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}