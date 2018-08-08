package com.prapawity.com.prapawity.screen;

import com.badlogic.gdx.Screen;
import com.prapawity.testGame;

public abstract class AbstractScreen implements Screen {
    private testGame app;
    public AbstractScreen(testGame app){
        this.app = app;
    }
    @Override
    public abstract void show();
    @Override
    public abstract void render(float delta);
    @Override
    public abstract void resize(int width, int hight);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}
