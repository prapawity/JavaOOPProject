package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObjects;
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
    private Pixmap pm,pm1,pm2,pm3,pm4,pm5,pm6,pm7;
    private FarmAcivities farmAcivity;
    private CameraMove cameraMove;
    private boolean showBuyWindowOpen;
    private Cursor cursor,cursor1,cursor2,cursor3,cursor4,cursor5,cursor6,cursor7;
	private TiledMap map;
	private Player player;
	private AssetManager manager;
    private float oldCameraX, oldCameraY;
    private HUD hud;
    private ShowImage showImage,backhome1,gotoMarket,buyWindow,overlay;
    private ShowImage greenHouse1,mouseSelect,weedTest,weedtest2,weedtest3,weedtest4, weedList[];
    private Timer timer;
    MapObjects mapObject;
    private FloorRender
    base, floorrender[][] ,weedrender[] [];

    private int positionX[] = {3153, 3258,3363,3468,3573,3678,3783},positionY[] = {6627,6527,6427,6327,6227,6127},loop = 0,mouseNumber = 1,day=0;

    FloorStatus floorMap[] = new FloorStatus[30];
    FloorStatus floorMap2[] = new FloorStatus[30];
    FloorStatus floorMap3[] = new FloorStatus[30];
    FloorStatus floorMap4[] = new FloorStatus[30];

    // Map properties
	private int tileWidth, tileHeight,
			mapWidthInTiles, mapHeightInTiles,
			mapWidthInPixels, mapHeightInPixels,store,load = 0;

	// Camera and render
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
	private int screenState=0;
    @Override
	public void create () {
        if(load==0){
            // Map loading
            timer = new Timer();
            player = new Player();
            manager = new AssetManager();
            manager.setLoader(TiledMap.class, new TmxMapLoader());
            manager.load("Genmap/Mainmap.tmx", TiledMap.class);
            manager.finishLoading();
            map = manager.get("Genmap/Mainmap.tmx", TiledMap.class);
            // Read properties
            MapProperties properties = map.getProperties();
            tileWidth = properties.get("tilewidth", Integer.class);
            tileHeight = properties.get("tileheight", Integer.class);
            mapWidthInTiles = properties.get("width", Integer.class);
            mapHeightInTiles = properties.get("height", Integer.class);
            mapWidthInPixels = mapWidthInTiles;
            mapHeightInPixels = mapHeightInTiles;


            createMouse();
            mousChange(1);


            hud = new HUD();
            // Set up the camera
            camera = new OrthographicCamera(3f, 3f);
            camera.position.x = 642f;
            camera.position.y = 6820f;
            // Instantiation of the render for the map object
            renderer = new OrthogonalTiledMapRenderer(map);
            // render Player
            showImage = new ShowImage(new Sprite(new Texture("Home.png")));


            gotoMarket = new ShowImage(new Sprite(new Texture("arrow.png")));

            greenHouse1 = new ShowImage(new Sprite(new Texture("farm.png")));

            overlay = new ShowImage(new Sprite(new Texture("overlay.png")));
            overlay.scale(100);
            buyWindow = new ShowImage(new Sprite(new Texture("testbuywindow.png")));
            weedTest = new ShowImage(new Sprite(new Texture("null.png")));
            weedtest2 = new ShowImage(new Sprite(new Texture("null.png")));
            weedtest3 = new ShowImage(new Sprite(new Texture("null.png")));
            weedtest4 = new ShowImage(new Sprite(new Texture("null.png")));
            buyWindow.scale(2.2f);
            base = new FloorRender(new Sprite(new Texture("base.png")));
            createFloor();

            floorrender = new FloorRender[5][6];
            weedrender = new FloorRender[5][6];

            weedList = new ShowImage[4];
            weedList[0] = weedTest;
            weedList[1] = weedtest2;
            weedList[2] = weedtest3;
            weedList[3] = weedtest4;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 6; j++) {


                    floorrender[i][j] = new FloorRender(new Sprite(new Texture(floorMap[loop].getName())));
                    weedrender[i][j] = new FloorRender(new Sprite(new Texture(floorMap[loop].getTree().getNameTree())));

                    loop++;

                }
            loop = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    floorrender[i][j].scale(8);
                    weedrender[i][j].scale(5);
                }
            }

            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 6; j++) {
                    floorrender[i][j].setPosition(positionX[j], positionY[i]);
                    weedrender[i][j].setPosition(positionX[j], positionY[i]);
                }


            base.setPosition(3418, 6425);
            base.scale(62.5f);

            backhome1 = new ShowImage(new Sprite(new Texture("backhome.png")));
            backhome1.setPosition(2820, 6080);
            backhome1.scale(1f);

            gotoMarket.scale(0.1f);

            gotoMarket.setPosition(840, 7620);


            showImage.scale(2);
            greenHouse1.scale(2);
            for (int i = 0; i < weedList.length; i++)
                weedList[i].scale(3.2f);


//		weed.scale(8);
//		weed.setPosition(3429,7149);
//        weed2.scale(8);
//        weed2.setPosition(3429,7240);
            //greenHouse  6785 6876 6976, 7058 , 7149 7240 (3429, 3529,3629,3729,3829,3929,4029)
            mouseSelect = new ShowImage(new Sprite(new Texture("mouseselect.png")));
            mouseSelect.setPosition(806, 469);
            mouseSelect.scale(10);

            showImage.setPosition(215, 7620); // House1
            //farm 836,7290
            // greenHouse1 3722,7059
            player.update();

            pm = new Pixmap(Gdx.files.internal("mouse.png"));
            cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")), 0, 0);
            Gdx.graphics.setCursor(cursor);
            load++;
        }

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
        weedTest.setPosition(camera.position.x+35,camera.position.y-480);
        weedtest2.setPosition(camera.position.x+119,camera.position.y-480);
        weedtest3.setPosition(camera.position.x+200,camera.position.y-480);
        weedtest4.setPosition(camera.position.x+285,camera.position.y-480);

        switch (screenState){
            case 0:{
                for(int i = 0 ; i<5;i++)
                    for(int j = 0;j<6;j++) {
                        floorrender[i][j].getTexture().dispose();
                        weedrender[i][j].getTexture().dispose();
                    }
                zeroScreen();
                break;
            }
            case 1:firstScreen(floorMap);break;
            case 2:firstScreen(floorMap2);break;
            case 3:firstScreen(floorMap3);break;
            case 4:firstScreen(floorMap4);break;
            case 5:fiveScreen();break;
        }
        backhome1.draw(renderer.getBatch());
        mouseSelect.draw(renderer.getBatch());
        renderer.getBatch().end();
        this.hud.render();
        renderer.getBatch().begin();
        weedTest.draw(renderer.getBatch());
        weedtest2.draw(renderer.getBatch());
        weedtest3.draw(renderer.getBatch());
        weedtest4.draw(renderer.getBatch());
        renderer.getBatch().end();
        this.renderer = new OrthogonalTiledMapRenderer(this.map, 1.1f);
        if(player.getStatusExit()==1){
            dispose();



        }
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
        map.dispose();
        Gdx.app.exit();

    }



	private void mousChange(int type){
        switch (type){
            case 1:{
                pm = pm1;
                cursor = cursor1;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 1;
            }break;
            case 2:{
                pm = pm2;
                cursor = cursor2;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 2;
            }break;
            case 3:{
                pm = pm3;
                cursor = cursor3;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 3;
            }break;
            case 4:{
                pm = pm4;
                cursor = cursor4;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 4;
            }break;
            case 5:{
                pm = pm5;
                cursor = cursor5;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 5;
            }break;
            case 6:{;
                pm = pm6;
                cursor = cursor6;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 6;
            }break;
            case 7:{
                pm = pm7;
                cursor = cursor7;
                Gdx.graphics.setCursor(cursor);
                mouseNumber = 7;
            }break;
        }


    }




    public void hudShowing(){

        if (player.getPosX() >= 384 && player.getPosX() <= 443 && player.getPosY() >= 649 && player.getPosY() <= 701) {
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
        } else if (player.getPosX() <= 504 && player.getPosX() >= 449 && player.getPosY() >= 649 && player.getPosY() <= 701) {
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
        } else if (player.getPosX() <= 568 && player.getPosX() >= 513 && player.getPosY() >= 649 && player.getPosY() <= 701) {
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
        } else if (player.getPosX() <= 631 && player.getPosX() >= 578 && player.getPosY() >= 649 && player.getPosY() <= 701) {
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












        } else if (player.getPosX() <= 699 && player.getPosX() >= 641 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mousChange(2);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mousChange(7);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mousChange(1);
            }
        } else if (player.getPosX() <= 760 && player.getPosX() >= 704 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mousChange(2);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mousChange(7);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mousChange(1);
            }
        } else if (player.getPosX() <= 824 && player.getPosX() >= 766 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mousChange(2);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mousChange(7);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mousChange(1);
            }
        } else if (player.getPosX() <= 890 && player.getPosX() >= 831 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mousChange(2);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mousChange(7);
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

    public int getMouseNumber() {
        return mouseNumber;
    }

    public void setMouseNumber(int mouseNumber) {
        this.mouseNumber = mouseNumber;
    }

    public void farmActivities(FloorStatus[] floorMaps){
        if(player.getMouseNotNormal()==1) farmAcivity = new FarmAcivities(floorMaps,player,mouseNumber);
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
            else {
                mousChange(1);
                player.setMouseNotNormal(0);;
                player.setMouseClicked(false);
            }
        }
    }
    public void createFloor(){
        for (int i = 0 ; i<30;i++){
            Tree trees = new Tree("null.png",false,0);
            floorMap[i] = new FloorStatus("normalfloor.png",0,trees);
        }
        for (int i = 0 ; i<30;i++){
            Tree trees = new Tree("null.png",false,0);
            floorMap2[i] = new FloorStatus("normalfloor.png",0,trees);
        }
        for (int i = 0 ; i<30;i++){
            Tree trees = new Tree("null.png",false,0);
            floorMap3[i] = new FloorStatus("normalfloor.png",0,trees);
        }
        for (int i = 0 ; i<30;i++){
            Tree trees = new Tree("null.png",false,0);
            floorMap4[i] = new FloorStatus("normalfloor.png",0,trees);
        }
    }
    public void nextDay(){

    }

    public void showBuyWindow(int store){
        overlay.setPosition(camera.position.x,camera.position.y);
        overlay.draw(renderer.getBatch());
        buyWindow.setPosition(camera.position.x-250,camera.position.y-90);
        buyWindow.draw(renderer.getBatch());
        switch (store){
            case 1:{

            }
            case 2:{

            }
            case 3:{

            }case 4:{

            }
            case 5:{

            }
        }

    }

    public void zeroScreen() {


            cameraMove = new CameraMove(camera,player,0);


            hudShowing();

            //GreenHouse First
            if (camera.position.x == 642 && camera.position.y == 6820) {
                if (player.getPosX() <= 410 && player.getPosX() >= 189 && player.getPosY() >= 92 && player.getPosY() <= 245) {
                    greenHouse1.setPosition(197, 6970); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3420, 6390, 0);
                        screenState = 1;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                } else if (player.getPosX() >= 212 && player.getPosX() <= 460 && player.getPosY() >= 83 && player.getPosY() <= 268) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    showImage.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {

                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() < 1478 && player.getPosX() >= 1176 && player.getPosY() >= 227 && player.getPosY() <= 440) {
                    greenHouse1.setPosition(1233, 7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() > 731 && player.getPosX() <= 1116 && player.getPosY() >= 0 && player.getPosY() <= 105) {
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    gotoMarket.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(1130, 5541, 0);
                        screenState = 5;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }
                else player.setMouseClicked(false);
            } else if (camera.position.x == 1463 && camera.position.y == 7290) {
                if (player.getPosX() <= 850 && player.getPosX() >= 550 && player.getPosY() >= 227 && player.getPosY() <= 439) {
                    greenHouse1.setPosition(1233, 7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() >= 1146 && player.getPosX() <= 1446 && player.getPosY() >= 226 && player.getPosY() <= 439) {
                    greenHouse1.setPosition(1828, 7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 4;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() >= 50 && player.getPosX() <= 349 && player.getPosY() >= 782 && player.getPosY() <= 996) {
                    greenHouse1.setPosition(735, 6852);
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                }else player.setMouseClicked(false);

            } else if (camera.position.x == 836 && camera.position.y == 7059) {
                if (player.getPosX() <= 478 && player.getPosX() >= 178 && player.getPosY() >= 167 && player.getPosY() <= 379) {
                    greenHouse1.setPosition(235, 7240); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 1;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() >= 677 && player.getPosX() <= 973 && player.getPosY() >= 546 && player.getPosY() <= 762) {
                    greenHouse1.setPosition(735, 6852); // greenHouse1
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 2;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }

                } else if (player.getPosX() >= 1178 && player.getPosX() <= 1478 && player.getPosY() >= 0 && player.getPosY() <= 206) {
                    greenHouse1.setPosition(1233, 7412); //greenHouse2
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
                else player.setMouseClicked(false);

            } else if (camera.position.x == 1463 && camera.position.y == 7059) {
                if (player.getPosX() >= 617 && player.getPosX() <= 641 && player.getPosY() >= 174 && player.getPosY() <= 206) {
                    greenHouse1.setPosition(1233, 7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 3;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    } else mousChange(1);
                } else if (player.getPosX() >= 1214 && player.getPosX() <= 1237 && player.getPosY() >= 174 && player.getPosY() <= 206) {
                    greenHouse1.setPosition(1828, 7412); //greenHouse2
                    if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                        mousChange(2);
                    greenHouse1.draw(renderer.getBatch());
                    if (player.getmouseClicked()) {
                        camera.position.set(3722, 7100, 0);
                        screenState = 4;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    } else mousChange(1);
                } else if (player.getPosX() >= 119 && player.getPosX() <= 143 && player.getPosY() >= 730 && player.getPosY() <= 759) {
                    greenHouse1.setPosition(735, 6852); // greenHouse1
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
                else player.setMouseClicked(false);

            }else player.setMouseClicked(false);

    }

    public void firstScreen(FloorStatus floorMapz[]){
        showImage.getTexture().dispose();
        gotoMarket.getTexture().dispose();
        greenHouse1.getTexture().dispose();

        for(int i = 0 ; i<5;i++)
            for(int j = 0;j<6;j++) {
                floorrender[i][j].setTexture(new Texture(floorMapz[loop].getName()));
                weedrender[i][j].setTexture(new Texture(floorMapz[loop].getTree().getNameTree()));
                loop++;
            }
        hudShowing();
        farmActivities(floorMapz);
        base.draw(renderer.getBatch());
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 6; j++) {
                floorrender[i][j].draw(renderer.getBatch());
                weedrender[i][j].draw(renderer.getBatch());
            }

    }
    public void fiveScreen(){

        if(showBuyWindowOpen == false) {

            cameraMove = new CameraMove(camera,player,1);


            if(player.getPosX()>=249 && player.getPosX() <= 285 && player.getPosY()>=269 &&player.getPosY() <= 306){
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    store = 1;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            }else if(player.getPosX()>=202 && player.getPosX() <= 440 && player.getPosY()>=503 &&player.getPosY() <= 692){
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    mousChange(1);
                    store = 2;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            }
            else if(player.getPosX() >= 718 &&  player.getPosX()<= 888 && player.getPosY() >= 786 && player.getPosY()<= 950){
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mousChange(2);
                if (player.getmouseClicked()) {
                    camera.position.set(836, 7290, 0);
                    screenState = 0;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            }else mousChange(1);
        }
        else {
            showBuyWindow(store);
        }
    }
    public void createMouse(){
            pm = new Pixmap(Gdx.files.internal("mouse.png"));
            cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")),0,0);
           pm1 = new Pixmap(Gdx.files.internal("mouse.png"));
           cursor1 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouse.png")),0,0);

           pm2 = new Pixmap(Gdx.files.internal("hand.png"));
           cursor2 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("hand.png")), 0, 0);


           pm3 = new Pixmap(Gdx.files.internal("shovel.png"));
           cursor3 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("shovel.png")), 0, 0);


           pm4 = new Pixmap(Gdx.files.internal("picaxe.png"));
           cursor4 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("picaxe.png")), 0, 0);


           pm5 = new Pixmap(Gdx.files.internal("axe.png"));
           cursor5 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("axe.png")), 0, 0);


           pm6 = new Pixmap(Gdx.files.internal("watering.png"));
           cursor6 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("watering.png")), 0, 0);


           pm7 = new Pixmap(Gdx.files.internal("mouseweedbag1.png"));
           cursor7 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("mouseweedbag1.png")), 0, 0);



    }
}
// (506, 335) (506, 421) (590, 335) (590, 421)
