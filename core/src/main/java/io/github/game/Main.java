package io.github.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.Sprite;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {

    Texture backgroundTexture;
    Texture ship;
    Music bgSound;
    Sprite shipSprite;

    SpriteBatch spriteBatch;
    FitViewport viewport;


    @Override
    public void create() {
    backgroundTexture = new Texture("space_bg.png");

    ship = new Texture("ship1.png");
    shipSprite = new Sprite(ship);
    shipSprite.setSize(1,1);


    bgSound = Gdx.audio.newMusic(Gdx.files.internal("core_bg.mp3"));

    spriteBatch  = new SpriteBatch();
    viewport = new FitViewport(8, 5);



    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }

    @Override
    public void render() {

        draw();

    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();


        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        spriteBatch.draw(backgroundTexture, 0, 0, 8, 5);
        shipSprite.draw(spriteBatch);

        spriteBatch.end();
    }


    private void input() {
        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            shipSprite.translateX(speed * delta);

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                shipSprite.translateX(speed * delta);
        }
    }



}
