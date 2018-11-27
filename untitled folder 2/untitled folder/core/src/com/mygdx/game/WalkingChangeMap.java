package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class WalkingChangeMap {
    public void mapChanging(ShowImage walkingAnimation, OrthogonalTiledMapRenderer renderer){
        walkingAnimation.setPosition(193,6780);
        walkingAnimation.draw(renderer.getBatch());

    }
}
