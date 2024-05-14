package com.zombiebrids.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zombiebrids.ZBHelpers.AssetLoader;

public class Zombirds extends Game
{
	private BitmapFont font;
	private SpriteBatch batch;
	private OrthographicCamera hudCamera;
	@Override
	public void create() {
		Gdx.app.log("ZomBirds", "Created");
		AssetLoader.load();
		setScreen(new GameScreen());

		/*hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		hudCamera.position.set(hudCamera.viewportWidth / 2.0f, hudCamera.viewportHeight / 2.0f, 1.0f);*/
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
		/*hudCamera.update();
		batch.setProjectionMatrix(hudCamera.combined);
		batch.begin();
		font.draw(batch, "Upper left, FPS=" + Gdx.graphics.getFramesPerSecond(), 0, hudCamera.viewportHeight);
		batch.end();*/
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
