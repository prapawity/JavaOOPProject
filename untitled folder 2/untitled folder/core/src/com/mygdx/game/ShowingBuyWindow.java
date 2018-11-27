package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class ShowingBuyWindow {
        ShowImage overlay,buyWindow;

    public void create(){
        overlay = new ShowImage(new Sprite(new Texture("overlay.png")));
        overlay.scale(100);
        buyWindow = new ShowImage(new Sprite(new Texture("testbuywindow.png")));
        buyWindow.scale(1.4f);
     }

    public void showBuyWindow(int store, OrthogonalTiledMapRenderer renderer, Camera camera){
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

    public void dispose(){
        overlay.getTexture().dispose();
        buyWindow.getTexture().dispose();
    }
}
