package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship {

    public void shipShoot(float speed, float delta, Sprite shipSprite, SpriteBatch spriteBatch, Texture bullet) {

            bullet = new Texture("circle-16.png");
            Sprite bulletSprite = new Sprite(bullet);
            bulletSprite.setScale(0.010f);
        bulletSprite.setOrigin(1,1);
        bulletSprite.draw(spriteBatch);


    }
    }
