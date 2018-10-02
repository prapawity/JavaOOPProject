package com.mygdx.game.entitirs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
	private Vector2 velocity = new Vector2();
	private float speed = 60*1, gravity = 60*1.8f;
	private TiledMapTileLayer collissionLayer;
	public Player(Sprite sprite, TiledMapTileLayer collissionLayer) {
		super(sprite);
		this.collissionLayer = collissionLayer;
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

    public void update(float delta) {
		velocity.y -= gravity*delta ;
		if (velocity.y > speed)
			velocity.y = speed;
		else if (velocity.y < -speed)
			velocity.y = -speed;



//		float oldX = getX(), oldY = getY(), tilldWidth = collissionLayer.getWidth(), tiledHight = collissionLayer.getHeight();
//		boolean collidedX = false, collidedY = false;
		setX(getX() + velocity.x * delta);



//		if (velocity.x < 0){
//            // top
//            collidedX = collissionLayer.getCell((int) (getX()/tilldWidth), (int) ((getY()+getHeight())/tiledHight)).getTile().getProperties().containsKey("top");
//            // mid
//            if (!collidedX) {
//                collidedX = collissionLayer.getCell((int) (getX() / tilldWidth), (int) (((getY() + getHeight()) / 2) / tiledHight)).getTile().getProperties().containsKey("top");}
//                //bot
//            if (!collidedX){
//                collidedX = collissionLayer.getCell((int) (getX() / tilldWidth), (int) (getY() / tiledHight)).getTile().getProperties().containsKey("top");
//            }
//        }else if (velocity.x > 0){
//
//		    collidedX = collissionLayer.getCell((int) ((getX()+getWidth())/tilldWidth), (int) ((getY()+getHeight())/tiledHight)).getTile().getProperties().containsKey("top");
//            if (!collidedX) {
//                collidedX = collissionLayer.getCell((int) ((getX()+getWidth())/tilldWidth), (int) (((getY() + getWidth()) / 2) / tiledHight)).getTile().getProperties().containsKey("top");}
//            //bot
//            if (!collidedX){
//                collidedX = collissionLayer.getCell((int) ((getX()+getWidth())/tilldWidth), (int) (getY()/ tiledHight)).getTile().getProperties().containsKey("top");
//            }
//        }
//
//
//        if (collidedX){
//            setX(oldX);
//            velocity.x = 0;
//        }

		setY(getY() + velocity.y * delta);
//		if (velocity.y < 0){
//		    // top
//            collidedY = collissionLayer.getCell((int) (getX()/tilldWidth), (int) (getY()/tiledHight)).getTile().getProperties().containsKey("top");
//            // mid
//            if (!collidedY) {
//                collidedY = collissionLayer.getCell((int) ((getX() / getWidth())/2/tilldWidth), (int) (((getY()/getHeight())) / tiledHight)).getTile().getProperties().containsKey("top");}
//            //bot
//            if (!collidedY){
//                collidedY = collissionLayer.getCell((int) ((getX() / getWidth())/tiledHight), (int) (getY() / tiledHight)).getTile().getProperties().containsKey("top");
//            }
//
//        }else if(velocity.y > 0){
//		    //top
//            collidedY = collissionLayer.getCell((int) (getX()/tilldWidth), (int) (((getY())+getHeight())/tiledHight)).getTile().getProperties().containsKey("top");
//            // mid
//            if (!collidedY) {
//                collidedY = collissionLayer.getCell((int) ((getX() / getWidth())/2/tilldWidth), (int) (((getY()+getHeight()))/2 / tiledHight)).getTile().getProperties().containsKey("top");}
//            //bot
//            if (!collidedY){
//                collidedY = collissionLayer.getCell((int) ((getX() / getWidth())/tiledHight), (int) ((getY() + tiledHight)/tiledHight)).getTile().getProperties().containsKey("top");
//            }
//        }
//        if (collidedY){
//            setY(oldY);
//            velocity.y = 0;
//        }
	}









    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
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
