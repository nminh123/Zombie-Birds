package com.zombiebrids.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zombiebrids.GameObjects.ScrollHandler;
import com.zombiebrids.ZBHelpers.AssetLoader;
import com.zombiebrids.GameObjects.Bird;
import com.zombiebrids.GameObjects.Grass;
import com.zombiebrids.GameObjects.Pipe;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private int midPointY;
    private int gameHeight;
    //game Object
    private Bird bird;
    private ScrollHandler scroller;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2,pipe3;
    //Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdUp, birdDown;
    private TextureRegion skullUp, skullDown, bar;


    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;
        //The word "this" refers to this instance.
        //We are setting the instance variables values to be that of the
        //parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 137, gameHeight);

        batcher = new SpriteBatch();
        //Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        //Call helper methods to initialize instance variables
        initGameObjects();
        initAssets();
    }

    private void initGameObjects()
    {
        bird = myWorld.getBird();
        scroller = myWorld.getScroller();
        frontGrass = scroller.getFontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
    }

    private void initAssets()
    {
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }

    void drawGrass()
    {
        batcher.draw(grass, frontGrass.GetX(),frontGrass.GetY()
                ,frontGrass.getWidth(),frontGrass.getHeight());
        batcher.draw(grass, backGrass.GetX(), backGrass.GetY()
                ,backGrass.getWidth(), backGrass.getHeight());
    }

    void drawSkulls()
    {
        batcher.draw(skullUp, pipe1.GetX() - 1,
                pipe1.GetY() + pipe1.getHeight() - 14, 24, 14);
        batcher.draw(skullDown, pipe1.GetX() - 1,
                pipe1.GetY() + pipe1.getHeight() + 45, 24, 14);

        batcher.draw(skullUp, pipe2.GetX() - 1,
                pipe2.GetY() + pipe2.getHeight() - 14, 24, 14);
        batcher.draw(skullDown, pipe2.GetX() - 1,
                pipe2.GetY() + pipe2.getHeight() + 45, 24, 14);

        batcher.draw(skullUp, pipe3.GetX() - 1,
                pipe3.GetY() + pipe3.getHeight() - 14, 24, 14);
        batcher.draw(skullDown, pipe3.GetX() - 1,
                pipe3.GetY() + pipe3.getHeight() + 45, 24, 14);
    }
     void drawPipes()
     {
        // Temporary code! Sorry about the mess :)
        // We will fix this when we finish the Pipe class.
        batcher.draw(bar, pipe1.GetX(), pipe1.GetY(), pipe1.getWidth(),
                pipe1.getHeight());
        batcher.draw(bar, pipe1.GetX(), pipe1.GetY() + pipe1.getHeight() + 45,
                pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

        batcher.draw(bar, pipe2.GetX(), pipe2.GetY(), pipe2.getWidth(),
                pipe2.getHeight());
        batcher.draw(bar, pipe2.GetX(), pipe2.GetY() + pipe2.getHeight() + 45,
                pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

        batcher.draw(bar, pipe3.GetX(), pipe3.GetY(), pipe3.getWidth(),
                pipe3.getHeight());
        batcher.draw(bar, pipe3.GetX(), pipe3.GetY() + pipe3.getHeight() + 45,
                pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
    }

    public void render(float runTime) {
        //We will move these outside of the loop for performance later.
        //Bird bird = myWorld.getBird();

        //Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);

        //Draw background color
        shapeRenderer.setColor(55/255.0f,80/255.0f,100/255.0f,1);
        shapeRenderer.rect(0,0,136,midPointY+66);

        //Draw Grass
        shapeRenderer.setColor(111/255.0f, 186/255.0f, 45/255.0f,1);
        shapeRenderer.rect(0,midPointY+66,136,11);

        //Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0,midPointY+77,136,52);

        //End shapeRenderer
        shapeRenderer.end();

        //Begin SpriteBatch
        batcher.begin();
        //Disable transparency
        //This is good for performance when drawing images that do not require
        //transparency
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg,0,midPointY+23,136,43);

        //Draw Grass
        drawGrass();
        //Draw Pipes
        drawPipes();
        batcher.enableBlending();
        //Draw Skull
        drawSkulls();
        //The bird nees transparency, so we enable that again.
        batcher.enableBlending();

        if(bird.shouldntFlap())
        {
            batcher.draw(birdMid, bird.getX(), bird.getY(),bird.getWidth()/2.0f,bird.getHeight()/2.0f
                    ,bird.getWidth(),bird.getHeight(),1,1,bird.getRotation());
        }

        else {
            batcher.draw((TextureRegion) birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
        }

        //Draw bird at its coordinates. Retrieve the Animation object from
        //AssetLoader
        //Pass in the runTime variable to get the current frame.

        //batcher.draw((TextureRegion) AssetLoader.birdAnimation.getKeyFrame(runTime), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        //End SpriteBatch
        batcher.end();

    }
}
