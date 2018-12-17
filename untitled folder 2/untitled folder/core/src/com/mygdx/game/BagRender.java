package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class BagRender {
    public void render(ShowImage[] weedList, OrthogonalTiledMapRenderer renderer, Camera camera){
        weedList[0].setPosition(camera.position.x+25,camera.position.y-327);
        weedList[1].setPosition(camera.position.x+90,camera.position.y-327);
        weedList[2].setPosition(camera.position.x+150,camera.position.y-327);
        weedList[3].setPosition(camera.position.x+215,camera.position.y-327);
        weedList[4].setPosition(camera.position.x+280,camera.position.y-332);
        weedList[0].draw(renderer.getBatch());
        weedList[1].draw(renderer.getBatch());
        weedList[2].draw(renderer.getBatch());
        weedList[3].draw(renderer.getBatch());
        weedList[4].draw(renderer.getBatch());

    }
}
