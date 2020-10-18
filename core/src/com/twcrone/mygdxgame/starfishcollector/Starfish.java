package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Starfish extends BaseActor {

  private boolean collected = false;

  public Starfish(float x, float y, Stage stage) {
    super(x, y, stage);

    loadTexture("starfish.png");
    setBoundaryPolygon(8);
    Action spin = Actions.rotateBy(30, 1);
    this.addAction(Actions.forever(spin));
  }

  public boolean isCollected() {
    return collected;
  }

  public void collect() {
    collected = true;
    clearActions();
    addAction(Actions.fadeOut(1));
    addAction(Actions.after(Actions.removeActor()));
  }
}
