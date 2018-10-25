package com.mygdx.game.MapBitPriority;

import com.badlogic.gdx.utils.Timer;

public class HUD {
    private HudStatus hudStatus = new HudStatus();
    private Timer timer = new Timer();

    public HUD() {
    }

    public void hudDraw() {
        this.hudStatus.draw();
    }

    public void show() {
        ;
    }

    public void render() {
        this.hudStatus.draw();
    }
}
