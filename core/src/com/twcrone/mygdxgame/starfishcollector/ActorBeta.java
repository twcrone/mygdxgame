package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Rectangle;

public class ActorBeta extends Actor {
    private TextureRegion textureRegion;
    private Rectangle rectangle;

    public ActorBeta() {
        textureRegion = new TextureRegion();
        rectangle = new Rectangle();
    }

    public void setTexture(Texture texture) {
        textureRegion.setRegion(texture);
        setSize(texture.getWidth(), texture.getHeight());
        rectangle.setSize(texture.getWidth(), texture.getHeight());
    }

    public Rectangle getRectangle() {
        rectangle.setPosition(getX(), getY());
        return rectangle;
    }

    public boolean overlaps(ActorBeta other) {
        return this.getRectangle().overlaps(other.getRectangle());
    }

    public void act(float dt) {
        super.act(dt);
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        Color color = getColor();

        batch.setColor(color.r, color.g, color.b, color.a);

        if(isVisible()) {
            batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }
}
