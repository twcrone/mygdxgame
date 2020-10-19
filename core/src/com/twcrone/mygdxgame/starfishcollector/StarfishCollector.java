package com.twcrone.mygdxgame.starfishcollector;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.List;

public class StarfishCollector extends Game {

  protected Stage mainStage;

  private Turtle turtle;

  private final List<Rock> rocks = new ArrayList<>();
  private final List<Starfish> starfish = new ArrayList<>();

  private BaseActor ocean;

  private boolean win = false;

  @Override
  public void create() {
    mainStage = new Stage();
    initialize();
  }

  public void initialize() {
    ocean = new BaseActor(0, 0, mainStage);
    ocean.loadTexture("water.jpg");
    ocean.setSize(800, 600);

    turtle = new Turtle(20, 20, mainStage);

    addStarfish(400, 400);
    addStarfish(500, 100);
    addStarfish(100, 450);
    addStarfish(200, 250);

    addRock(200, 150);
    addRock(100, 300);
    addRock(300, 350);
    addRock(450, 200);
  }

  private void addRock(float x, float y) {
    rocks.add(new Rock(x, y, mainStage));
  }

  private void addStarfish(float x, float y) {
    starfish.add(new Starfish(x, y, mainStage));
  }

  public void render() {
    float dt = Gdx.graphics.getDeltaTime();

    mainStage.act();

    update(dt);

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    mainStage.draw();
  }

  public void update(float dt) {
    for(Rock rock : rocks) {
      turtle.preventOverlap(rock);
    }

    for(Starfish s : starfish) {
      if(turtle.overlaps(s) && !s.isCollected()) {
        collect(s);
      }


//      BaseActor youWinMessage = new BaseActor(0,0, mainStage);
//      youWinMessage.loadTexture("you-win.png");
//      youWinMessage.centerAtPosition(400, 300);
//      youWinMessage.setOpacity(0);
//      youWinMessage.addAction(Actions.delay(1));
//      youWinMessage.addAction(Actions.after(Actions.fadeIn(1)));
    }
  }

  private void collect(Starfish s) {
    s.collect();
    Whirlpool whirlpool = new Whirlpool(0, 0, mainStage);
    whirlpool.centerAtActor(s);
    whirlpool.setOpacity(0.25f);
  }
}
