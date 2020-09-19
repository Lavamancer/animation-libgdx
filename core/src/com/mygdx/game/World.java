package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedList;
import java.util.List;

public class World {

    Sprite backgroundSprite;
    private final List<Entity> entities = new LinkedList<>();


    public World() {
        backgroundSprite = new Sprite(new Texture("background.jpg"));
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (Entity entity : entities) {
            entity.draw(spriteBatch);
        }
    }

}
