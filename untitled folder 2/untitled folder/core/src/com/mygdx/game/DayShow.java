package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DayShow {
    private SpriteBatch batch;
    private BitmapFont font;
    public void create(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
    }
    public void draw(Camera camera){

        font.draw(batch, "Hello World", camera.position.x, camera.position.y);
    }
}
