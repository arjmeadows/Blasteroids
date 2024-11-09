package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Asteroid {

    int astid;

    public void asteroidMove(float speed, Sprite asteroidSprite) {
        float delta = Gdx.graphics.getDeltaTime();

        asteroidSprite.translateX(speed * delta);

    }


    public void asteroidBatch() {

        for (astid = 0; astid <= 6; astid++) {
            Asteroid asteroid = new Asteroid();

        }

    }



}



// logic should be a method that creates as man objects as needed based on a loop
