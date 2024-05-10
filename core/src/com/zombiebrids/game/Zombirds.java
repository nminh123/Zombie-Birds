package com.zombiebrids.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.zombiebrids.ZBHelpers.AssetLoader;

public class Zombirds extends Game
{
	@Override
	public void create() {
		Gdx.app.log("ZomBirds", "Created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose()
	{
		AssetLoader.dispose();
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
