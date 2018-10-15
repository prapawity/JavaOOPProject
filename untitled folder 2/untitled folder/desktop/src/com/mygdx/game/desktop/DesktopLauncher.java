package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		// Frame setting
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Test";
		config.useGL30 = false;
		config.backgroundFPS = 60;
		config.foregroundFPS = 69;
		config.width = 1240;
		config.height = 800;
        config.vSyncEnabled = true;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
