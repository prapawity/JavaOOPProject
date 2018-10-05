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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.Player;

public class MyGdxGame extends ApplicationAdapter{
	// Set Value
	private TiledMap map;
	private AssetManager manager;
    private Player player;
    float oldCameraX, oldCameraY;

    public float getOldCameraX() {
        return oldCameraX;
    }

    public void setOldCameraX(float oldCameraX) {
        this.oldCameraX = oldCameraX;
    }

    public float getOldCameraY() {
        return oldCameraY;
    }

    public void setOldCameraY(float oldCameraY) {
        this.oldCameraY = oldCameraY;
    }

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
		camera = new OrthographicCamera(900f, 900f);
		camera.position.x = mapWidthInPixels * .50f;
		camera.position.y = mapHeightInPixels * .35f;

		// Instantiation of the render for the map object
		renderer = new OrthogonalTiledMapRenderer(map);
		// render Player
		player = new Player(new Sprite(new Texture("model_00.png")), (TiledMapTileLayer) map.getLayers().get(0));
		player.setPosition(11*player.getCollissionLayer().getWidth(),(player.getCollissionLayer().getHeight()-30)*player.getCollissionLayer().getHeight());
	    player.setPosition(1000,1000);
        player.scale(1f);
        Gdx.input.setInputProcessor(player);

    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Update the camera and render
//        if (player.getX() < player.getOldX()) {
//            //player = new Player(new Sprite(new Texture("model2.png")), (TiledMapTileLayer) map.getLayers().get(0));
//            //player.setPosition(11*player.getCollissionLayer().getWidth(),(player.getCollissionLayer().getHeight()-30)*player.getCollissionLayer().getHeight());
//            System.out.println(player.getOldX()+" "+player.getOldY());
//            // player.setPosition(player.getOldX(),player.getOldY());
//            player.scale(1f);
//        }
        if(player.getX()>1580||player.getX()<620){
            if(player.getY()<390||player.getY()>1790)
                camera.position.set(getOldCameraX(),getOldCameraY(),0);
            else {
                camera.position.set(getOldCameraX(), player.getY() + player.getHeight() / 2, 0);
                setOldCameraY(player.getY() + player.getHeight() / 2);
            }
        }
        if(player.getY()<390||player.getY()>1790) {
            if(player.getX()>1580||player.getX()<620)
                camera.position.set(getOldCameraX(),getOldCameraY(),0);
            else {
                camera.position.set(player.getX() + player.getHeight() / 2, getOldCameraY(), 0);
                setOldCameraX(player.getX() + player.getHeight() / 2);
            }
        }
        else if (player.getX()<1580&&player.getX()>620&&player.getY()>390&&player.getY()<1790){
            camera.position.set(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2, 0);
            setOldCameraX(player.getX()+player.getWidth()/2);
            setOldCameraY(player.getY()+player.getHeight()/2);
        }
		camera.update();
		renderer.setView(camera);
		renderer.render();
		renderer.getBatch().begin();
		player.draw(renderer.getBatch());
		renderer.getBatch().end();
        this.renderer = new OrthogonalTiledMapRenderer(this.map, 1.725f);
	}
	@Override
    public void resize(int width, int height){
	    camera.viewportWidth = width;
	    camera.viewportHeight = height;
	    camera.update();

    }

	@Override
	public void dispose () {
		// Free resources
		manager.dispose();
		player.getTexture().dispose();
	}
}
