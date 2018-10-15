package com.mygdx.game.entitirs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Player extends Sprite implements InputProcessor{
    private TiledMap map;
    private int x, y;
    public Player player;

    private TiledMap world;
    TiledMapTileLayer collissionLayer;

    float oldX = getX(), oldY = getY();
    int state=0;
    String compass = "";
	public Player(Sprite sprite, TiledMapTileLayer collissionLayer) {
		super(sprite);
		this.collissionLayer = collissionLayer;
	}
    public Player(Sprite sprite){
        super(sprite);
        this.collissionLayer = getCollissionLayer();
    }
	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}



    public TiledMapTileLayer getCollissionLayer() {
        return collissionLayer;
    }

    public void setCollissionLayer(TiledMapTileLayer collissionLayer) {
	    this.collissionLayer = collissionLayer;
    }

    public void setOldX(float oldX) {
        this.oldX = oldX;
    }

    public void setOldY(float oldY) {
        this.oldY = oldY;
    }

    public float getOldX() {
        return oldX;
    }

    public float getOldY() {
        return oldY;
    }

    public void update(float delta) {
		float tilldWidth = collissionLayer.getTileWidth(), tiledHight = collissionLayer.getTileHeight();

		boolean collidedX;
        boolean collidedY,collidedXX;
        if (state>0){
            if (compass.equals("W"))
                setY(getY()+2);
            if (compass.equals("A"))
                setX(getX()-2);
            if (compass.equals("S"))
                setY(getY()-2);
            if (compass.equals("D"))
                setX(getX()+2);
        }
        setX(getX());

        //System.out.println(collissionLayer.getCell(-1,-1).getTile().getProperties().containsKey("m"));
		if (getX()>0&&getX()<2590) {


//            collidedX = collissionLayer.getProperties().containsKey("m");
 //           System.out.println(layer.getCell(1,1));
            //System.out.println(collidedX);
//            if (collidedX) {
//                //collidedXX = collissionLayer.getCell((int) (getX()/tilldWidth),(int) (getY()/tiledHight)).getTile().getProperties().containsKey("m");
//                //System.out.println(collidedXX + " " + getX()/27.275 + " " + getY()/27.275);
            //}
            //else System.out.println(getX()+" "+getY());
        }
        else{
            setX(oldX);
        }

		setY(getY());
//		if (getY()<0){
//		    // top
//                collidedY = collissionLayer.getCell((int) (getX()/tiledHight), (int) (getY())).getTile().getProperties().containsKey("Tile Layer 1");
//
//
//        }else if(getY()>0) {
//		    //top
//            collidedY = collissionLayer.getCell((int) (getX()/tilldWidth), (int) (((getY())+getHeight())/tiledHight)).getTile().getProperties().containsKey("Tile Layer 1");
//            // mid
//
//        }
//        if (collidedY){
//            setY(oldY);
//        }

	}

    @Override
    public boolean keyDown(int keycode) {
	    this.setOldX(getX());
	    this.setOldY(getY());
	    switch (keycode){
            case Input.Keys.W:
                state +=1;
                compass = "W";
                setY(getY()+8);
                break;
            case Input.Keys.A:
                state +=1;
                compass = "A";
                setX(getX()-8);
                break;
            case Input.Keys.D:
                state +=1;
                compass = "D";
                setX(getX()+8);
                break;
            case Input.Keys.S:
                state +=1;
                compass = "S";
                setY(getY()-8);
                break;
            case Input.Keys.ESCAPE:
                System.exit(0);
	        case Input.Keys.UP:
                state +=1;
                compass = "W";
                setY(getY()+8); break;
	        case Input.Keys.LEFT:
                state +=1;
                compass = "A";
                setX(getX()-8);
                break;
            case Input.Keys.RIGHT:
                state +=1;
                compass = "D";
                setX(getX()+8);
                break;
	        case Input.Keys.DOWN:
                state +=1;
                compass = "S";
                setY(getY()-8);
                break;
	    }
	    return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.W:
                state -=1;
            case Input.Keys.D:
                state -=1;
            case Input.Keys.A:
                state -=1;
            case Input.Keys.S:
                state -=1;
            case Input.Keys.UP:
                state -=1;
            case Input.Keys.DOWN:
                state -=1;
            case Input.Keys.LEFT:
                state -=1;
            case Input.Keys.RIGHT:
                state -=1;



        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
