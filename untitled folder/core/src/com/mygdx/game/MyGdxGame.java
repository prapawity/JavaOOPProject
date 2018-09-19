package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.Player;

public class MyGdxGame extends ApplicationAdapter {
	private TiledMap map;
	private AssetManager manager;
    private Player player;
	// Map properties
	private int tileWidth, tileHeight,
			mapWidthInTiles, mapHeightInTiles,
			mapWidthInPixels, mapHeightInPixels;

	// Camera and render
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;


    @Override
	public void create () {
		// Map loading
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader());
		manager.load("GenerateMap/untitled.tmx", TiledMap.class);
		manager.finishLoading();
		map = manager.get("GenerateMap/untitled.tmx", TiledMap.class);

		// Read properties
		MapProperties properties = map.getProperties();
		tileWidth         = properties.get("tilewidth", Integer.class);
		tileHeight        = properties.get("tileheight", Integer.class);
		mapWidthInTiles   = properties.get("width", Integer.class);
		mapHeightInTiles  = properties.get("height", Integer.class);
		mapWidthInPixels  = mapWidthInTiles  * tileWidth;
		mapHeightInPixels = mapHeightInTiles * tileHeight;

		// Set up the camera
		camera = new OrthographicCamera(900.f, 900.f);
		camera.position.x = mapWidthInPixels * .20f;
		camera.position.y = mapHeightInPixels * .20f;

		// Instantiation of the render for the map object
		renderer = new OrthogonalTiledMapRenderer(map);
		player = new Player(new Sprite(new Texture("model2.png")));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update the camera and render
		camera.update();
		renderer.setView(camera);
		renderer.render();
		renderer.getBatch().begin();
		player.draw(renderer.getBatch());
		renderer.getBatch().end();
	}
//	@Override
//    public void resize(int width, int height){
//	    camera.viewportWidth = width;
//	    camera.viewportHeight = height;
//	    camera.update();
//
//    }

	@Override
	public void dispose () {
		// Free resources
		manager.dispose();
		player.getTexture().dispose();
	}
}
