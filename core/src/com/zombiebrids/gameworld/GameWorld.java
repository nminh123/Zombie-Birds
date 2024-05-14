package com.zombiebrids.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.zombiebrids.GameObjects.Bird;
import com.zombiebrids.GameObjects.ScrollHandler;
import com.zombiebrids.ZBHelpers.AssetLoader;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;
    public boolean isAlive = true;
    private Rectangle ground;
    private int score = 0;


    public GameWorld(int midPointY)
    {
        bird = new Bird(33, midPointY - 5, 17, 12);
        //The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(this,midPointY + 66);
        ground = new Rectangle(0,midPointY+66,136,11);
    }

    public void update(float delta) {
        if(delta > .15f)
        {
            delta = .15f;
        }
        bird.update(delta);
        scroller.update(delta);
        if (isAlive && scroller.collides(bird)) {
            scroller.stop();
            AssetLoader.Dead.play(3.0f);
            isAlive = false;
        }

        if(Intersector.overlaps(bird.getBoundingCircle(),ground))
        {
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller()
    {
        return scroller;
    }
    public int getScore()
    {
        return score;
    }
    public void addScore(int increment)
    {
        score += increment;
    }
}
