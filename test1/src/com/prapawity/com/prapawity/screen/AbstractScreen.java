package com.prapawity.com.prapawity.screen;

import com.badlogic.gdx.Screen;
import com.prapawity.oopProject;

public abstract class AbstractScreen implements Screen {
    private oopProject app;
    public AbstractScreen(oopProject app){
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
