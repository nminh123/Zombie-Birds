package com.zombiebrids.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.zombiebrids.GameObjects.Bird;
import com.zombiebrids.GameObjects.ScrollHandler;

public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY)
    {
        bird = new Bird(33, midPointY - 5, 17, 12);
        //The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
        if(scroller.collides(bird))
        {
            //clean up on game over
            scroller.stop();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller()
    {
        return scroller;
    }
}
