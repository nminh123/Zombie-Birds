package com.zombiebrids.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.zombiebrids.game.Zombirds;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		//config.setWindowedMode(1200,700);
		//config.setWindowedMode(480,320);
		config.setWindowedMode(500,500);
		config.setForegroundFPS(60);
		config.setTitle("Zomebie Birds");
		//config.setTitle("GMain");
		new Lwjgl3Application(new Zombirds(), config);
	}
}
