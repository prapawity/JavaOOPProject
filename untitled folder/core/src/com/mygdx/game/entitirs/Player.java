package com.mygdx.game.entitirs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
	private Vector2 velocity = new Vector2();
	private float speed = 60, gravity = 1;
	private TiledMapTileLayer collissionLayer;
    float oldX = getX(), oldY = getY();
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

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
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
		float tilldWidth = collissionLayer.getWidth(), tiledHight = collissionLayer.getHeight();
		boolean collidedX = false, collidedY = false;
		setX(getX());


        System.out.println(collidedX+"  "+collidedY);
		if (velocity.x < 0){
            // top
            collidedX = collissionLayer.getCell((int) getX(), (int) getY()).getTile().getProperties().containsKey("Tile Layer 1");
            // mid

        }else if (velocity.x > 0){

		    collidedX = collissionLayer.getCell((int) ((getX()+getWidth())/tilldWidth), (int) ((getY()+getHeight())/tiledHight)).getTile().getProperties().containsKey("Tile Layer 1");

        }


        if (collidedX){
            setX(oldX);
        }

		setY(getY());
		if (velocity.y < 0){
		    // top
                collidedY = collissionLayer.getCell((int) (getX()/tiledHight), (int) (getY())).getTile().getProperties().containsKey("Tile Layer 1");


        }else if(velocity.y > 0) {
		    //top
            collidedY = collissionLayer.getCell((int) (getX()/tilldWidth), (int) (((getY())+getHeight())/tiledHight)).getTile().getProperties().containsKey("Tile Layer 1");
            // mid

        }
        if (collidedY){
            setY(oldY);
        }

	}









    @Override
    public boolean keyDown(int keycode) {
	    this.setOldX(getX());
	    this.setOldY(getY());

	    switch (keycode){
            case Input.Keys.W:
                setY(getY()+25);
                break;
            case Input.Keys.A:
                setX(getX()-25);
                break;
            case Input.Keys.D:
                setX(getX()+25);
                break;
            case Input.Keys.S:
                setY(getY()-25);
                break;
            case Input.Keys.ESCAPE:
                System.exit(0);
	        case Input.Keys.UP:
                setY(getY()+25); break;
	        case Input.Keys.LEFT:
                setX(getX()-25);
                break;
            case Input.Keys.RIGHT:
                setX(getX()+25);
                break;
	        case Input.Keys.DOWN:
                setY(getY()-25);
                break;
	    }
	    return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.D:
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
