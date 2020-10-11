package com.twcrone.mygdxgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.twcrone.mygdxgame.helloworld.HelloWorldImage;
import com.twcrone.mygdxgame.starfishcollector.StarfishCollectorAlpha;

public class DesktopLauncher {
	public static void main (String[] arg) {
//		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new MyGdxGame(), config);
		StarfishCollectorAlpha myProgram = new StarfishCollectorAlpha();
		LwjglApplication launder = new LwjglApplication(myProgram);
	}
}
