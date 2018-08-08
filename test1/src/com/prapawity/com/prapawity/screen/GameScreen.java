package com.prapawity.com.prapawity.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.prapawity.Setting;
import com.prapawity.com.prapawity.controller.PlayerController;
import com.prapawity.com.prapawity.model.Player;
import com.prapawity.testGame;
public class GameScreen extends AbstractScreen{

    private PlayerController controller;

    private Player player;

    private SpriteBatch batch;

    private Texture redStandingSouth;

    public GameScreen(testGame app) {
        super(app);
        redStandingSouth = new Texture("res/model2.png");
        batch = new SpriteBatch();
        player = new Player(0, 0);
        controller = new PlayerController(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(redStandingSouth,
                player.getX()* Setting.SCALED_TITLE_SIZE,
                player.getY()*Setting.SCALED_TITLE_SIZE,
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
