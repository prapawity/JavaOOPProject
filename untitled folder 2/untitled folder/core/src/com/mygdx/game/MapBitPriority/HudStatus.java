package com.mygdx.game.MapBitPriority;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class HudStatus {
    private SpriteBatch batch;
    private Texture counterPath;
    private Stage _stage;
    private Table table = new Table();
    private Sprite mySprite;

    public HudStatus() {
        this.table.setFillParent(true);
        this.batch = new SpriteBatch();
        this._stage = new Stage();
        this.mySprite = new Sprite(new Texture("HUD.png"));
        Image image = new Image(new SpriteDrawable(this.mySprite));
        this.table.add(image).width((float)(Gdx.graphics.getWidth()/2.5)).height((float)(Gdx.graphics.getHeight()/12)).bottom().center().row();
        this.table.align(1).bottom();
        this._stage.addActor(this.table);
    }

    public void setHudToDefault() {
    }

    public void draw() {
        this._stage.act(Gdx.graphics.getDeltaTime());
        this._stage.draw();
    }

    public void show() {
        Gdx.input.setInputProcessor(this._stage);
    }
}
