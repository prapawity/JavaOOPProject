package com.mygdx.game.MapBitPriority;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.Player;

public class GreenHouse extends Game {
    private TiledMap map;
    private Player player;
    private AssetManager manager;
    float oldCameraX, oldCameraY,mapX,mapY;
    private HUD hud;
    private Game game;

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
        player = new Player();
        Pixmap pm = new Pixmap(Gdx.files.internal("GenerateMap/mouse.png"));
        Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/mouse.png")),0,0);
        Gdx.graphics.setCursor(cursor);
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("Genmap/GreenHouse.tmx", TiledMap.class);
        manager.finishLoading();
        map = manager.get("Genmap/GreenHouse.tmx", TiledMap.class);

        // Read properties
        MapProperties properties = map.getProperties();
        tileWidth         = properties.get("tilewidth", Integer.class);
        tileHeight        = properties.get("tileheight", Integer.class);
        mapWidthInTiles   = properties.get("width", Integer.class);
        mapHeightInTiles  = properties.get("height", Integer.class);
        mapWidthInPixels  = mapWidthInTiles;
        mapHeightInPixels = mapHeightInTiles;
        hud = new HUD();
        // Set up the camera
        camera = new OrthographicCamera(3f, 3f);
        camera.position.x = 833;
        camera.position.y = 556;
        // Instantiation of the render for the map object
        renderer = new OrthogonalTiledMapRenderer(map);
        // render Player
        player.update();



    }

    @Override
    public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		 Update the camera and render

		renderer.setView(camera);
		renderer.render();
		this.hud.render();
        this.renderer = new OrthogonalTiledMapRenderer(this.map);

    }
    @Override
    public void resize(int width, int height){
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
        player.update();

    }

    @Override
    public void dispose () {
        // Free resources
        manager.dispose();
    }
}

