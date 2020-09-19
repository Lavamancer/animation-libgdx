package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Main extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	World world;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		world = new World();
		world.addEntity(new Entity());
//		world.addEntity(new Entity(100f));
//		world.addEntity(new Entity(-100f));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.update(Gdx.graphics.getDeltaTime());

		spriteBatch.begin();
		world.draw(spriteBatch);
		spriteBatch.end();
	}

}
