package com.zomebiebrids.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    public GameRenderer(GameWorld world)
    {
        myWorld = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(true,136,204);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
    public void render()
    {
        Gdx.app.log("GameRenderer","render");

        //1. Draw a black background. This prevents flickering.

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //2 We draw the Filled rectangle

        //tell shapeRenderer to begin drawing filled shapes
        shapeRenderer.begin(ShapeType.Filled);

        //Chooses RGB color of 87, 109, 120, all full opacity
        shapeRenderer.setColor(87/255.0f, 109/255.0f, 120/255.0f, 1);

        //Draws the rectangle from myWorld (Using ShapeType.Filled)
        shapeRenderer.rect(myWorld.getRectangle().x, myWorld.getRectangle().y,
                myWorld.getRectangle().width, myWorld.getRectangle().height);

        //Tells the shapeRenderer to finish rendering
        //We MUST do this every time
        shapeRenderer.end();

        //3. We draw the Rectangle's outline

        //Tell shapeRenderer to draw an outline of the following shapes
        shapeRenderer.begin(ShapeType.Filled);

        //Chooses RGB color of 255, 109, 120, at full opacity
        shapeRenderer.setColor(255/255.0f,109/255.0f,120/255.0f,1);

        //Draws the Rectangle from myWorld (Using ShapeType.Line)
        shapeRenderer.rect(myWorld.getRectangle().x, myWorld.getRectangle().y,
                myWorld.getRectangle().width, myWorld.getRectangle().height);

        shapeRenderer.end();
    }
}
