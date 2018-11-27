package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class ShowingHudMoney {
    ShowImage pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,hudMoney;

    public void create(){
        pos1 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos2 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos3 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos4 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos5 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos6 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos7 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        pos8 = new ShowImage(new Sprite(new Texture("number/num0.png")));
        hudMoney = new ShowImage(new Sprite(new Texture("number/hudMoneyShowing.png")));

        pos1.scale(0.4f);
        pos2.scale(0.4f);
        pos3.scale(0.4f);
        pos4.scale(0.4f);
        pos5.scale(0.4f);
        pos6.scale(0.4f);
        pos7.scale(0.4f);
        pos8.scale(0.4f);
        hudMoney.scale(2);

    }
    public void showHudMoney(OrthogonalTiledMapRenderer renderer, Camera camera){
        hudMoney.setPosition(camera.position.x-555,camera.position.y+265);
        pos1.setPosition(camera.position.x-600,camera.position.y+236);
        pos2.setPosition(camera.position.x-577,camera.position.y+236);
        pos3.setPosition(camera.position.x-555,camera.position.y+236);
        pos4.setPosition(camera.position.x-534,camera.position.y+236);
        pos5.setPosition(camera.position.x-512,camera.position.y+236);
        pos6.setPosition(camera.position.x-490,camera.position.y+236);
        pos7.setPosition(camera.position.x-465,camera.position.y+236);
        pos8.setPosition(camera.position.x-443,camera.position.y+236);
        hudMoney.draw(renderer.getBatch());
        pos1.draw(renderer.getBatch());
        pos2.draw(renderer.getBatch());
        pos3.draw(renderer.getBatch());
        pos4.draw(renderer.getBatch());
        pos5.draw(renderer.getBatch());
        pos6.draw(renderer.getBatch());
        pos7.draw(renderer.getBatch());
        pos8.draw(renderer.getBatch());
    }

    public void dispose(){
        pos1.getTexture().dispose();
        pos2.getTexture().dispose();
        pos3.getTexture().dispose();
        pos4.getTexture().dispose();
        pos5.getTexture().dispose();
        pos6.getTexture().dispose();
        pos7.getTexture().dispose();
        pos8.getTexture().dispose();
        hudMoney.getTexture().dispose();
    }
}
