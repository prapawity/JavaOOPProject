package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.Player;
import com.mygdx.game.entitirs.ShowImage;

public class ShowingBuyWindow {
        ShowImage overlay,buyWindow,backButton;

    public void create(){
        overlay = new ShowImage(new Sprite(new Texture("overlay.png")));
        backButton = new ShowImage(new Sprite(new Texture("OpenPic/backNon.png")));
        overlay.scale(100);
        buyWindow = new ShowImage(new Sprite(new Texture("testbuywindow.png")));
        buyWindow.scale(1.4f);
        backButton.scale(1.5f);
     }

    public boolean showBuyWindow(int store, OrthogonalTiledMapRenderer renderer, Camera camera, Player player){
        if(player.getPosX()>= 45 &&player.getPosX()<=220&&player.getPosY()>= 634&&player.getPosY()<=670){
            backButton.getTexture().dispose();
            backButton.setTexture(new Texture("OpenPic/backClick.png"));
            if(player.getmouseClicked()){
                player.setMouseClicked(false);
                return false;
            }
        }
        else {
            backButton.getTexture().dispose();
            backButton.setTexture(new Texture("OpenPic/backNon.png"));
        }
        overlay.setTexture(new Texture("overlay.png"));
        overlay.setPosition(camera.position.x,camera.position.y);
        backButton.setPosition(camera.position.x-550,camera.position.y-320);
        overlay.draw(renderer.getBatch());
        buyWindow.setPosition(camera.position.x-250,camera.position.y-90);
        buyWindow.draw(renderer.getBatch());
        backButton.draw(renderer.getBatch());
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
        return true;

    }

    public void dispose(){
        overlay.getTexture().dispose();
        buyWindow.getTexture().dispose();
    }
}
