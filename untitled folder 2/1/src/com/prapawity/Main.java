package com.prapawity;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Stardew Valley";
        config.height = 600;
        config.width = 800;
        config.vSyncEnabled = true;
        new LwjglApplication(new oopProject(), config);
    }
}
