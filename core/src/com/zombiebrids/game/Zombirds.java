package com.zombiebrids.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Zombirds extends Game
{
	@Override
	public void create() {
		Gdx.app.log("ZomBirds", "Created");
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
