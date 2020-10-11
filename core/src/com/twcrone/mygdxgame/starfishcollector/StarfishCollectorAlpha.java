package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarfishCollectorAlpha extends Game {

    private SpriteBatch batch;

    private Thing turtle;
    private Thing starfish;

    private Texture oceanTexture;
    private Texture winMessageTexture;

    private boolean win;

    @Override
    public void create() {
        batch = new SpriteBatch();

        turtle = new Thing(20, 20, "turtle-1.png");
        starfish = new Thing(380, 380, "starfish.png");

        oceanTexture = new Texture(Gdx.files.internal("water.jpg"));
        winMessageTexture = new Texture(Gdx.files.internal("you-win.png"));

        win = false;
    }

    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            turtle.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            turtle.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            turtle.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            turtle.moveDown();
        }

        if(turtle.collidesWith(starfish)) {
            win = true;
        }

        Gdx.gl.glClearColor(0, 0 ,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(oceanTexture, 0, 0);

        if(!win) {
            batch.draw(starfish.getTexture(), starfish.getX(), starfish.getY());
        }
        batch.draw(turtle.getTexture(), turtle.getX(), turtle.getY());
        if(win) {
            batch.draw(winMessageTexture, 180, 180);
        }
        batch.end();
    }
}
