package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class StarfishCollector extends Game {

  private Turtle turtle;

  private Starfish starfish;
  private Rock rock;
  private BaseActor ocean;

  protected Stage mainStage;

  @Override
  public void create() {
    mainStage = new Stage();
    initialize();
  }

  public void render() {
    float dt = Gdx.graphics.getDeltaTime();

    mainStage.act();

    update(dt);

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    mainStage.draw();
  }

  public void initialize() {
    ocean = new BaseActor(0, 0, mainStage);
    ocean.loadTexture("water.jpg");
    ocean.setSize(800, 600);

    starfish = new Starfish(380, 380, mainStage);

    turtle = new Turtle(20, 20, mainStage);
    rock = new Rock(200, 200, mainStage);
  }

  public void update(float dt) {
    turtle.preventOverlap(rock);

    if(turtle.overlaps(starfish) && !starfish.isCollected()) {
      starfish.collect();

      Whirlpool whirlpool = new Whirlpool(0, 0, mainStage);
      whirlpool.centerAtActor(starfish);
      whirlpool.setOpacity(0.25f);

      BaseActor youWinMessage = new BaseActor(0,0, mainStage);
      youWinMessage.loadTexture("you-win.png");
      youWinMessage.centerAtPosition(400, 300);
      youWinMessage.setOpacity(0);
      youWinMessage.addAction(Actions.delay(1));
      youWinMessage.addAction(Actions.after(Actions.fadeIn(1)));
    }
  }
}
