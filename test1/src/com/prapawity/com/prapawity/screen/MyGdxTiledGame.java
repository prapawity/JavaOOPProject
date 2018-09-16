package com.prapawity.com.prapawity.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.prapawity.com.prapawity.model.TileMap;

public class MyGdxTiledGame extends ApplicationAdapter {
    private TileMap map;
    private AssetManager manager;
    @Override
    public void create(){
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("res/map/untitled.tmx", TileMap.class);
        manager.finishLoading();
        map = manager.get("res/map/untitled.tmx", TileMap.class);
    }
    @Override
    public void render(){}
    @Override
    public void dispose(){
        manager.dispose();
    }
}
