package com.twcrone.mygdxgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.twcrone.mygdxgame.starfishcollector.StarfishCollector;

public class DesktopLauncher {
  public static void main(String[] arg) {
    StarfishCollector myProgram = new StarfishCollector();
    new LwjglApplication(myProgram, "Starfish Collector", 800, 600);
  }
}
