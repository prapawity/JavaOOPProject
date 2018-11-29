package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		// Frame setting
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Home Garden";
		config.useGL30 = false;
		config.width = 1280;
		config.height = 720;
		config.backgroundFPS = 60;
		config.foregroundFPS = 60;
		config.allowSoftwareMode = true;
		config.fullscreen = false;
		config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
