package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.io.Serializable;

public class SlotBag implements Serializable {
    String name = Gdx.files.internal("GenerateMap/null2.png").toString();
    int coun = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoun() {
        return coun;
    }

    public void setCoun(int coun) {
        this.coun += coun;
    }
}
