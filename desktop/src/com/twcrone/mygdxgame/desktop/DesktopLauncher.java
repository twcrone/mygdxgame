package com.twcrone.mygdxgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.twcrone.mygdxgame.starfishcollector.StarfishCollectorBeta;

public class DesktopLauncher {
  public static void main(String[] arg) {
    StarfishCollectorBeta myProgram = new StarfishCollectorBeta();
    new LwjglApplication(myProgram, "Starfish Collector", 800, 600);
  }
}
