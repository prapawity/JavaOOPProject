package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class SavingNextDay {
    private ShowImage player,saving,dot,dot2,dot3,dot4;
    int screen =0,i = 0,state = 0;
    float opacity =1;
    public void create(){
        player = new ShowImage(new Sprite(new Texture("nightWall.png")));
        saving = new ShowImage(new Sprite(new Texture("saving.png")));

        dot = new ShowImage(new Sprite(new Texture("whiteDot.png")));
        dot2 = new ShowImage(new Sprite(new Texture("whiteDot.png")));
        dot3 = new ShowImage(new Sprite(new Texture("whiteDot.png")));
        dot4 = new ShowImage(new Sprite(new Texture("whiteDot.png")));

    }
    public int render(OrthogonalTiledMapRenderer renderer, Camera camera, int screenstate){
        player.getTexture().dispose();
        player.setTexture(new Texture("nightWall.png"));
        player.setAlpha(opacity);
        saving.getTexture().dispose();
        saving.setTexture(new Texture("saving.png"));
        saving.setPosition(camera.position.x-250,camera.position.y);
        player.setPosition(camera.position.x-730,camera.position.y-380);
        saving.setAlpha(opacity);
        dot.getTexture().dispose();
        dot.setTexture(new Texture("whiteDot.png"));
        dot2.getTexture().dispose();
        dot2.setTexture(new Texture("whiteDot.png"));
        dot3.getTexture().dispose();
        dot3.setTexture(new Texture("whiteDot.png"));
        dot4.getTexture().dispose();
        dot4.setTexture(new Texture("whiteDot.png"));
        if(i<=200){
            if(i%20==0) {
                switch (state) {
                    case 0: {
                        dot.setPosition(camera.position.x+150, camera.position.y + 65);
                        dot2.setPosition(camera.position.x+150, camera.position.y+65);
                        dot3.setPosition(camera.position.x+150, camera.position.y+65);
                        dot4.setPosition(camera.position.x+150, camera.position.y+65);
                        state++;
                        break;
                    }
                    case 1: {
                        dot2.setPosition(camera.position.x+200, camera.position.y+65);
                        state++;
                        break;
                    }
                    case 2: {
                        dot3.setPosition(camera.position.x+250, camera.position.y+65);
                        state++;
                        break;
                    }
                    case 3: {
                        dot4.setPosition(camera.position.x+300, camera.position.y+65);
                        state = 0;
                        break;
                    }
                }
            }
            i++;
            player.draw(renderer.getBatch());
            saving.draw(renderer.getBatch());
            dot.draw(renderer.getBatch());
            dot2.draw(renderer.getBatch());
            dot3.draw(renderer.getBatch());
            dot4.draw(renderer.getBatch());
        }
        else {
            if(opacity>0.01f){
                player.setAlpha(opacity);
                player.draw(renderer.getBatch());
                opacity-=0.02f;

            }else {
                dot.setPosition(camera.position.x+150, camera.position.y + 65);
                dot2.setPosition(camera.position.x+150, camera.position.y+65);
                dot3.setPosition(camera.position.x+150, camera.position.y+65);
                dot4.setPosition(camera.position.x+150, camera.position.y+65);
                i = 0;
                dispose();
                opacity=1;
                return 0;
            }
        }
        return screenstate;

    }
    public void dispose(){
        saving.getTexture().dispose();
        player.getTexture().dispose();
        dot.getTexture().dispose();
        dot2.getTexture().dispose();
        dot3.getTexture().dispose();
        dot4.getTexture().dispose();
    }
}
