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

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends Game {
	// Set Value
    private int SceenCamera;
	private TiledMap map;
	private Player player;
	private AssetManager manager;
    float oldCameraX, oldCameraY,mapX,mapY;
    private HUD hud;
    private Game game;
    private ShowImage showImage;
    private ShowImage greenHouse1;
    private SpriteBatch Batch;
    private FloorRender floor1_1,floor1_2,floor1_3,floor1_4,floor1_5,floor1_6,floor1_7,
            floor2_1,floor2_2,floor2_3,floor2_4,floor2_5,floor2_6,floor2_7,
            floor3_1,floor3_2,floor3_3,floor3_4,floor3_5,floor3_6,floor3_7,
            floor4_1,floor4_2,floor4_3,floor4_4,floor4_5,floor4_6,floor4_7,
            floor5_1,floor5_2,floor5_3,floor5_4,floor5_5,floor5_6,floor5_7,
            floor6_1,floor6_2,floor6_3,floor6_4,floor6_5,floor6_6,floor6_7,
    base;
    private List<FloorRender> listFloor = new ArrayList(){};

    private String floorMap1[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
    floorMap2[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
    floorMap3[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
    floorMap4[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
                    "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"};;

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

        listFloor.add(floor1_1);
        listFloor.add(floor1_2);
        listFloor.add(floor1_3);
        listFloor.add(floor1_4);
        listFloor.add(floor1_5);
        listFloor.add(floor1_6);
        listFloor.add(floor1_7);

        listFloor.add(floor2_1);
        listFloor.add(floor2_2);
        listFloor.add(floor2_3);
        listFloor.add(floor2_4);
        listFloor.add(floor2_5);
        listFloor.add(floor2_6);
        listFloor.add(floor2_7);

        listFloor.add(floor3_1);
        listFloor.add(floor3_2);
        listFloor.add(floor3_3);
        listFloor.add(floor3_4);
        listFloor.add(floor3_5);
        listFloor.add(floor3_6);
        listFloor.add(floor3_7);

        listFloor.add(floor4_1);
        listFloor.add(floor4_2);
        listFloor.add(floor4_3);
        listFloor.add(floor4_4);
        listFloor.add(floor4_5);
        listFloor.add(floor4_6);
        listFloor.add(floor4_7);

        listFloor.add(floor5_1);
        listFloor.add(floor5_2);
        listFloor.add(floor5_3);
        listFloor.add(floor5_4);
        listFloor.add(floor5_5);
        listFloor.add(floor5_6);
        listFloor.add(floor5_7);

        listFloor.add(floor6_1);
        listFloor.add(floor6_2);
        listFloor.add(floor6_3);
        listFloor.add(floor6_4);
        listFloor.add(floor6_5);
        listFloor.add(floor6_6);
        listFloor.add(floor6_7);

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
        base = new FloorRender(new Sprite(new Texture("base.png")));
        floor1_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor1_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        floor2_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor2_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        floor3_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor3_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        floor4_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor4_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        floor5_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor5_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        floor6_1 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_2 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_3 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_4 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_5 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_6 = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        floor6_7 = new FloorRender(new Sprite(new Texture("normalfloor.png")));

        base.scale(67);
        floor1_1.scale(8);
        floor1_2.scale(8);
        floor1_3.scale(8);
        floor1_4.scale(8);
        floor1_5.scale(8);
        floor1_6.scale(8);
        floor1_7.scale(8);

        floor2_1.scale(8);
        floor2_2.scale(8);
        floor2_3.scale(8);
        floor2_4.scale(8);
        floor2_5.scale(8);
        floor2_6.scale(8);
        floor2_7.scale(8);

        floor3_1.scale(8);
        floor3_2.scale(8);
        floor3_3.scale(8);
        floor3_4.scale(8);
        floor3_5.scale(8);
        floor3_6.scale(8);
        floor3_7.scale(8);

        floor4_1.scale(8);
        floor4_2.scale(8);
        floor4_3.scale(8);
        floor4_4.scale(8);
        floor4_5.scale(8);
        floor4_6.scale(8);
        floor4_7.scale(8);

        floor5_1.scale(8);
        floor5_2.scale(8);
        floor5_3.scale(8);
        floor5_4.scale(8);
        floor5_5.scale(8);
        floor5_6.scale(8);
        floor5_7.scale(8);

        floor6_1.scale(8);
        floor6_2.scale(8);
        floor6_3.scale(8);
        floor6_4.scale(8);
        floor6_5.scale(8);
        floor6_6.scale(8);
        floor6_7.scale(8);

        base.setPosition(3724,7011);
        floor1_1.setPosition(3429,7240);
        floor1_2.setPosition(3529,7240);
        floor1_3.setPosition(3629,7240);
        floor1_4.setPosition(3729,7240);
        floor1_5.setPosition(3829,7240);
        floor1_6.setPosition(3929,7240);
        floor1_7.setPosition(4029,7240);

        floor2_1.setPosition(3429,7149);
        floor2_2.setPosition(3529,7149);
        floor2_3.setPosition(3629,7149);
        floor2_4.setPosition(3729,7149);
        floor2_5.setPosition(3829,7149);
        floor2_6.setPosition(3929,7149);
        floor2_7.setPosition(4029,7149);

        floor3_1.setPosition(3429,7058);
        floor3_2.setPosition(3529,7058);
        floor3_3.setPosition(3629,7058);
        floor3_4.setPosition(3729,7058);
        floor3_5.setPosition(3829,7058);
        floor3_6.setPosition(3929,7058);
        floor3_7.setPosition(4029,7058);

        floor4_1.setPosition(3429,6967);
        floor4_2.setPosition(3529,6967);
        floor4_3.setPosition(3629,6967);
        floor4_4.setPosition(3729,6967);
        floor4_5.setPosition(3829,6967);
        floor4_6.setPosition(3929,6967);
        floor4_7.setPosition(4029,6967);

        floor5_1.setPosition(3429,6876);
        floor5_2.setPosition(3529,6876);
        floor5_3.setPosition(3629,6876);
        floor5_4.setPosition(3729,6876);
        floor5_5.setPosition(3829,6876);
        floor5_6.setPosition(3929,6876);
        floor5_7.setPosition(4029,6876);

        floor6_1.setPosition(3429,6785);
        floor6_2.setPosition(3529,6785);
        floor6_3.setPosition(3629,6785);
        floor6_4.setPosition(3729,6785);
        floor6_5.setPosition(3829,6785);
        floor6_6.setPosition(3929,6785);
        floor6_7.setPosition(4029,6785);

//        weed = new ShowImage(new Sprite(new Texture("testfloor.png")));
//        weed2 = new ShowImage(new Sprite(new Texture("testfloor2.png")));


		showImage.scale(2);
		greenHouse1.scale(2);



//		weed.scale(8);
//		weed.setPosition(3429,7149);
//        weed2.scale(8);
//        weed2.setPosition(3429,7240);
         //greenHouse  6785 6876 6976, 7058 , 7149 7240 (3429, 3529,3629,3729,3829,3929,4029)


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

        base.draw(renderer.getBatch());
        floor1_1.draw(renderer.getBatch());
        floor1_2.draw(renderer.getBatch());
        floor1_3.draw(renderer.getBatch());
        floor1_4.draw(renderer.getBatch());
        floor1_5.draw(renderer.getBatch());
        floor1_6.draw(renderer.getBatch());
        floor1_7.draw(renderer.getBatch());

        floor2_1.draw(renderer.getBatch());
        floor2_2.draw(renderer.getBatch());
        floor2_3.draw(renderer.getBatch());
        floor2_4.draw(renderer.getBatch());
        floor2_5.draw(renderer.getBatch());
        floor2_6.draw(renderer.getBatch());
        floor2_7.draw(renderer.getBatch());

        floor3_1.draw(renderer.getBatch());
        floor3_2.draw(renderer.getBatch());
        floor3_3.draw(renderer.getBatch());
        floor3_4.draw(renderer.getBatch());
        floor3_5.draw(renderer.getBatch());
        floor3_6.draw(renderer.getBatch());
        floor3_7.draw(renderer.getBatch());

        floor4_1.draw(renderer.getBatch());
        floor4_2.draw(renderer.getBatch());
        floor4_3.draw(renderer.getBatch());
        floor4_4.draw(renderer.getBatch());
        floor4_5.draw(renderer.getBatch());
        floor4_6.draw(renderer.getBatch());
        floor4_7.draw(renderer.getBatch());

        floor5_1.draw(renderer.getBatch());
        floor5_2.draw(renderer.getBatch());
        floor5_3.draw(renderer.getBatch());
        floor5_4.draw(renderer.getBatch());
        floor5_5.draw(renderer.getBatch());
        floor5_6.draw(renderer.getBatch());
        floor5_7.draw(renderer.getBatch());

        floor6_1.draw(renderer.getBatch());
        floor6_2.draw(renderer.getBatch());
        floor6_3.draw(renderer.getBatch());
        floor6_4.draw(renderer.getBatch());
        floor6_5.draw(renderer.getBatch());
        floor6_6.draw(renderer.getBatch());
        floor6_7.draw(renderer.getBatch());
//        weed2.draw(renderer.getBatch());
//        weed.draw(renderer.getBatch());
        renderer.getBatch().end();
        this.hud.render();
        this.renderer = new OrthogonalTiledMapRenderer(this.map, 1.2f);
        System.out.println();
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
