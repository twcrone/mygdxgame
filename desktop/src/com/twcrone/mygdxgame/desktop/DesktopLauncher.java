package com.twcrone.mygdxgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.twcrone.mygdxgame.HelloWorldImage;
import com.twcrone.mygdxgame.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
//		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new MyGdxGame(), config);
		HelloWorldImage myProgram = new HelloWorldImage();
		LwjglApplication launder = new LwjglApplication(myProgram);
	}
}
