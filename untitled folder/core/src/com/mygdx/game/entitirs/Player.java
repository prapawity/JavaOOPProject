package com.mygdx.game.entitirs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
	private Vector2 velocity = new Vector2();
	private float speed = 60*2;
	public Player(Sprite sprite) {
		super(sprite);
		
	}
	@Override
	public void draw(Batch batch) {
		// TODO Auto-generated method stub
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	public void update(float delta) {
		velocity.y -= delta;
		if (velocity.y > speed)
			velocity.y = speed;
		else if (velocity.y < -speed)
			velocity.y = -speed;
		setX(getX() + velocity.x * delta);
		setY(getY() + velocity.y * delta);
	}

}
