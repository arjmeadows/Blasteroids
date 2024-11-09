package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship {

    float bulletposition;

    public void shipShoot(float speed, float delta, Sprite shipSprite, SpriteBatch spriteBatch, Texture bullet) {

            bullet = new Texture("circle-16.png");
            Sprite bulletSprite = new Sprite(bullet);

            float bulletx = shipSprite.getX() + 0.45f; //set bull starting pos
            float bullety = shipSprite.getY() + 1; // set bullet starting pos
            bulletSprite.setScale(0.010f);

            bulletSprite.setOrigin(bulletx, bullety);
        bulletSprite.draw(spriteBatch);

        do {
            bulletSprite.translateY(0.1f);
            bulletposition = bulletSprite.getY();
            System.out.print(bulletposition);
        } while (bulletposition < 5);
    }


    }
