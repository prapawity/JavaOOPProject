package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private float oldCameraX, oldCameraY;
    private HUD hud;
    private ShowImage showImage,backhome1,backhome2,backhome3,backhome4;
    private ShowImage greenHouse1,mouseSelect;
    private FloorRender
    base, floorrender[][] ;

    private int positionX[] = {3429, 3529,3629,3729,3829,3929,4029},positionY[] = {7240,7149,7058,6967,6876,6785};


//    [] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
//    floorMap2[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
//    floorMap3[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"},
//    floorMap4[] = new String[]{"normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png",
//            "normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png","normalfloor.png"};private String floorMap1
    // Map properties
	private int tileWidth, tileHeight,
			mapWidthInTiles, mapHeightInTiles,
			mapWidthInPixels, mapHeightInPixels;

	// Camera and render
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private int screenState=0;
    @Override
	public void create () {
		// Map loading



		player = new Player();
		mousChange(1);
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

        floorrender = new FloorRender[6][7];
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++)
                    floorrender[i][j] = new FloorRender(new Sprite(new Texture("normalfloor.png")));
        for(int i = 0 ; i<6;i++)
            for(int j = 0;j<7;j++)
                floorrender[i][j].scale(8);
        base.scale(67);



        for(int i = 0 ; i<6;i++)
            for(int j = 0;j<7;j++) {
                floorrender[i][j].setPosition(positionX[j], positionY[i]);
            }
        base.setPosition(3724,7011);


        backhome1 = new ShowImage(new Sprite(new Texture("backhome.png")));
            backhome1.setPosition(2950,6650);
        backhome1.scale(2);


		showImage.scale(2);
		greenHouse1.scale(2);



//		weed.scale(8);
//		weed.setPosition(3429,7149);
//        weed2.scale(8);
//        weed2.setPosition(3429,7240);
         //greenHouse  6785 6876 6976, 7058 , 7149 7240 (3429, 3529,3629,3729,3829,3929,4029)
        mouseSelect = new ShowImage(new Sprite(new Texture("mouseselect.png")));
        mouseSelect.setPosition(806,469);
        mouseSelect.scale(10);

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
        camera.update();
        renderer.setView(camera);
        renderer.render();
        renderer.getBatch().begin();

        if(screenState==0) {


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


            if (player.getPosX() < 590 && player.getPosX() >= 500 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && !player.getmouseClicked())
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 660 && player.getPosX() >= 600 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 740 && player.getPosX() >= 670 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 832 && player.getPosX() >= 760 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }


            } else if (player.getPosX() <= 915 && player.getPosX() >= 842 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 999 && player.getPosX() >= 924 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 1081 && player.getPosX() >= 1006 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else if (player.getPosX() <= 1165 && player.getPosX() >= 1092 && player.getPosY() >= 960 && player.getPosY() <= 1100) {
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(1);
                    mousChange(3);
                } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mousChange(1);
                }
            } else {
                if (player.getMouseNotNormal() == 0)
                    mousChange(1);
            }

            //GreenHouse First
            if (camera.position.x == 836) {
                if (player.getPosX() < 265 && player.getPosX() >= 245 && player.getPosY() >= 590 && player.getPosY() <= 610) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 1;
                    }

                } else if (player.getPosX() < 240 && player.getPosX() >= 230 && player.getPosY() >= 210 && player.getPosY() <= 260) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    showImage.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                    }
                } else if (player.getPosX() < 1270 && player.getPosX() >= 1240 && player.getPosY() >= 400 && player.getPosY() <= 440) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                    }
                }
            }


        }
        else if(screenState==1){

        }
        else if (screenState==2){

        }

        else if(screenState==3){

        }
        else if(screenState==4){

        }
        base.draw(renderer.getBatch());
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                floorrender[i][j].draw(renderer.getBatch());


        backhome1.draw(renderer.getBatch());
        mouseSelect.draw(renderer.getBatch());
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





















	public void mousChange(int type){
        switch (type){
            case 1:{
                Pixmap pm = new Pixmap(Gdx.files.internal("mouse.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")),0,0);
                Gdx.graphics.setCursor(cursor);
            }break;
            case 2:{
                Pixmap pm = new Pixmap(Gdx.files.internal("hand.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }break;
            case 3:{
                Pixmap pm = new Pixmap(Gdx.files.internal("shovel.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("shovel.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }break;
            case 4:{
                Pixmap pm = new Pixmap(Gdx.files.internal("picaxe.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("picaxe.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }break;
            case 5:{
                Pixmap pm = new Pixmap(Gdx.files.internal("axe.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("axe.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }break;
            case 6:{
                Pixmap pm = new Pixmap(Gdx.files.internal("watering.png"));
                Cursor cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("watering.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
            }break;
        }
    }
}
