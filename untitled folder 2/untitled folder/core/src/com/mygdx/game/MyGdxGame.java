package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.MapBitPriority.HUD;
import com.mygdx.game.entitirs.Player;
import com.mygdx.game.entitirs.ShowImage;

public class MyGdxGame extends Game {
	// Set Value
	private TiledMap map;
	private Player player;
	private AssetManager manager;
    float oldCameraX, oldCameraY,mapX,mapY;
    private HUD hud;
    private Game game;
    private ShowImage showImage;
    private ShowImage greenHouse1,greenHouse2,greenHouse3,greenHouse4;
    private SpriteBatch Batch;

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
		Pixmap pm = new Pixmap(Gdx.files.internal("mouse.png"));
		Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")),0,0);
		Gdx.graphics.setCursor(cursor);
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader());
		manager.load("Genmap/Mainmap.tmx", TiledMap.class);
		manager.finishLoading();
		map = manager.get("Genmap/Mainmap.tmx", TiledMap.class);

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
		camera.position.x = 836f;
		camera.position.y = 7290f;
		// Instantiation of the render for the map object
		renderer = new OrthogonalTiledMapRenderer(map);
		// render Player
		player.update();
		showImage = new ShowImage(new Sprite(new Texture("Home.png")));
        greenHouse1 = new ShowImage(new Sprite(new Texture("farm.png")));
		showImage.scale(2);
		greenHouse1.scale(2);
		showImage.setPosition(215,7620); // House1
        greenHouse1.setPosition(235,7250); // greenHouse1

		//farm 836,7290
		// greenHouse1 3722,7059
		// greenhouse2 6320,7059
		// greenhouse3 9359, 7059
		//greenhouse 12419,7059


    }

	@Override
	public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		 Update the camera and render
        if (camera.position.x <= 1463 && camera.position.y >= 7059) {
            if (player.getPosX() == 0 && camera.position.x > 836)
                camera.position.set(camera.position.x - 3, camera.position.y, 0);
            else if (player.getPosX() == 1679 && camera.position.x < 1463)
                camera.position.set(camera.position.x + 3, camera.position.y, 0);
            else if (player.getPosY() == -1 && camera.position.y < 7290)
                camera.position.set(camera.position.x, camera.position.y + 3, 0);
            else if (player.getPosY() == 1049 && camera.position.y > 7060)
                camera.position.set(camera.position.x, camera.position.y - 3, 0);
        }


        camera.update();
        renderer.setView(camera);
        renderer.render();
        renderer.getBatch().begin();
        //GreenHouse First
        if (camera.position.x == 836) {
            if (player.getPosX() < 265 && player.getPosX() >= 245 && player.getPosY() >= 590 && player.getPosY() <= 610) {
                Pixmap pm = new Pixmap(Gdx.files.internal("hand.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                greenHouse1.draw(renderer.getBatch());
                if (player.getState() == true) {
                    camera.position.set(3722, 7059, 0);
                }

            } else if (player.getPosX() < 240 && player.getPosX() >= 230 && player.getPosY() >= 210 && player.getPosY() <= 260){
                Pixmap pm = new Pixmap(Gdx.files.internal("hand.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                showImage.draw(renderer.getBatch());
                if (player.getState() == true) {
                }
            }else if (player.getPosX() < 1270 && player.getPosX() >= 1240 && player.getPosY() >= 400 && player.getPosY() <= 440){
                Pixmap pm = new Pixmap(Gdx.files.internal("hand.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                greenHouse1.draw(renderer.getBatch());
                if (player.getState() == true) {
                }
            }
            else {
                Pixmap pm = new Pixmap(Gdx.files.internal("mouse.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }

        }
        renderer.getBatch().end();
        this.hud.render();
        this.renderer = new OrthogonalTiledMapRenderer(this.map, 1.2f);
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
