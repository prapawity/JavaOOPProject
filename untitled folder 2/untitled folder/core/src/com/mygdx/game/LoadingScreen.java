package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class LoadingScreen {
    private ShowImage overlay,player,dot,dot2,dot3,dot4;
    int screen =0,i = 0,state = 0;
    float opacity =1;
    public void create(){
        overlay = new ShowImage(new Sprite(new Texture("blackScreen.png")));
        player = new ShowImage(new Sprite(new Texture("sprite/stayRight1.png")));
        dot = new ShowImage(new Sprite(new Texture("loading.png")));
        dot2 = new ShowImage(new Sprite(new Texture("loading.png")));
        dot3 = new ShowImage(new Sprite(new Texture("loading.png")));
        dot4 = new ShowImage(new Sprite(new Texture("loading.png")));
        dot.scale(0.01f);
        dot2.scale(0.01f);
        dot3.scale(0.01f);
        dot4.scale(0.01f);
        player.scale(5);
        overlay.scale(10);

    }
    public int render(OrthogonalTiledMapRenderer renderer, Camera camera){
        screen = 0;
        overlay.getTexture().dispose();
        overlay.setTexture(new Texture("blackScreen.png"));
        overlay.setAlpha(opacity);
        if(i<=150){
            if(i%20==0)switch (state){
                case 0:{
                    player.getTexture().dispose();
                    player.setTexture(new Texture("sprite/stayRight1.png"));
                    dot.getTexture().dispose();
                    dot.setTexture(new Texture("loading.png"));
                    dot.setPosition(camera.position.x+440,camera.position.y-330);
                    dot2.setPosition(camera.position.x+440,camera.position.y-330);
                    dot3.setPosition(camera.position.x+440,camera.position.y-330);
                    dot4.setPosition(camera.position.x+440,camera.position.y-330);
                    state++;
                    break;
                }
                case 1:{
                    player.setTexture(new Texture("sprite/walkRight1.png"));
                    dot2.getTexture().dispose();
                    dot2.setTexture(new Texture("loading.png"));
                    dot2.setPosition(camera.position.x+490,camera.position.y-330);
                    state++;
                    break;
                }
                case 2: {
                    player.setTexture(new Texture("sprite/stayRight2.png"));
                    dot3.getTexture().dispose();
                    dot3.setTexture(new Texture("loading.png"));
                    dot3.setPosition(camera.position.x+540,camera.position.y-330);
                    state++;
                    break;
                }
                case 3:{
                    player.setTexture(new Texture("sprite/walkRight2.png"));
                    dot4.getTexture().dispose();
                    dot4.setTexture(new Texture("loading.png"));
                    dot4.setPosition(camera.position.x+590,camera.position.y-330);
                    state=0;
                    break;
                }
            }
            i++;
            overlay.setPosition(camera.position.x,camera.position.y);
            overlay.draw(renderer.getBatch());
            player.setPosition(camera.position.x+390,camera.position.y-250);
            player.draw(renderer.getBatch());
            dot.draw(renderer.getBatch());
            dot2.draw(renderer.getBatch());
            dot3.draw(renderer.getBatch());
            dot4.draw(renderer.getBatch());
        }
        else {
            if(opacity>0.01f){
                overlay.setAlpha(opacity);
                overlay.draw(renderer.getBatch());
                opacity-=0.02f;

            }else {
                dot.setPosition(camera.position.x+440,camera.position.y-330);
                dot2.setPosition(camera.position.x+440,camera.position.y-330);
                dot3.setPosition(camera.position.x+440,camera.position.y-330);
                dot4.setPosition(camera.position.x+440,camera.position.y-330);
                i = 0;
                dispose();
                state = 0;
                opacity=1;
                screen++;
            }
        }
        return screen;

    }
    public void dispose(){
        overlay.getTexture().dispose();
        player.getTexture().dispose();
        dot.getTexture().dispose();
        dot2.getTexture().dispose();
        dot3.getTexture().dispose();
        dot4.getTexture().dispose();
    }
}
