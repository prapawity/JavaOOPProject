package com.mygdx.game;

import com.badlogic.gdx.Game;
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
import com.mygdx.game.MapBitPriority.HUD;
import com.mygdx.game.entitirs.Player;
import com.mygdx.game.entitirs.ShowImage;

import java.io.Serializable;
import java.util.ArrayList;

public class MyGdxGame extends Game implements Serializable {
    // Set Value
    private FarmAcivities farmAcivity;
    private CameraMove cameraMove = new CameraMove();
    private boolean showBuyWindowOpen;
    private TiledMap map;
    private Player player;
    private AssetManager manager;
    private HUD hud;
    private ShowImage showImage, backhome1, gotoMarket, WhiteScreen, logo, Openpic, newGame, loadGame, exitGame, blackScreen;
    private ShowImage greenHouse1, mouseSelect, weedTest, weedtest2, weedtest3, weedtest4, weedtest5, weedList[], move, windowBuy;
    float opacity, opcacitylogo;
    private String logoPng[];
    private ShowingHudMoney showingHudMoney;
    private ShowingBuyWindow showBuyWindow;
    private MouseChange mouseChange;
    private LoadingScreen loadingScreen;
    private BagRender bagRender;
    private ChangeSound changeSound;
    private FarmAcivities farmAcivities;
    private SavingNextDay savingNextDay;
    private ArrayList<SlotBag> slotBag = new ArrayList<SlotBag>(4);
    private TreeNextGrowth treeNextGrowth = new TreeNextGrowth();
    private SaveObject saveObject = new SaveObject();

    long id;

    private FloorRender
            base, floorrender[][], weedrender[][];
    private int positionX[] = {3153, 3258, 3363, 3468, 3573, 3678, 3783}, positionY[] = {6627, 6527, 6427, 6327, 6227, 6127}, loop = 0, mouseNumber = 1, day = 1, logostate = 0;

    FloorStatus floorMap[] = new FloorStatus[30];
    FloorStatus floorMap2[] = new FloorStatus[30];
    FloorStatus floorMap3[] = new FloorStatus[30];
    FloorStatus floorMap4[] = new FloorStatus[30];

    // Map properties
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels, store, timing;

    // Camera and render
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    private int screenState = -2, time, money = 500, statusHowto = 0;
    private HowTo howTo;


    @Override
    public void create() {
        // Map loading
        player = new Player();
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load(Gdx.files.internal("GenerateMap/Genmap/Mainmap.tmx").toString(), TiledMap.class);
        manager.finishLoading();
        map = manager.get(Gdx.files.internal("GenerateMap/Genmap/Mainmap.tmx").toString(), TiledMap.class);
        // Read properties
        MapProperties properties = map.getProperties();
        tileWidth = properties.get("tilewidth", Integer.class);
        tileHeight = properties.get("tileheight", Integer.class);
        mapWidthInTiles = properties.get("width", Integer.class);
        mapHeightInTiles = properties.get("height", Integer.class);
        mapWidthInPixels = mapWidthInTiles;
        mapHeightInPixels = mapHeightInTiles;
        camera = new OrthographicCamera(3f, 3f);
        camera.position.x = 10000f;
        camera.position.y = 10000f;
        // Instantiation of the render for the map object
        renderer = new OrthogonalTiledMapRenderer(map);

        hud = new HUD();
        // Set up the camera
        // render Player
        showImage = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/Home.png"))));


        gotoMarket = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/arrow.png"))));

        greenHouse1 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/farm.png"))));
        for (int i = 0; i < 4; i++) slotBag.add(new SlotBag());

        weedTest = new ShowImage(new Sprite(new Texture(slotBag.get(0).getName())));
        weedtest2 = new ShowImage(new Sprite(new Texture(slotBag.get(1).getName())));
        weedtest3 = new ShowImage(new Sprite(new Texture(slotBag.get(2).getName())));
        weedtest4 = new ShowImage(new Sprite(new Texture(slotBag.get(3).getName())));
        weedtest5 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/howtopop/2.png"))));
        base = new FloorRender(new Sprite(new Texture(Gdx.files.internal("GenerateMap/base.png"))));
        createFloor();

        floorrender = new FloorRender[5][6];
        weedrender = new FloorRender[5][6];

        weedList = new ShowImage[5];
        weedList[0] = weedTest;
        weedList[1] = weedtest2;
        weedList[2] = weedtest3;
        weedList[3] = weedtest4;
        weedList[4] = weedtest5;
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

        backhome1 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/backhome.png"))));
        backhome1.setPosition(2820, 6080);
        backhome1.scale(1f);


        showImage.scale(2);
        greenHouse1.scale(2);
        for (int i = 0; i < weedList.length - 1; i++)
            weedList[i].scale(2f);
        weedList[4].scale(1.3f);

//		weed.scale(8);
//		weed.setPosition(3429,7149);
//        weed2.scale(8);
//        weed2.setPosition(3429,7240);
        //greenHouse  6785 6876 6976, 7058 , 7149 7240 (3429, 3529,3629,3729,3829,3929,4029)
        mouseSelect = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/mouseselect.png"))));
        mouseSelect.setPosition(806, 469);
        mouseSelect.scale(10);

        showImage.setPosition(250, 7620); // House1
        //farm 836,7290
        // greenHouse1 3722,7059
        player.update();

        mouseChange = new MouseChange();
        mouseChange.create();
        mouseNumber = mouseChange.render(1, mouseNumber);


        WhiteScreen = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/WhiteScreen.png"))));
        WhiteScreen.setPosition(camera.position.x - 600, camera.position.y - 370);
        WhiteScreen.scale(2);

        blackScreen = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/blackScreen.png"))));
        blackScreen.setPosition(camera.position.x - 600, camera.position.y - 370);
        blackScreen.scale(10);
        Openpic = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/OpenPic2.png"))));
        Openpic.setPosition(camera.position.x - 640, camera.position.y - 358);

        logoPng = new String[3];
        logoPng[0] = Gdx.files.internal("GenerateMap/logoit1.png").toString();
        logoPng[1] = Gdx.files.internal("GenerateMap/logokmitl1.png").toString();
        logoPng[2] = Gdx.files.internal("GenerateMap/logoIlove.png").toString();
        logo = new ShowImage(new Sprite(new Texture(logoPng[0])));
        logo.setPosition(camera.position.x - 250, camera.position.y - 220);

        newGame = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/OpenPic/new1.png"))));
        loadGame = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/OpenPic/load1.png"))));
        exitGame = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/OpenPic/exit1.png"))));
        newGame.setPosition(camera.position.x - 330, camera.position.y - 220);
        loadGame.setPosition(camera.position.x - 30, camera.position.y - 220);
        exitGame.setPosition(camera.position.x + 260, camera.position.y - 220);
        newGame.scale(1.4f);
        loadGame.scale(1.4f);
        exitGame.scale(1.4f);
        showingHudMoney = new ShowingHudMoney();
        showingHudMoney.create();
        showBuyWindow = new ShowingBuyWindow();
        showBuyWindow.create();
        loadingScreen = new LoadingScreen();
        loadingScreen.create();
        bagRender = new BagRender();
        changeSound = new ChangeSound();
        changeSound.create();
        farmAcivity = new FarmAcivities();
        howTo = new HowTo();
        howTo.create();
        savingNextDay = new SavingNextDay();
        savingNextDay.create();
        move = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/Move/up.png"))));
        windowBuy = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/windowBuy/pumkin.png"))));


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		 Update the camera and render
        camera.update();
        renderer.setView(camera);
        renderer.render();
        renderer.getBatch().begin();
        loop = 0;
        changeSound.openSound.play();
        switch (screenState) {
            case -3:
                nextDay();
                break;
            case -2:
                OpenScreen();
                break;
            case -1:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 0:
                zeroScreen();
                break;
            case 1:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 2:
                firstScreen(floorMap);
                break;
            case 3:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 4:
                firstScreen(floorMap2);
                break;
            case 5:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 6:
                firstScreen(floorMap3);
                break;
            case 7:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 8:
                firstScreen(floorMap4);
                break;
            case 9:
                screenState += loadingScreen.render(renderer, camera);
                break;
            case 10:
                fiveScreen();
                break;
        }
        mouseSelect.draw(renderer.getBatch());
        renderer.getBatch().end();
        if (screenState % 2 == 0 & screenState >= 0) {
            this.hud.render();
            renderer.getBatch().begin();
            bagRender.render(weedList, renderer, camera);
            if (statusHowto <= 3) {
                howTo.render(renderer, camera, statusHowto);
            }
            move.draw(renderer.getBatch());
            renderer.getBatch().end();
        }
        this.renderer = new OrthogonalTiledMapRenderer(this.map, 1.1f);
        if (player.getStatusExit() == 1) {
            dispose();
        }
    }


    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
        player.update();

    }

    @Override
    public void dispose() {
        // Free resources
        map.dispose();
        manager.dispose();
        changeSound.openSound.dispose();
        Openpic.getTexture().dispose();
        logo.getTexture().dispose();
        newGame.getTexture().dispose();
        loadGame.getTexture().dispose();
        exitGame.getTexture().dispose();
        WhiteScreen.getTexture().dispose();
        blackScreen.getTexture().dispose();
        showingHudMoney.dispose();
        showBuyWindow.dispose();
        loadingScreen.dispose();
        farmAcivity.sound.dispose();
        farmAcivity.sound2.dispose();
        farmAcivity.sound3.dispose();
        savingNextDay.dispose();
        howTo.dispose();
        Gdx.app.exit();

    }


    public void hudShowing() {
        bagRender.render(weedList, renderer, camera);
        if (screenState == 10) {
            if (showBuyWindowOpen == true) showingHudMoney.showHudMoney(renderer, camera, money, day);
        } else showingHudMoney.showHudMoney(renderer, camera, money, day);
        if (player.getPosX() >= 384 && player.getPosX() <= 443 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && !player.getmouseClicked())
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(3, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(4, mouseNumber);
            }
        } else if (player.getPosX() <= 504 && player.getPosX() >= 449 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(5, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosX() <= 568 && player.getPosX() >= 513 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(4, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosX() <= 631 && player.getPosX() >= 578 && player.getPosY() >= 649 && player.getPosY() <= 701) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(6, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }

        } else if (player.getPosX() <= 699 && player.getPosX() >= 641 && player.getPosY() >= 649 && player.getPosY() <= 701 && !slotBag.get(0).getName().equals(Gdx.files.internal("GenerateMap/null2.png")) && slotBag.get(0).getCoun() > 0) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(7, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosX() <= 760 && player.getPosX() >= 704 && player.getPosY() >= 649 && player.getPosY() <= 701 && !slotBag.get(1).getName().equals(Gdx.files.internal("GenerateMap/null2.png")) && slotBag.get(1).getCoun() > 0) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(10, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosX() <= 824 && player.getPosX() >= 766 && player.getPosY() >= 649 && player.getPosY() <= 701 && !slotBag.get(2).getName().equals(Gdx.files.internal("GenerateMap/null2.png")) && slotBag.get(2).getCoun() > 0) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(11, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosX() <= 890 && player.getPosX() >= 831 && player.getPosY() >= 649 && player.getPosY() <= 701 && !slotBag.get(3).getName().equals(Gdx.files.internal("GenerateMap/null2.png")) && slotBag.get(3).getCoun() > 0) {
            if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                mouseNumber = mouseChange.render(2, mouseNumber);
            else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 0) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(1);
                mouseNumber = mouseChange.render(12, mouseNumber);
            } else if (player.getmouseClicked() == true && player.getMouseNotNormal() == 1) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                mouseNumber = mouseChange.render(1, mouseNumber);
            }
        } else if (player.getPosY() >= 651 && player.getPosX() >= 905 && player.getPosX() <= 953 && player.getPosY() <= 703) {
            weedList[4].getTexture().dispose();
            weedList[4].setTexture(new Texture(Gdx.files.internal("GenerateMap/howtopop/1.png")));
            if (player.getmouseClicked()) {
                statusHowto = 0;
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
            }

        } else {
            if (player.getMouseNotNormal() == 0)
                mouseNumber = mouseChange.render(1, mouseNumber);
            weedList[4].getTexture().dispose();
            weedList[4].setTexture(new Texture(Gdx.files.internal("GenerateMap/howtopop/2.png")));
        }
        for (int i = 0; i <= 3; i++) {
            if (slotBag.get(i).getCoun() == 0) {
                if (!slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                    System.out.println(slotBag.get(i).getName());
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    mouseNumber = mouseChange.render(1, mouseNumber);
                    slotBag.get(i).setName(Gdx.files.internal("GenerateMap/null2.png").toString());
                }
            }
        }

    }

    public int getMouseNumber() {
        return mouseNumber;
    }

    public void setMouseNumber(int mouseNumber) {
        this.mouseNumber = mouseNumber;
    }

    public void farmActivities(FloorStatus[] floorMaps) {
        blinkWeed(floorMap);
        blinkWeed(floorMap2);
        blinkWeed(floorMap3);
        blinkWeed(floorMap4);
        timing++;
        if (player.getMouseNotNormal() == 1)
            money = farmAcivity.FarmAcivities(floorMaps, player, mouseNumber, mouseChange, money, slotBag);
        else {
            if (player.getPosX() >= 28 && player.getPosX() <= 105 && player.getPosY() >= 595 && player.getPosY() <= 677) {
                mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    changeSound.openSound.dispose();
                    changeSound.changeSound(1);
                    camera.position.set(642, 6820, 0);
                    screenState = -1;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                    for (int i = 0; i < 5; i++)
                        for (int j = 0; j < 6; j++) {
                            floorrender[i][j].getTexture().dispose();
                            weedrender[i][j].getTexture().dispose();
                            loop++;
                        }
                }
            } else {
                mouseNumber = mouseChange.render(1, mouseNumber);
                if (player.getmouseClicked()) {
                    player.setMouseNotNormal(0);
                    player.setMouseClicked(false);
                    statusHowto++;
                }
            }
        }
        for (int i = 0; i <= 3; i++) {
            weedList[i].getTexture().dispose();
            weedList[i].setTexture(new Texture(slotBag.get(i).getName()));
        }

    }

    public void createFloor() {
        for (int i = 0; i < 30; i++) {
            Tree trees = new Tree(Gdx.files.internal("GenerateMap/null.png").toString(), false, 0);
            floorMap[i] = new FloorStatus(Gdx.files.internal("GenerateMap/normalfloor.png").toString(), 0, trees);
        }
        for (int i = 0; i < 30; i++) {
            Tree trees = new Tree(Gdx.files.internal("GenerateMap/null.png").toString(), false, 0);
            floorMap2[i] = new FloorStatus(Gdx.files.internal("GenerateMap/normalfloor.png").toString(), 0, trees);
        }
        for (int i = 0; i < 30; i++) {
            Tree trees = new Tree(Gdx.files.internal("GenerateMap/null.png").toString(), false, 0);
            floorMap3[i] = new FloorStatus(Gdx.files.internal("GenerateMap/normalfloor.png").toString(), 0, trees);
        }
        for (int i = 0; i < 30; i++) {
            Tree trees = new Tree(Gdx.files.internal("GenerateMap/null.png").toString(), false, 0);
            floorMap4[i] = new FloorStatus(Gdx.files.internal("GenerateMap/normalfloor.png").toString(), 0, trees);
        }
    }

    public void nextDay() {
        screenState = savingNextDay.render(renderer, camera, screenState);
        if (screenState == 0) {
            changeSound.openSound.dispose();
            changeSound.changeSound(1);
            for (int i = 0; i < 30; i++) {
                floorMap[i].setName(Gdx.files.internal("GenerateMap/normalfloor.png").toString());
                floorMap[i].setStatus(0);
            }
            for (int i = 0; i < 30; i++) {
                floorMap2[i].setName(Gdx.files.internal("GenerateMap/normalfloor.png").toString());
                floorMap2[i].setStatus(0);
            }
            for (int i = 0; i < 30; i++) {
                floorMap3[i].setName(Gdx.files.internal("GenerateMap/normalfloor.png").toString());
                floorMap3[i].setStatus(0);
            }
            for (int i = 0; i < 30; i++) {
                floorMap4[i].setName(Gdx.files.internal("GenerateMap/normalfloor.png").toString());
                floorMap4[i].setStatus(0);
            }
            treeNextGrowth.growth(floorMap, floorMap2, floorMap3, floorMap4, day);
            day++;
            saveObject = new SaveObject(day, money, floorMap, floorMap2, floorMap3, floorMap4, slotBag);
            SaveGame.write(saveObject);
        }

    }


    public void zeroScreen() {
        showImage.getTexture().dispose();
        showImage.setTexture(new Texture(Gdx.files.internal("GenerateMap/Home.png")));
        changeSound.openSound.setVolume(1);
        hudShowing();
        //GreenHouse First
        if (camera.position.x == 642 && camera.position.y == 6820) {
            if (player.getPosX() <= 410 && player.getPosX() >= 189 && player.getPosY() >= 92 && player.getPosY() <= 245 & statusHowto > 3) {
                showImage.setPosition(350, 7050);
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                showImage.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    changeSound.openSound.dispose();
                    changeSound.changeSound(4);
                    screenState = -3;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            } else if (player.getPosX() >= 157 && player.getPosX() <= 431 && player.getPosY() >= 381 && player.getPosY() <= 576 & statusHowto > 3) {
                greenHouse1.setPosition(215, 6637);
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    changeSound.openSound.dispose();
                    changeSound.changeSound(3);
                    camera.position.set(3420, 6390, 0);
                    screenState = 1;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() < 1250 && player.getPosX() >= 1073 && player.getPosY() >= 219 && player.getPosY() <= 405 & statusHowto > 3) {
                greenHouse1.setPosition(1130, 6796); //greenHouse2
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    changeSound.openSound.dispose();
                    changeSound.changeSound(3);
                    camera.position.set(3420, 6390, 0);
                    screenState = 3;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() > 665 && player.getPosX() <= 1019 && player.getPosY() >= 0 && player.getPosY() <= 112 & statusHowto > 3) {
                gotoMarket.getTexture().dispose();
                gotoMarket.setTexture(new Texture(Gdx.files.internal("GenerateMap/arrow.png")));
                gotoMarket.setPosition(750, 6970);
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                gotoMarket.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    camera.position.set(1055, 5160, 0);
                    screenState = 9;
                    changeSound.openSound.dispose();
                    changeSound.changeSound(2);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            }
            if (player.getPosY() >= 650 && statusHowto > 3 && !(player.getPosY() >= 651 && player.getPosX() >= 905 && player.getPosX() <= 953 && player.getPosY() <= 703)) {
                //move.setPosition(camera.position.x-640,camera.position.y-360); //up
                move.setPosition(camera.position.x - 640, camera.position.y - 368);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/down.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 4);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 1220 && statusHowto > 3) {
                move.setPosition(camera.position.x - 640, camera.position.y - 360);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/right.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 3);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            } else if (player.getmouseClicked()) {
                statusHowto++;
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
            } else {
                move.setPosition(10000, 1000);
                player.setMouseClicked(false);
            }
        } else if (camera.position.x == 1470 && camera.position.y == 6820) {
            if (player.getPosX() <= 516 && player.getPosX() >= 245 && player.getPosY() >= 221 && player.getPosY() <= 416) {
                greenHouse1.setPosition(1130, 6796);
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    changeSound.openSound.dispose();
                    changeSound.changeSound(3);
                    camera.position.set(3420, 6390, 0);
                    screenState = 3;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 786 && player.getPosX() <= 1065 && player.getPosY() >= 225 && player.getPosY() <= 417) {
                greenHouse1.setPosition(1676, 6796);
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    camera.position.set(3420, 6390, 0);
                    screenState = 7;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 50 && player.getPosX() <= 349 && player.getPosY() >= 782 && player.getPosY() <= 996) {
                greenHouse1.setPosition(672, 6285); // greenHouse1
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    camera.position.set(3420, 6390, 0);
                    screenState = 5;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() <= 55) {
                //move.setPosition(camera.position.x-640,camera.position.y-360); //up
                move.setPosition(camera.position.x - 640, camera.position.y - 368);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/left.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 1);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            } else if (player.getPosY() >= 650 && !(player.getPosY() >= 651 && player.getPosX() >= 905 && player.getPosX() <= 953 && player.getPosY() <= 703)) {
                //move.setPosition(camera.position.x-640,camera.position.y-360); //up
                move.setPosition(camera.position.x - 640, camera.position.y - 368);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/down.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 2);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            } else if (player.getmouseClicked()) {
                statusHowto++;
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
            } else {
                player.setMouseClicked(false);
                move.setPosition(10000, 1000);
            }

        } else if (camera.position.x == 642 && camera.position.y == 6349) {
            if (player.getPosX() >= 614 && player.getPosX() <= 887 && player.getPosY() >= 264 && player.getPosY() <= 455) {
                greenHouse1.setPosition(672, 6285); // greenHouse1
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                greenHouse1.draw(renderer.getBatch());
                if (player.getmouseClicked()) {
                    camera.position.set(3420, 6390, 0);
                    screenState = 5;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            }
            if (player.getPosY() <= 55) {
                //650 down 55up
                move.setPosition(camera.position.x - 640, camera.position.y - 360); //up
                //move.setPosition(camera.position.x - 640, camera.position.y - 368); //down
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/up.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 1);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 1220) {
                move.setPosition(camera.position.x - 640, camera.position.y - 360);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/right.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 2);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }

            } else if (player.getmouseClicked()) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                statusHowto++;
            } else {
                player.setMouseClicked(false);
                move.setPosition(1000, 10000);
            }

        } else if (camera.position.x == 1470 & camera.position.y == 6349) {
            if (player.getPosX() <= 55) {
                //move.setPosition(camera.position.x-640,camera.position.y-360); //up
                move.setPosition(camera.position.x - 640, camera.position.y - 368);
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/left.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 4);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosY() <= 55) {
                //650 down 55up
                move.setPosition(camera.position.x - 640, camera.position.y - 360); //up
                //move.setPosition(camera.position.x - 640, camera.position.y - 368); //down
                move.getTexture().dispose();
                move.setTexture(new Texture(Gdx.files.internal("GenerateMap/Move/up.png")));
                if (player.getmouseClicked()) {
                    move.setPosition(10000, 1000);
                    cameraMove.CameraMove(camera, 3);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getmouseClicked()) {
                player.setMouseClicked(false);
                player.setMouseNotNormal(0);
                statusHowto++;
            } else {
                player.setMouseClicked(false);
                move.setPosition(1000, 10000);
            }

        } else player.setMouseClicked(false);


    }

    public void firstScreen(FloorStatus floorMapz[]) {
        backhome1.draw(renderer.getBatch());
        changeSound.openSound.setVolume(0.3f);

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 6; j++) {
                floorrender[i][j].getTexture().dispose();
                floorrender[i][j].setTexture(new Texture(floorMapz[loop].getName()));
                weedrender[i][j].getTexture().dispose();
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

    public void fiveScreen() {
        hudShowing();

        if (showBuyWindowOpen == false) {

            if (player.getPosX() >= 37 && player.getPosX() <= 194 && player.getPosY() >= 30 && player.getPosY() <= 219) {
                showImage.getTexture().dispose();
                showImage.setTexture(new Texture("GenerateMap/market/1.png"));
                showImage.setPosition(camera.position.x - 480, camera.position.y + 250);
                showImage.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    store = 1;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 501 && player.getPosX() <= 669 && player.getPosY() >= 34 && player.getPosY() <= 218) {
                showImage.getTexture().dispose();
                showImage.setTexture(new Texture("GenerateMap/market/2.png"));
                showImage.setPosition(camera.position.x, camera.position.y + 250);
                showImage.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    mouseNumber = mouseChange.render(1, mouseNumber);
                    store = 2;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 992 && player.getPosX() <= 1111 && player.getPosY() >= 47 && player.getPosY() <= 202) {
                showImage.getTexture().dispose();
                showImage.setTexture(new Texture("GenerateMap/market/3.png"));
                showImage.setPosition(camera.position.x + 455, camera.position.y + 250);
                showImage.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    mouseNumber = mouseChange.render(1, mouseNumber);
                    store = 3;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 39 && player.getPosX() <= 252 && player.getPosY() >= 419 && player.getPosY() <= 590) {
                showImage.getTexture().dispose();
                showImage.setTexture(new Texture("GenerateMap/market/4.png"));
                showImage.setPosition(camera.position.x - 480, camera.position.y - 120);
                showImage.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    mouseNumber = mouseChange.render(1, mouseNumber);
                    store = 4;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 956 && player.getPosX() <= 1163 && player.getPosY() >= 428 && player.getPosY() <= 590) {
                showImage.getTexture().dispose();
                showImage.setTexture(new Texture("GenerateMap/market/5.png"));
                showImage.setPosition(camera.position.x + 455, camera.position.y - 120);
                showImage.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    showBuyWindowOpen = true;
                    mouseNumber = mouseChange.render(1, mouseNumber);
                    store = 5;
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else if (player.getPosX() >= 499 && player.getPosX() <= 693 && player.getPosY() >= 503 && player.getPosY() <= 645) {
                gotoMarket.getTexture().dispose();
                gotoMarket.setTexture(new Texture("GenerateMap/arrow2.png"));
                gotoMarket.setPosition(camera.position.x - 140, camera.position.y - 290);
                gotoMarket.draw(renderer.getBatch());
                if (player.getMouseNotNormal() == 0 && player.getmouseClicked() == false)
                    mouseNumber = mouseChange.render(2, mouseNumber);
                if (player.getmouseClicked()) {
                    camera.position.set(642, 6820, 0);
                    screenState = -1;
                    changeSound.openSound.dispose();
                    changeSound.changeSound(1);
                    player.setMouseClicked(false);
                    player.setMouseNotNormal(0);
                }
            } else mouseNumber = mouseChange.render(1, mouseNumber);

        } else {
            windowBuy.getTexture().dispose();
            windowBuy.setPosition(camera.position.x - 640, camera.position.y - 355);
            showBuyWindowOpen = showBuyWindow.showBuyWindow(renderer, camera, player);
            mouseNumber = mouseChange.render(1, mouseNumber);
            hudShowing();
            switch (store) {
                case 1: {
                    windowBuy.setTexture(new Texture("GenerateMap/windowBuy/pumkin.png"));
                    if (player.getPosX() >= 850 && player.getPosX() <= 1095 && player.getPosY() >= 420 && player.getPosY() <= 494) {
                        if (player.getmouseClicked()) {
                            boolean stateinbag = false;
                            windowBuy.getTexture().dispose();
                            windowBuy.setTexture(new Texture("GenerateMap/windowBuy/pumkin2.png"));
                            if (money - 5 >= 0) {
                                for (int i = 0; i < slotBag.size(); i++) {
                                    if (slotBag.get(i).getName().equals("GenerateMap/tree/10/bag.png")) {
                                        slotBag.get(i).setCoun(1);
                                        stateinbag = true;
                                        money -= 5;
                                    }
                                }
                                if (stateinbag == false) {
                                    for (int i = 0; i < slotBag.size(); i++) {
                                        if (slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                                            slotBag.get(i).setName("GenerateMap/tree/10/bag.png");
                                            slotBag.get(i).setCoun(1);
                                            money -= 5;
                                            break;
                                        }
                                    }
                                }
                            }

                            player.setMouseClicked(false);
                            player.setMouseNotNormal(0);
                        }
                    }
                    break;

                }
                case 2: {
                    windowBuy.setTexture(new Texture("GenerateMap/windowBuy/jastmine.png"));
                    if (player.getPosX() >= 850 && player.getPosX() <= 1095 && player.getPosY() >= 420 && player.getPosY() <= 494) {
                        if (player.getmouseClicked()) {
                            boolean stateinbag = false;
                            windowBuy.getTexture().dispose();
                            windowBuy.setTexture(new Texture("GenerateMap/windowBuy/jastmine1.png"));
                            if (money - 10 >= 0) {
                                for (int i = 0; i < slotBag.size(); i++) {
                                    if (slotBag.get(i).getName().equals("GenerateMap/tree/2/bag.png")) {
                                        slotBag.get(i).setCoun(1);
                                        stateinbag = true;
                                        money -= 10;
                                    }
                                }
                                if (stateinbag == false) {
                                    for (int i = 0; i < slotBag.size(); i++) {
                                        if (slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                                            slotBag.get(i).setName("GenerateMap/tree/2/bag.png");
                                            slotBag.get(i).setCoun(1);
                                            money -= 10;
                                            break;
                                        }
                                    }
                                }
                            }

                            player.setMouseClicked(false);
                            player.setMouseNotNormal(0);
                        }
                    }

                    break;
                }
                case 3: {
                    windowBuy.setTexture(new Texture(Gdx.files.internal("GenerateMap/windowBuy/melon.png")));
                    if (player.getPosX() >= 850 && player.getPosX() <= 1095 && player.getPosY() >= 420 && player.getPosY() <= 494) {
                        if (player.getmouseClicked()) {
                            boolean stateinbag = false;
                            windowBuy.getTexture().dispose();
                            windowBuy.setTexture(new Texture("GenerateMap/windowBuy/melon2.png"));
                            if (money - 20 >= 0) {
                                for (int i = 0; i < slotBag.size(); i++) {
                                    if (slotBag.get(i).getName().equals("GenerateMap/tree/11/bag.png")) {
                                        slotBag.get(i).setCoun(1);
                                        stateinbag = true;
                                        money -= 20;
                                    }
                                }
                                if (stateinbag == false) {
                                    for (int i = 0; i < slotBag.size(); i++) {
                                        if (slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                                            slotBag.get(i).setName("GenerateMap/tree/11/bag.png");
                                            slotBag.get(i).setCoun(1);
                                            money -= 20;
                                            break;
                                        }
                                    }
                                }
                            }

                            player.setMouseClicked(false);
                            player.setMouseNotNormal(0);
                        }
                    }
                    break;

                }
                case 4: {
                    windowBuy.setTexture(new Texture(Gdx.files.internal("GenerateMap/windowBuy/corn.png")));
                    if (player.getPosX() >= 850 && player.getPosX() <= 1095 && player.getPosY() >= 420 && player.getPosY() <= 494) {
                        if (player.getmouseClicked()) {
                            boolean stateinbag = false;
                            windowBuy.getTexture().dispose();
                            windowBuy.setTexture(new Texture("GenerateMap/windowBuy/corn2.png"));
                            if (money - 15 >= 0) {
                                for (int i = 0; i < slotBag.size(); i++) {
                                    if (slotBag.get(i).getName().equals("GenerateMap/tree/12/bag.png")) {
                                        slotBag.get(i).setCoun(1);
                                        stateinbag = true;
                                        money -= 15;
                                    }
                                }
                                if (stateinbag == false) {
                                    for (int i = 0; i < slotBag.size(); i++) {
                                        if (slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                                            slotBag.get(i).setName("GenerateMap/tree/12/bag.png");
                                            slotBag.get(i).setCoun(1);
                                            money -= 15;
                                            break;
                                        }
                                    }
                                }
                            }

                            player.setMouseClicked(false);
                            player.setMouseNotNormal(0);
                        }
                    }
                    break;

                }
                case 5: {
                    windowBuy.setTexture(new Texture(Gdx.files.internal("GenerateMap/windowBuy/cabage.png").toString()));
                    if (player.getPosX() >= 850 && player.getPosX() <= 1095 && player.getPosY() >= 420 && player.getPosY() <= 494) {
                        if (player.getmouseClicked()) {
                            boolean stateinbag = false;
                            windowBuy.getTexture().dispose();
                            windowBuy.setTexture(new Texture("GenerateMap/windowBuy/cabage2.png"));
                            if (money - 25 >= 0) {
                                for (int i = 0; i < slotBag.size(); i++) {
                                    if (slotBag.get(i).getName().equals("GenerateMap/tree/13/bag.png")) {
                                        slotBag.get(i).setCoun(1);
                                        stateinbag = true;
                                        money -= 25;
                                    }
                                }
                                if (stateinbag == false) {
                                    for (int i = 0; i < slotBag.size(); i++) {
                                        if (slotBag.get(i).getName().equals("GenerateMap/null2.png")) {
                                            slotBag.get(i).setName("GenerateMap/tree/13/bag.png");
                                            slotBag.get(i).setCoun(1);
                                            money -= 25;
                                            break;
                                        }
                                    }
                                }
                            }

                            player.setMouseClicked(false);
                            player.setMouseNotNormal(0);
                        }
                    }
                    break;

                }
            }
            windowBuy.draw(renderer.getBatch());
        }
        if (player.getmouseClicked()) {
            player.setMouseClicked(false);
            statusHowto++;
        }
        for (int i = 0; i <= 3; i++) {
            weedList[i].getTexture().dispose();
            weedList[i].setTexture(new Texture(slotBag.get(i).getName()));
        }
    }


    private void OpenScreen() {
        WhiteScreen.setAlpha(opacity);
        WhiteScreen.draw(renderer.getBatch());
        logo.setAlpha(opcacitylogo);
        switch (logostate) {
            case 0: {
                if (opacity < 0.99f)
                    opacity += 0.01f;
                else logostate++;
                break;
            }
            case 1: {
                if (opcacitylogo < 0.99f)
                    opcacitylogo += 0.01f;
                else logostate++;
                break;
            }
            case 2: {
                if (opcacitylogo > 0.01f)
                    opcacitylogo -= 0.01f;
                else {
                    opcacitylogo = 0;
                    logostate++;
                    logo.setTexture(new Texture(logoPng[1]));
                }
                logo.draw(renderer.getBatch());
                break;
            }
            case 3: {
                if (opcacitylogo < 0.99f)
                    opcacitylogo += 0.01f;
                else logostate++;
                break;
            }
            case 4: {
                if (opcacitylogo > 0.01f)
                    opcacitylogo -= 0.01f;
                else {
                    opcacitylogo = 0;
                    logostate++;
                    logo.setTexture(new Texture(logoPng[2]));
                }
                break;
            }
            case 5: {
                if (opcacitylogo < 0.99f)
                    opcacitylogo += 0.01f;
                else logostate++;
                break;
            }
            case 6: {
                if (opcacitylogo > 0.01f)
                    opcacitylogo -= 0.01f;
                else {
                    WhiteScreen.getTexture().dispose();
                    opcacitylogo = 0;
                    logostate++;
                }
                break;
            }
            case 7: {
                Openpic.draw(renderer.getBatch());
                if (player.getPosX() >= 261 && player.getPosX() <= 483 && player.getPosY() >= 449 && player.getPosY() <= 603) {
                    newGame.setTexture(new Texture("GenerateMap/OpenPic/new2.png"));
                    if (player.getmouseClicked()) {
                        logostate++;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }
                } else if (player.getPosX() >= 561 && player.getPosX() <= 782 && player.getPosY() >= 465 && player.getPosY() <= 603) {
                    loadGame.setTexture(new Texture("GenerateMap/OpenPic/load2.png"));
                    if (player.getmouseClicked()) {
                        try {
                            SaveGame.read();
                            day = SaveGame.getSaveObject().getDay();
                            money = SaveGame.getSaveObject().getMoney();
                            for (int i = 0; i < 3; i++) {
                                slotBag.get(i).setCoun(SaveGame.getSaveObject().slotBags.get(i).getCoun());
                                slotBag.get(i).setName(SaveGame.getSaveObject().slotBags.get(i).getName());
                            }
                            floorMap = SaveGame.getSaveObject().getFloormap();
                            floorMap2 = SaveGame.getSaveObject().getFloormap2();
                            floorMap3 = SaveGame.getSaveObject().getFloormap3();
                            floorMap4 = SaveGame.getSaveObject().getFloormap4();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        logostate++;
                        player.setMouseClicked(false);
                        player.setMouseNotNormal(0);
                    }


                } else if (player.getPosX() >= 848 && player.getPosX() <= 1076 && player.getPosY() >= 466 && player.getPosY() <= 603) {
                    exitGame.setTexture(new Texture("GenerateMap/OpenPic/exit2.png"));
                    if (player.getmouseClicked()) {
                        dispose();
                    }
                } else {
                    newGame.getTexture().dispose();
                    loadGame.getTexture().dispose();
                    exitGame.getTexture().dispose();
                    newGame.setTexture(new Texture("GenerateMap/OpenPic/new1.png"));
                    loadGame.setTexture(new Texture("GenerateMap/OpenPic/load1.png"));
                    exitGame.setTexture(new Texture("GenerateMap/OpenPic/exit1.png"));
                }
                player.setMouseNotNormal(0);
                player.setMouseClicked(false);
                newGame.draw(renderer.getBatch());
                loadGame.draw(renderer.getBatch());
                exitGame.draw(renderer.getBatch());

                break;
            }
            case 8: {
                Openpic.getTexture().dispose();
                logo.getTexture().dispose();
                newGame.getTexture().dispose();
                loadGame.getTexture().dispose();
                exitGame.getTexture().dispose();
                camera.position.set(642, 6820, 0);
                screenState++;
                changeSound.openSound.dispose();
                changeSound.changeSound(1);

                break;
            }
        }
        logo.draw(renderer.getBatch());
    }

    public void blinkWeed(FloorStatus[] floorMaps) {
        for (int i = 0; i < 30; i++) {
            if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/10/7.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/10/72.png");
                }
            } else if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/10/72.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/10/7.png");
                }
            } else if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/2/8.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/2/82.png");
                }
            } else if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/2/82.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/2/8.png");
                }
            } else if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/11/8.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/11/82.png");
                }
            } else if (floorMaps[i].getTree().getNameTree().equals("GenerateMap/tree/11/82.png")) {
                if (timing % 10 == 0) {
                    floorMaps[i].getTree().setNameTree("GenerateMap/tree/11/8.png");
                }
                }
            }
        }


    }
