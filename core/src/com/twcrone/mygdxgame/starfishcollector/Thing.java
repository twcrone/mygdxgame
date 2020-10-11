package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Thing {
    private float x;
    private float y;
    private Rectangle rectangle;
    private Texture texture;

    public Thing(float x, float y, String assetPath) {
        this.x = x;
        this.y = y;
        this.texture = new Texture(Gdx.files.internal(assetPath));
        this.rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public void moveLeft() {
        this.x--;
        moveRectangle();
    }

    public void moveRight() {
        this.x++;
        moveRectangle();
    }
    public void moveUp() {
        this.y++;
        moveRectangle();
    }
    public void moveDown() {
        this.y--;
        moveRectangle();
    }

    public boolean checkCollision(Rectangle rectangle) {
        return this.rectangle.overlaps(rectangle);
    }

    private void moveRectangle() {
        this.rectangle.setPosition(this.x, this.y);
    }
}
