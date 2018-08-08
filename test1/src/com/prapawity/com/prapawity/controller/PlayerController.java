package com.prapawity.com.prapawity.controller;

import com.badlogic.gdx.InputAdapter;
import com.prapawity.com.prapawity.model.Player;
import com.badlogic.gdx.Input.Keys;

public class PlayerController extends InputAdapter {

    private Player player;

    public  PlayerController(Player p){
        this.player = p;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.UP){
            player.move(0, 1);

        }
        if (keycode == Keys.DOWN){
            player.move(0, -1);

        }
        if (keycode == Keys.LEFT){
            player.move(-1,0);

        }
        if (keycode == Keys.RIGHT){
            player.move(1,0);
        }
        return false;
    }
}
