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
	Entity entity;
	Sprite backgroundSprite;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		backgroundSprite = new Sprite(new Texture("background.jpg"));
		entity = new Entity();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		entity.render(spriteBatch);
		spriteBatch.end();
	}

}
