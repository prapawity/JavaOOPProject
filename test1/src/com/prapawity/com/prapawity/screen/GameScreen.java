package com.prapawity.com.prapawity.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.prapawity.Setting;
import com.prapawity.com.prapawity.controller.PlayerController;
import com.prapawity.com.prapawity.model.Actor;
import com.prapawity.com.prapawity.model.Camera;
import com.prapawity.com.prapawity.model.TERRAIN;
import com.prapawity.com.prapawity.model.TileMap;
import com.prapawity.testGame;
public class GameScreen extends AbstractScreen{

    private PlayerController controller;
    private Camera camera = new Camera();
    private Actor player;
    private TileMap map;
    private SpriteBatch batch;
    private Texture redStandingSouth;
    private Texture grass1 ;
    private Texture grass2;

    public GameScreen(testGame app) {
        super(app);
        redStandingSouth = new Texture("res/model2.png");
        grass1 = new Texture("res/ground_green2.png");
        grass2 = new Texture("res/ground_green2.png");
        batch = new SpriteBatch();
        map = new TileMap(30,30);
        player = new Actor(map,15, 15);
        controller = new PlayerController(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
        batch.begin();
        float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Setting.SCALED_TITLE_SIZE;
        float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Setting.SCALED_TITLE_SIZE;
        for (int x = 0; x < map.getWidth(); x++){
            for (int y = 0; y < map.getHeight(); y++){
                Texture render;
                if (map.getTile(x, y).getTerrain() == TERRAIN.GRASS_1){
                    render = grass1;
                } else {
                    render = grass2;
                }
                batch.draw(render,
                        worldStartX+x*Setting.SCALED_TITLE_SIZE,
                        worldStartY+y*Setting.SCALED_TITLE_SIZE,
                        Setting.SCALED_TITLE_SIZE,
                        Setting.SCALED_TITLE_SIZE);
            }

        }
        batch.draw(redStandingSouth,
                worldStartX+player.getWorldX()* Setting.SCALED_TITLE_SIZE,
                worldStartY+player.getWorldY()*Setting.SCALED_TITLE_SIZE,
                Setting.SCALED_TITLE_SIZE,
                Setting.SCALED_TITLE_SIZE*1.5f);
        batch.end();

    }

    @Override
    public void resize(int width, int hight) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
