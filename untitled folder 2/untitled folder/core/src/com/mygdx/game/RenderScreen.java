package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.mygdx.game.MapBitPriority.GreenHouse;

public class RenderScreen implements ApplicationListener {
    MyGdxGame myGdxGame;
    GreenHouse greenHouse;
    @Override
    public void create() {
        myGdxGame = new MyGdxGame();
        greenHouse = new GreenHouse();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        myGdxGame.create();
        myGdxGame.render();


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
