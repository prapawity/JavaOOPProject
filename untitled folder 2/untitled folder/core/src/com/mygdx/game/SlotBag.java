package com.mygdx.game;

import java.io.Serializable;

public class SlotBag implements Serializable {
    String name = "null2.png";
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
