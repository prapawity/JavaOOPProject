package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class HowTo {
    ShowImage img,overlay;

    public void create(){
        overlay = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/overlay.png"))));
        img  = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/howto.png"))));
        overlay.scale(100);
        img.scale(0.3f);
    }
    public void render(OrthogonalTiledMapRenderer renderer, Camera camera,int state){
        if(state==1){
            img.getTexture().dispose();
            img.setTexture(new Texture(Gdx.files.internal("GenerateMap/howto2.png")));
        }else if(state ==2){
            img.getTexture().dispose();
            img.setTexture(new Texture(Gdx.files.internal("GenerateMap/howto3.png")));
        }
        else if(state ==3){
            img.getTexture().dispose();
            img.setTexture(new Texture(Gdx.files.internal("GenerateMap/howto4.png")));
        }
        img.setPosition(camera.position.x-610,camera.position.y-390);
        overlay.draw(renderer.getBatch());
        img.draw(renderer.getBatch());

    }
    public void dispose(){
        img.getTexture().dispose();
        overlay.getTexture().dispose();
    }
}
