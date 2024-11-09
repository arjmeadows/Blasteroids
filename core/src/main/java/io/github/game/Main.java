package io.github.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectSet;
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
    Sprite asteroidSprite;
    BitmapFont font;
    Texture asteroid;

    SpriteBatch spriteBatch;
    FitViewport viewport;
    Asteroid asteroidAll = new Asteroid();
    Asteroid asteroidAll2 = new Asteroid();

    // set speed and delta variables
    float speed = 4f;
    float delta;



    @Override
    public void create() {
    backgroundTexture = new Texture("space_bg.png");
    font = new BitmapFont();


    ship = new Texture("ship1.png");
    shipSprite = new Sprite(ship);
    shipSprite.setSize(1,1);

    asteroid = new Texture("ast.png");
    asteroidSprite = new Sprite(asteroid);
    asteroidSprite.setSize(1,1);

    bgSound = Gdx.audio.newMusic(Gdx.files.internal("core_bg.mp3"));
    bgSound.setLooping(true);
    bgSound.setVolume(.5f);
    bgSound.play();

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
        input();
        logic();

        // draw asteroids
        asteroidAll.asteroidMove(0.25f, asteroidSprite);
        asteroidAll2.asteroidMove(0.1f, asteroidSprite);

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


        spriteBatch.draw(backgroundTexture, 0, 0, 8, 5);
        shipSprite.draw(spriteBatch);
        asteroidSprite.draw(spriteBatch);
      //  font.draw(spriteBatch, "Health", 2, 2);

        spriteBatch.end();

    }


    private void input() {

        delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            shipSprite.translateX(speed * delta);

        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            shipSprite.translateX(-speed * delta);

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            shipSprite.translateY(speed * delta);

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            shipSprite.translateY(-speed * delta);
        }
    }

    private void logic() {
        float worldWidth = viewport.getWorldWidth();
            float worldHeight = viewport.getWorldHeight();

            shipSprite.setX(MathUtils.clamp(shipSprite.getX(), 0, worldWidth));
        shipSprite.setY(MathUtils.clamp(shipSprite.getY(), 0, worldHeight));
        shipSprite.setY(MathUtils.clamp(shipSprite.getY(), 0, worldHeight));

        }


    }

