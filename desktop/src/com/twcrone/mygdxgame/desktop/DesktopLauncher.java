package com.twcrone.mygdxgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.twcrone.mygdxgame.starfishcollector.StarfishCollectorBeta;

public class DesktopLauncher {
  public static void main(String[] arg) {
    //		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    //		new LwjglApplication(new MyGdxGame(), config);
    //		StarfishCollectorAlpha myProgram = new StarfishCollectorAlpha();
    //		LwjglApplication launder = new LwjglApplication(myProgram, "Starfish Collector", 800, 600);
    StarfishCollectorBeta myProgram = new StarfishCollectorBeta();
    LwjglApplication launder = new LwjglApplication(myProgram, "Starfish Collector", 800, 600);
  }
}
