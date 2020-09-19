package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Entity {

    private static final float SPEED = 3f;
    private static final float SIZE = 70f;

    enum Direction { UP, DOWN, LEFT, RIGHT }

    Animation<TextureRegion> upAnimation;
    Animation<TextureRegion> downAnimation;
    Animation<TextureRegion> leftAnimation;
    Animation<TextureRegion> rightAnimation;
    float stateTime;
    Direction direction = Direction.UP;
    float x = Gdx.graphics.getWidth() / 2f - SIZE / 2f;
    float y = Gdx.graphics.getHeight() / 2f - SIZE / 2f;
    Sprite shadowSprite;


    public Entity() {
        Texture texture = new Texture("char1.png");
        TextureRegion[][] textureRegion = TextureRegion.split(texture, 32, 32); // 3 * 4 = 12
        upAnimation = new Animation<>(0.222f, textureRegion[3]);
        downAnimation = new Animation<>(0.222f, textureRegion[0]);
        leftAnimation = new Animation<>(0.222f, textureRegion[1]);
        rightAnimation = new Animation<>(0.222f, textureRegion[2]);
        upAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        downAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        leftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        rightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        shadowSprite = new Sprite(new Texture("shadow.png"));
    }

    public void render(SpriteBatch spriteBatch) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction = Direction.UP;
            y += SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            direction = Direction.DOWN;
            y -= SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            direction = Direction.LEFT;
            x -= SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            direction = Direction.RIGHT;
            x += SPEED;
        }

        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion textureRegion = null;
        switch (direction) {
            case UP: textureRegion = upAnimation.getKeyFrame(stateTime); break;
            case DOWN: textureRegion = downAnimation.getKeyFrame(stateTime); break;
            case LEFT: textureRegion = leftAnimation.getKeyFrame(stateTime); break;
            case RIGHT: textureRegion = rightAnimation.getKeyFrame(stateTime); break;
        }
        shadowSprite.setPosition(x + 12f, y - SIZE / 2f + 25f);
        shadowSprite.setAlpha(0.2f);
        shadowSprite.setSize(SIZE * 0.7f, SIZE * 0.3f);
        shadowSprite.draw(spriteBatch);
        spriteBatch.draw(textureRegion, x, y, SIZE, SIZE);
    }

}
