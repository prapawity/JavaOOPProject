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
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.MapBitPriority.HUD;
import com.mygdx.game.entitirs.Player;
import com.mygdx.game.entitirs.ShowImage;

public class MyGdxGame extends Game {
	// Set Value
    private Pixmap pm;
    private Cursor cursor;
	private TiledMap map;
	private Player player;
	private AssetManager manager;
    private float oldCameraX, oldCameraY;
    private HUD hud;
    private ShowImage showImage,backhome1;
    private ShowImage greenHouse1,mouseSelect;
    private Timer timer;
    private FloorRender
    base, floorrender[][] ;

    private int positionX[] = {3429, 3529,3629,3729,3829,3929,4029},positionY[] = {7240,7149,7058,6967,6876,6785},loop = 0,mouseNumber = 1;

    FloorStatus floorMap[] = new FloorStatus[42];
    FloorStatus floorMap2[] = new FloorStatus[42];
    FloorStatus floorMap3[] = new FloorStatus[42];
    FloorStatus floorMap4[] = new FloorStatus[42];

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
        timer = new Timer();



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


        createFloor();
        floorrender = new FloorRender[6][7];
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++) {


                    floorrender[i][j] = new FloorRender(new Sprite(new Texture(floorMap[loop].getName())));
                    loop++;


                }
                loop = 0;
        for(int i = 0 ; i<6;i++) {
            for (int j = 0; j < 7; j++)
                floorrender[i][j].scale(8);
        }

        for(int i = 0 ; i<6;i++)
            for(int j = 0;j<7;j++) {
                floorrender[i][j].setPosition(positionX[j], positionY[i]);
            }



        base.setPosition(3724,7011);
        base.scale(67);

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
		//farm 836,7290
		// greenHouse1 3722,7059



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
        loop = 0;
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


            hudShowing();

            //GreenHouse First
            if (camera.position.x == 836 && camera.position.y==7290) {
                if (player.getPosX() <= 265 && player.getPosX() >= 245 && player.getPosY() >= 590 && player.getPosY() <= 610) {
                    greenHouse1.setPosition(235,7240); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 1;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                } else if (player.getPosX() < 240 && player.getPosX() >= 230 && player.getPosY() >= 210 && player.getPosY() <= 260) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    showImage.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() < 1270 && player.getPosX() >= 1240 && player.getPosY() >= 400 && player.getPosY() <= 440) {
                    greenHouse1.setPosition(1233,7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
            }
            else if(camera.position.x == 1463 && camera.position.y==7290){
                if(player.getPosX()>=621 &&player.getPosX()<= 641 && player.getPosY()>=405 && player.getPosY()<=438){
                    greenHouse1.setPosition(1233,7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
                else if(player.getPosX()>=1214 && player.getPosX()<= 1237 && player.getPosY() >= 403 && player.getPosY() <= 437 ){
                    greenHouse1.setPosition(1828,7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 4;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }

            }
            else if(camera.position.x == 836 && camera.position.y==7059){
                if (player.getPosX() <= 271 && player.getPosX() >= 248 && player.getPosY() >= 345 && player.getPosY() <= 379) {
                    greenHouse1.setPosition(235,7240); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 1;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
                else if(player.getPosX()>=747 && player.getPosX()<= 770 && player.getPosY()>=729 &&player.getPosY()<=762){
                    greenHouse1.setPosition(735,6852); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                }
                else if(player.getPosX()>=119 &&player.getPosX()<= 140 && player.getPosY()>=960 && player.getPosY()<=993){
                    greenHouse1.setPosition(735,6852); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                }

            }
            else if(camera.position.x == 1463 && camera.position.y==7059){
                if(player.getPosX()>=617 && player.getPosX()<= 641 && player.getPosY() >= 174 && player.getPosY() <= 206 ){
                    greenHouse1.setPosition(1233,7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
                else if(player.getPosX()>=1214 && player.getPosX()<= 1237 && player.getPosY() >= 174 && player.getPosY() <= 206 ){
                    greenHouse1.setPosition(1828,7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 4;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
                else if(player.getPosX()>=119 &&player.getPosX()<= 143 && player.getPosY()>=730 && player.getPosY()<=759){
                    greenHouse1.setPosition(735,6852); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                }

            }


        }
        else if(screenState==1){
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++) {
                    floorrender[i][j].setTexture(new Texture(floorMap[loop].getName()));
                    loop++;
                }
            hudShowing();
            farmActivities(floorMap);

        }
        else if (screenState==2){
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++) {
                    floorrender[i][j].setTexture(new Texture(floorMap2[loop].getName()));
                    loop++;
                }
            hudShowing();
            farmActivities(floorMap2);

        }

        else if(screenState==3){
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++) {
                    floorrender[i][j].setTexture(new Texture(floorMap3[loop].getName()));
                    loop++;
                }
            hudShowing();
            farmActivities(floorMap3);

        }
        else if(screenState==4){
            for(int i = 0 ; i<6;i++)
                for(int j = 0;j<7;j++) {
                    floorrender[i][j].setTexture(new Texture(floorMap4[loop].getName()));
                    loop++;
                }
            hudShowing();
            farmActivities(floorMap4);

        }
        base.draw(renderer.getBatch());
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                floorrender[i][j].draw(renderer.getBatch());
        if(player.getStatusExit()==1){
            timer.delay(10000);
            dispose();
            Gdx.app.exit();

        }

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
        map.dispose();
        manager.dispose();
    }





















	private void mousChange(int type){
        switch (type){
            case 1:{
                pm = new Pixmap(Gdx.files.internal("mouse.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")),0,0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 1;
            }break;
            case 2:{
                pm = new Pixmap(Gdx.files.internal("hand.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 2;
            }break;
            case 3:{
                pm = new Pixmap(Gdx.files.internal("shovel.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("shovel.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 3;
            }break;
            case 4:{
                pm = new Pixmap(Gdx.files.internal("picaxe.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("picaxe.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 4;
            }break;
            case 5:{
                pm = new Pixmap(Gdx.files.internal("axe.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("axe.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 5;
            }break;
            case 6:{
                pm = new Pixmap(Gdx.files.internal("watering.png"));
                cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("watering.png")), 0, 0);
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 6;
            }break;
        }


    }
    public void mapChange(int screenStates){
        if(screenStates == 0)
            camera.position.set(836,7290,0);
        else camera.position.set(3722, 7100, 0);
        screenState = screenStates;

    }



    public void hudShowing(){
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
                mousChange(5);
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
                mousChange(4);
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
                mousChange(6);
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
    }

    public void farmActivities(FloorStatus[] floorMaps){
        if(player.getMouseNotNormal()==1) {

                if (player.getmouseClicked() == true) {
                    if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[0].getStatus()==0) {
                                floorMaps[0].setName("dicking.png");
                                floorMaps[0].setStatus(1);
                            }
                            else if(floorMaps[0].getStatus()==2){
                                floorMaps[0].setName("dickingwet.png");
                                floorMaps[0].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[0].getStatus()==0){
                                floorMaps[0].setName("wetfloor.png");
                                floorMaps[0].setStatus(2);
                            }
                            else if(floorMaps[0].getStatus()==1){
                                floorMaps[0].setName("dickingwet.png");
                                floorMaps[0].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[1].getStatus()==0) {
                                floorMaps[1].setName("dicking.png");
                                floorMaps[1].setStatus(1);
                            }
                            else if(floorMaps[1].getStatus()==2){
                                floorMaps[1].setName("dickingwet.png");
                                floorMaps[1].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[1].getStatus()==0){
                                floorMaps[1].setName("wetfloor.png");
                                floorMaps[1].setStatus(2);
                            }
                            else if(floorMaps[1].getStatus()==1){
                                floorMaps[1].setName("dickingwet.png");
                                floorMaps[1].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[2].getStatus()==0) {
                                floorMaps[2].setName("dicking.png");
                                floorMaps[2].setStatus(1);
                            }
                            else if(floorMaps[2].getStatus()==2){
                                floorMaps[2].setName("dickingwet.png");
                                floorMaps[2].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[2].getStatus()==0){
                                floorMaps[2].setName("wetfloor.png");
                                floorMaps[2].setStatus(2);
                            }
                            else if(floorMaps[2].getStatus()==1){
                                floorMaps[2].setName("dickingwet.png");
                                floorMaps[2].setStatus(3);
                            }
                        }
                    }
                    else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[3].getStatus()==0) {
                                floorMaps[3].setName("dicking.png");
                                floorMaps[3].setStatus(1);
                            }
                            else if(floorMaps[3].getStatus()==2){
                                floorMaps[3].setName("dickingwet.png");
                                floorMaps[3].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[3].getStatus()==0){
                                floorMaps[3].setName("wetfloor.png");
                                floorMaps[3].setStatus(2);
                            }
                            else if(floorMaps[3].getStatus()==1){
                                floorMaps[3].setName("dickingwet.png");
                                floorMaps[3].setStatus(3);
                            }
                        }
                    }
                    else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[4].getStatus()==0) {
                                floorMaps[4].setName("dicking.png");
                                floorMaps[4].setStatus(1);
                            }
                            else if(floorMap[4].getStatus()==2){
                                floorMaps[4].setName("dickingwet.png");
                                floorMaps[4].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[4].getStatus()==0){
                                floorMaps[4].setName("wetfloor.png");
                                floorMaps[4].setStatus(2);
                            }
                            else if(floorMap[4].getStatus()==1){
                                floorMaps[4].setName("dickingwet.png");
                                floorMaps[4].setStatus(3);
                            }
                        }
                    }
                    else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[5].getStatus()==0) {
                                floorMaps[5].setName("dicking.png");
                                floorMaps[5].setStatus(1);
                            }
                            else if(floorMap[5].getStatus()==2){
                                floorMaps[5].setName("dickingwet.png");
                                floorMaps[5].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[5].getStatus()==0){
                                floorMaps[5].setName("wetfloor.png");
                                floorMaps[5].setStatus(2);
                            }
                            else if(floorMaps[5].getStatus()==1){
                                floorMaps[5].setName("dickingwet.png");
                                floorMaps[5].setStatus(3);
                            }
                        }
                    }
                    else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=335 && player.getPosY()<=421){
                        if (mouseNumber==3) {
                            if(floorMaps[6].getStatus()==0) {
                                floorMaps[6].setName("dicking.png");
                                floorMaps[6].setStatus(1);
                            }
                            else if(floorMaps[6].getStatus()==2){
                                floorMaps[6].setName("dickingwet.png");
                                floorMaps[6].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[6].getStatus()==0){
                                floorMaps[6].setName("wetfloor.png");
                                floorMaps[6].setStatus(2);
                            }
                            else if(floorMaps[6].getStatus()==1){
                                floorMaps[6].setName("dickingwet.png");
                                floorMaps[6].setStatus(3);
                            }
                        }
                    }
                    else if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[7].getStatus()==0) {
                                floorMaps[7].setName("dicking.png");
                                floorMaps[7].setStatus(1);
                            }
                            else if(floorMaps[7].getStatus()==2){
                                floorMaps[7].setName("dickingwet.png");
                                floorMaps[7].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[7].getStatus()==0){
                                floorMaps[7].setName("wetfloor.png");
                                floorMaps[7].setStatus(2);
                            }
                            else if(floorMaps[7].getStatus()==1){
                                floorMaps[7].setName("dickingwet.png");
                                floorMaps[7].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[8].getStatus()==0) {
                                floorMaps[8].setName("dicking.png");
                                floorMaps[8].setStatus(1);
                            }
                            else if(floorMaps[8].getStatus()==2){
                                floorMaps[8].setName("dickingwet.png");
                                floorMaps[8].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[8].getStatus()==0){
                                floorMaps[8].setName("wetfloor.png");
                                floorMaps[8].setStatus(2);
                            }
                            else if(floorMaps[8].getStatus()==1){
                                floorMaps[8].setName("dickingwet.png");
                                floorMaps[8].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[9].getStatus()==0) {
                                floorMaps[9].setName("dicking.png");
                                floorMaps[9].setStatus(1);
                            }
                            else if(floorMaps[9].getStatus()==2){
                                floorMaps[9].setName("dickingwet.png");
                                floorMaps[9].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[9].getStatus()==0){
                                floorMaps[9].setName("wetfloor.png");
                                floorMaps[9].setStatus(2);
                            }
                            else if(floorMaps[9].getStatus()==1){
                                floorMaps[9].setName("dickingwet.png");
                                floorMaps[9].setStatus(3);
                            }
                        }
                    }else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[10].getStatus()==0) {
                                floorMaps[10].setName("dicking.png");
                                floorMaps[10].setStatus(1);
                            }
                            else if(floorMaps[10].getStatus()==2){
                                floorMaps[10].setName("dickingwet.png");
                                floorMaps[10].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[10].getStatus()==0){
                                floorMaps[10].setName("wetfloor.png");
                                floorMaps[10].setStatus(2);
                            }
                            else if(floorMaps[10].getStatus()==1){
                                floorMaps[10].setName("dickingwet.png");
                                floorMaps[10].setStatus(3);
                            }
                        }
                    }else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[11].getStatus()==0) {
                                floorMaps[11].setName("dicking.png");
                                floorMaps[11].setStatus(1);
                            }
                            else if(floorMaps[11].getStatus()==2){
                                floorMaps[11].setName("dickingwet.png");
                                floorMaps[11].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[11].getStatus()==0){
                                floorMaps[11].setName("wetfloor.png");
                                floorMaps[11].setStatus(2);
                            }
                            else if(floorMaps[11].getStatus()==1){
                                floorMaps[11].setName("dickingwet.png");
                                floorMaps[11].setStatus(3);
                            }
                        }
                    }else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[12].getStatus()==0) {
                                floorMaps[12].setName("dicking.png");
                                floorMaps[12].setStatus(1);
                            }
                            else if(floorMaps[12].getStatus()==2){
                                floorMaps[12].setName("dickingwet.png");
                                floorMaps[12].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[12].getStatus()==0){
                                floorMaps[12].setName("wetfloor.png");
                                floorMaps[12].setStatus(2);
                            }
                            else if(floorMaps[12].getStatus()==1){
                                floorMaps[12].setName("dickingwet.png");
                                floorMaps[12].setStatus(3);
                            }
                        }
                    }else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=404 && player.getPosY()<=515){
                        if (mouseNumber==3) {
                            if(floorMaps[13].getStatus()==0) {
                                floorMaps[13].setName("dicking.png");
                                floorMaps[13].setStatus(1);
                            }
                            else if(floorMaps[13].getStatus()==2){
                                floorMaps[13].setName("dickingwet.png");
                                floorMaps[13].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[13].getStatus()==0){
                                floorMaps[13].setName("wetfloor.png");
                                floorMaps[13].setStatus(2);
                            }
                            else if(floorMaps[13].getStatus()==1){
                                floorMaps[13].setName("dickingwet.png");
                                floorMaps[13].setStatus(3);
                            }
                        }
                    }
                    else if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[14].getStatus()==0) {
                                floorMaps[14].setName("dicking.png");
                                floorMaps[14].setStatus(1);
                            }
                            else if(floorMaps[14].getStatus()==2){
                                floorMaps[14].setName("dickingwet.png");
                                floorMaps[14].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[14].getStatus()==0){
                                floorMaps[14].setName("wetfloor.png");
                                floorMaps[14].setStatus(2);
                            }
                            else if(floorMaps[14].getStatus()==1){
                                floorMaps[14].setName("dickingwet.png");
                                floorMaps[14].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[15].getStatus()==0) {
                                floorMaps[15].setName("dicking.png");
                                floorMaps[15].setStatus(1);
                            }
                            else if(floorMaps[15].getStatus()==2){
                                floorMaps[15].setName("dickingwet.png");
                                floorMaps[15].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[15].getStatus()==0){
                                floorMaps[15].setName("wetfloor.png");
                                floorMaps[15].setStatus(2);
                            }
                            else if(floorMaps[15].getStatus()==1){
                                floorMaps[15].setName("dickingwet.png");
                                floorMaps[15].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[16].getStatus()==0) {
                                floorMaps[16].setName("dicking.png");
                                floorMaps[16].setStatus(1);
                            }
                            else if(floorMaps[16].getStatus()==2){
                                floorMaps[16].setName("dickingwet.png");
                                floorMaps[16].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[16].getStatus()==0){
                                floorMaps[16].setName("wetfloor.png");
                                floorMaps[16].setStatus(2);
                            }
                            else if(floorMaps[16].getStatus()==1){
                                floorMaps[16].setName("dickingwet.png");
                                floorMaps[16].setStatus(3);
                            }
                        }
                    }
                    else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[17].getStatus()==0) {
                                floorMaps[17].setName("dicking.png");
                                floorMaps[17].setStatus(1);
                            }
                            else if(floorMaps[17].getStatus()==2){
                                floorMaps[17].setName("dickingwet.png");
                                floorMaps[17].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[17].getStatus()==0){
                                floorMaps[17].setName("wetfloor.png");
                                floorMaps[17].setStatus(2);
                            }
                            else if(floorMaps[17].getStatus()==1){
                                floorMaps[17].setName("dickingwet.png");
                                floorMaps[17].setStatus(3);
                            }
                        }
                    }
                    else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[18].getStatus()==0) {
                                floorMaps[18].setName("dicking.png");
                                floorMaps[18].setStatus(1);
                            }
                            else if(floorMaps[18].getStatus()==2){
                                floorMaps[18].setName("dickingwet.png");
                                floorMaps[18].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[18].getStatus()==0){
                                floorMaps[18].setName("wetfloor.png");
                                floorMaps[18].setStatus(2);
                            }
                            else if(floorMaps[18].getStatus()==1){
                                floorMaps[18].setName("dickingwet.png");
                                floorMaps[18].setStatus(3);
                            }
                        }
                    }
                    else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[19].getStatus()==0) {
                                floorMaps[19].setName("dicking.png");
                                floorMaps[19].setStatus(1);
                            }
                            else if(floorMaps[19].getStatus()==2){
                                floorMaps[19].setName("dickingwet.png");
                                floorMaps[19].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[19].getStatus()==0){
                                floorMaps[19].setName("wetfloor.png");
                                floorMaps[19].setStatus(2);
                            }
                            else if(floorMap[19].getStatus()==1){
                                floorMaps[19].setName("dickingwet.png");
                                floorMaps[19].setStatus(3);
                            }
                        }
                    }
                    else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=517 && player.getPosY()<=605){
                        if (mouseNumber==3) {
                            if(floorMaps[20].getStatus()==0) {
                                floorMaps[20].setName("dicking.png");
                                floorMaps[20].setStatus(1);
                            }
                            else if(floorMaps[20].getStatus()==2){
                                floorMaps[20].setName("dickingwet.png");
                                floorMaps[20].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[20].getStatus()==0){
                                floorMaps[20].setName("wetfloor.png");
                                floorMaps[20].setStatus(2);
                            }
                            else if(floorMap[20].getStatus()==1){
                                floorMaps[20].setName("dickingwet.png");
                                floorMaps[20].setStatus(3);
                            }
                        }
                    }
                    else if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[21].getStatus()==0) {
                                floorMaps[21].setName("dicking.png");
                                floorMaps[21].setStatus(1);
                            }
                            else if(floorMaps[21].getStatus()==2){
                                floorMaps[21].setName("dickingwet.png");
                                floorMaps[21].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[21].getStatus()==0){
                                floorMaps[21].setName("wetfloor.png");
                                floorMaps[21].setStatus(2);
                            }
                            else if(floorMap[21].getStatus()==1){
                                floorMaps[21].setName("dickingwet.png");
                                floorMaps[21].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[22].getStatus()==0) {
                                floorMaps[22].setName("dicking.png");
                                floorMaps[22].setStatus(1);
                            }
                            else if(floorMaps[22].getStatus()==2){
                                floorMaps[22].setName("dickingwet.png");
                                floorMaps[22].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[22].getStatus()==0){
                                floorMaps[22].setName("wetfloor.png");
                                floorMaps[22].setStatus(2);
                            }
                            else if(floorMap[22].getStatus()==1){
                                floorMaps[22].setName("dickingwet.png");
                                floorMaps[22].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[23].getStatus()==0) {
                                floorMaps[23].setName("dicking.png");
                                floorMaps[23].setStatus(1);
                            }
                            else if(floorMaps[23].getStatus()==2){
                                floorMaps[23].setName("dickingwet.png");
                                floorMaps[23].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[23].getStatus()==0){
                                floorMaps[23].setName("wetfloor.png");
                                floorMaps[23].setStatus(2);
                            }
                            else if(floorMap[23].getStatus()==1){
                                floorMaps[23].setName("dickingwet.png");
                                floorMaps[23].setStatus(3);
                            }
                        }
                    }
                    else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[24].getStatus()==0) {
                                floorMaps[24].setName("dicking.png");
                                floorMaps[24].setStatus(1);
                            }
                            else if(floorMaps[24].getStatus()==2){
                                floorMaps[24].setName("dickingwet.png");
                                floorMaps[24].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[24].getStatus()==0){
                                floorMaps[24].setName("wetfloor.png");
                                floorMaps[24].setStatus(2);
                            }
                            else if(floorMap[24].getStatus()==1){
                                floorMaps[24].setName("dickingwet.png");
                                floorMaps[24].setStatus(3);
                            }
                        }
                    }
                    else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[25].getStatus()==0) {
                                floorMaps[25].setName("dicking.png");
                                floorMaps[25].setStatus(1);
                            }
                            else if(floorMaps[25].getStatus()==2){
                                floorMaps[25].setName("dickingwet.png");
                                floorMaps[25].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[25].getStatus()==0){
                                floorMaps[25].setName("wetfloor.png");
                                floorMaps[25].setStatus(2);
                            }
                            else if(floorMap[25].getStatus()==1){
                                floorMaps[25].setName("dickingwet.png");
                                floorMaps[25].setStatus(3);
                            }
                        }
                    }
                    else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[26].getStatus()==0) {
                                floorMaps[26].setName("dicking.png");
                                floorMaps[26].setStatus(1);
                            }
                            else if(floorMaps[26].getStatus()==2){
                                floorMaps[26].setName("dickingwet.png");
                                floorMaps[26].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[26].getStatus()==0){
                                floorMaps[26].setName("wetfloor.png");
                                floorMaps[26].setStatus(2);
                            }
                            else if(floorMap[26].getStatus()==1){
                                floorMaps[26].setName("dickingwet.png");
                                floorMaps[26].setStatus(3);
                            }
                        }
                    }
                    else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=607 && player.getPosY()<=695){
                        if (mouseNumber==3) {
                            if(floorMaps[27].getStatus()==0) {
                                floorMaps[27].setName("dicking.png");
                                floorMaps[27].setStatus(1);
                            }
                            else if(floorMaps[27].getStatus()==2){
                                floorMaps[27].setName("dickingwet.png");
                                floorMaps[27].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[27].getStatus()==0){
                                floorMaps[27].setName("wetfloor.png");
                                floorMaps[27].setStatus(2);
                            }
                            else if(floorMap[27].getStatus()==1){
                                floorMaps[27].setName("dickingwet.png");
                                floorMaps[27].setStatus(3);
                            }
                        }
                    }
                    else if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[28].getStatus()==0) {
                                floorMaps[28].setName("dicking.png");
                                floorMaps[28].setStatus(1);
                            }
                            else if(floorMaps[28].getStatus()==2){
                                floorMaps[28].setName("dickingwet.png");
                                floorMaps[28].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[28].getStatus()==0){
                                floorMaps[28].setName("wetfloor.png");
                                floorMaps[28].setStatus(2);
                            }
                            else if(floorMap[28].getStatus()==1){
                                floorMaps[28].setName("dickingwet.png");
                                floorMaps[28].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[29].getStatus()==0) {
                                floorMaps[29].setName("dicking.png");
                                floorMaps[29].setStatus(1);
                            }
                            else if(floorMaps[29].getStatus()==2){
                                floorMaps[29].setName("dickingwet.png");
                                floorMaps[29].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[29].getStatus()==0){
                                floorMaps[29].setName("wetfloor.png");
                                floorMaps[29].setStatus(2);
                            }
                            else if(floorMap[29].getStatus()==1){
                                floorMaps[29].setName("dickingwet.png");
                                floorMaps[29].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[30].getStatus()==0) {
                                floorMaps[30].setName("dicking.png");
                                floorMaps[30].setStatus(1);
                            }
                            else if(floorMaps[30].getStatus()==2){
                                floorMaps[30].setName("dickingwet.png");
                                floorMaps[30].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[30].getStatus()==0){
                                floorMaps[30].setName("wetfloor.png");
                                floorMaps[30].setStatus(2);
                            }
                            else if(floorMap[30].getStatus()==1){
                                floorMaps[30].setName("dickingwet.png");
                                floorMaps[30].setStatus(3);
                            }
                        }
                    }
                    else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[31].getStatus()==0) {
                                floorMaps[31].setName("dicking.png");
                                floorMaps[31].setStatus(1);
                            }
                            else if(floorMaps[31].getStatus()==2){
                                floorMaps[31].setName("dickingwet.png");
                                floorMaps[31].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[31].getStatus()==0){
                                floorMaps[31].setName("wetfloor.png");
                                floorMaps[31].setStatus(2);
                            }
                            else if(floorMap[31].getStatus()==1){
                                floorMaps[31].setName("dickingwet.png");
                                floorMaps[31].setStatus(3);
                            }
                        }
                    }
                    else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[32].getStatus()==0) {
                                floorMaps[32].setName("dicking.png");
                                floorMaps[32].setStatus(1);
                            }
                            else if(floorMaps[32].getStatus()==2){
                                floorMaps[32].setName("dickingwet.png");
                                floorMaps[32].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[32].getStatus()==0){
                                floorMaps[32].setName("wetfloor.png");
                                floorMaps[32].setStatus(2);
                            }
                            else if(floorMap[32].getStatus()==1){
                                floorMaps[32].setName("dickingwet.png");
                                floorMaps[32].setStatus(3);
                            }
                        }
                    }
                    else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[33].getStatus()==0) {
                                floorMaps[33].setName("dicking.png");
                                floorMaps[33].setStatus(1);
                            }
                            else if(floorMaps[33].getStatus()==2){
                                floorMaps[33].setName("dickingwet.png");
                                floorMaps[33].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[33].getStatus()==0){
                                floorMaps[33].setName("wetfloor.png");
                                floorMaps[33].setStatus(2);
                            }
                            else if(floorMap[33].getStatus()==1){
                                floorMaps[33].setName("dickingwet.png");
                                floorMaps[33].setStatus(3);
                            }
                        }
                    }
                    else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=697 && player.getPosY()<=785){
                        if (mouseNumber==3) {
                            if(floorMaps[34].getStatus()==0) {
                                floorMaps[34].setName("dicking.png");
                                floorMaps[34].setStatus(1);
                            }
                            else if(floorMaps[34].getStatus()==2){
                                floorMaps[34].setName("dickingwet.png");
                                floorMaps[34].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[34].getStatus()==0){
                                floorMaps[34].setName("wetfloor.png");
                                floorMaps[34].setStatus(2);
                            }
                            else if(floorMap[34].getStatus()==1){
                                floorMaps[34].setName("dickingwet.png");
                                floorMaps[34].setStatus(3);
                            }
                        }
                    }
                    else if(506<=player.getPosX() && player.getPosX()<=590 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[35].getStatus()==0) {
                                floorMaps[35].setName("dicking.png");
                                floorMaps[35].setStatus(1);
                            }
                            else if(floorMaps[35].getStatus()==2){
                                floorMaps[35].setName("dickingwet.png");
                                floorMaps[35].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[35].getStatus()==0){
                                floorMaps[35].setName("wetfloor.png");
                                floorMaps[35].setStatus(2);
                            }
                            else if(floorMap[35].getStatus()==1){
                                floorMaps[35].setName("dickingwet.png");
                                floorMaps[35].setStatus(3);
                            }
                        }
                    }
                    else if(606<=player.getPosX() && player.getPosX()<=690 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[36].getStatus()==0) {
                                floorMaps[36].setName("dicking.png");
                                floorMaps[36].setStatus(1);
                            }
                            else if(floorMaps[36].getStatus()==2){
                                floorMaps[36].setName("dickingwet.png");
                                floorMaps[36].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[36].getStatus()==0){
                                floorMaps[36].setName("wetfloor.png");
                                floorMaps[36].setStatus(2);
                            }
                            else if(floorMap[36].getStatus()==1){
                                floorMaps[36].setName("dickingwet.png");
                                floorMaps[36].setStatus(3);
                            }
                        }
                    }
                    else if(706<=player.getPosX() && player.getPosX()<=790 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[37].getStatus()==0) {
                                floorMaps[37].setName("dicking.png");
                                floorMaps[37].setStatus(1);
                            }
                            else if(floorMaps[37].getStatus()==2){
                                floorMaps[37].setName("dickingwet.png");
                                floorMaps[37].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[37].getStatus()==0){
                                floorMaps[37].setName("wetfloor.png");
                                floorMaps[37].setStatus(2);
                            }
                            else if(floorMap[37].getStatus()==1){
                                floorMaps[37].setName("dickingwet.png");
                                floorMaps[37].setStatus(3);
                            }
                        }
                    }
                    else if(806<=player.getPosX() && player.getPosX()<=890 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[38].getStatus()==0) {
                                floorMaps[38].setName("dicking.png");
                                floorMaps[38].setStatus(1);
                            }
                            else if(floorMaps[38].getStatus()==2){
                                floorMaps[38].setName("dickingwet.png");
                                floorMaps[38].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[38].getStatus()==0){
                                floorMaps[38].setName("wetfloor.png");
                                floorMaps[38].setStatus(2);
                            }
                            else if(floorMap[38].getStatus()==1){
                                floorMaps[38].setName("dickingwet.png");
                                floorMaps[38].setStatus(3);
                            }
                        }
                    }
                    else if(906<=player.getPosX() && player.getPosX()<=990 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[39].getStatus()==0) {
                                floorMaps[39].setName("dicking.png");
                                floorMaps[39].setStatus(1);
                            }
                            else if(floorMaps[39].getStatus()==2){
                                floorMaps[39].setName("dickingwet.png");
                                floorMaps[39].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[39].getStatus()==0){
                                floorMaps[39].setName("wetfloor.png");
                                floorMaps[39].setStatus(2);
                            }
                            else if(floorMap[39].getStatus()==1){
                                floorMaps[39].setName("dickingwet.png");
                                floorMaps[39].setStatus(3);
                            }
                        }
                    }
                    else if(1006<=player.getPosX() && player.getPosX()<=1090 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[40].getStatus()==0) {
                                floorMaps[40].setName("dicking.png");
                                floorMaps[40].setStatus(1);
                            }
                            else if(floorMaps[40].getStatus()==2){
                                floorMaps[40].setName("dickingwet.png");
                                floorMaps[40].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[40].getStatus()==0){
                                floorMaps[40].setName("wetfloor.png");
                                floorMaps[40].setStatus(2);
                            }
                            else if(floorMap[40].getStatus()==1){
                                floorMaps[40].setName("dickingwet.png");
                                floorMaps[40].setStatus(3);
                            }
                        }
                    }
                    else if(1106<=player.getPosX() && player.getPosX()<=1190 && player.getPosY()>=787 && player.getPosY()<=880){
                        if (mouseNumber==3) {
                            if(floorMaps[41].getStatus()==0) {
                                floorMaps[41].setName("dicking.png");
                                floorMaps[41].setStatus(1);
                            }
                            else if(floorMaps[41].getStatus()==2){
                                floorMaps[41].setName("dickingwet.png");
                                floorMaps[41].setStatus(4);
                            }
                        }
                        else if(mouseNumber==6){
                            if(floorMaps[41].getStatus()==0){
                                floorMaps[41].setName("wetfloor.png");
                                floorMaps[41].setStatus(2);
                            }
                            else if(floorMap[41].getStatus()==1){
                                floorMaps[41].setName("dickingwet.png");
                                floorMaps[41].setStatus(3);
                            }
                        }
                    }

                player.setMouseClicked(false);
            }


        }
        else{
            if(player.getPosX() >= 35 && player.getPosX()<=160 && player.getPosY() >=879  &&player.getPosY() <= 1005){
                mousChange(2);
                if (player.getmouseClicked()) {
                    camera.position.set(836, 7290, 0);
                    screenState = 0;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            }
//            else {
//                mousChange(1);
//                player.setMouseNotNormal(0);;
//                player.setMouseClicked(false);
//            }
        }
    }
    public void createFloor(){
        for (int i = 0 ; i<42;i++){
            floorMap[i] = new FloorStatus("normalfloor.png",0);
        }
        for (int i = 0 ; i<42;i++){
            floorMap2[i] = new FloorStatus("normalfloor.png",0);
        }
        for (int i = 0 ; i<42;i++){
            floorMap3[i] = new FloorStatus("normalfloor.png",0);
        }
        for (int i = 0 ; i<42;i++){
            floorMap4[i] = new FloorStatus("normalfloor.png",0);
        }
    }
}
// (506, 335) (506, 421) (590, 335) (590, 421)
