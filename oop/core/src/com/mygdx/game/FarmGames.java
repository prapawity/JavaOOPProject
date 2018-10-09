package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screen.Play;

public class FarmGames extends Game { ;

    @Override
	public void create () {
        setScreen(new Play());
//		batch = new SpriteBatch();
	}

	@Override
	public void render () {
        super.render();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
        super.dispose();
//		batch.dispose();
//		img.dispose();
	}
}
