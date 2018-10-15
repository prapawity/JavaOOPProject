package com.prapawity.com.prapawity.controller;

import com.badlogic.gdx.InputAdapter;
import com.prapawity.com.prapawity.model.Actor;
import com.badlogic.gdx.Input.Keys;

public class PlayerController extends InputAdapter {

    private Actor actor;

    public  PlayerController(Actor p){
        this.actor = p;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.UP){
            actor.move(0, 1);

        }
        if (keycode == Keys.DOWN){
            actor.move(0, -1);

        }
        if (keycode == Keys.LEFT){
            actor.move(-1,0);

        }
        if (keycode == Keys.RIGHT){
            actor.move(1,0);
        }
        return false;
    }
}
