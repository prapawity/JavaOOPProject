package com.prapawity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.prapawity.com.prapawity.screen.GameScreen;

public class testGame extends Game {
    private GameScreen screen;
    @Override
    public void create() {
        screen = new GameScreen(this);
        this.setScreen(screen);
    }
    @Override
    public void render(){
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }
}
