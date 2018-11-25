package com.mygdx.game.entitirs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.Map;

public class Player extends Sprite implements InputProcessor{
    float posX=99;
    float posY=99;
    boolean state =false,mouseClicked = false;
    int mouseNotNormal=0,statusExit = 0;
    Map map;

    public boolean getState() {
        return state;
    }

    public int getMouseNotNormal() {
        return mouseNotNormal;
    }

    public boolean getmouseClicked() {
        return mouseClicked;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
    public void update() {
        Gdx.input.setInputProcessor(this);

    }

    public int getStatusExit() {
        return statusExit;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {

            statusExit = 1;
        }
        return false;
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    public void setState(boolean state) {
        this.state = state;
    }

    public void setMouseNotNormal(int mouseNotNormal) {
        this.mouseNotNormal = mouseNotNormal;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        setMouseClicked(true);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        setPosX(screenX);
        setPosY(screenY);
        //System.out.println(screenX+" "+screenY);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
