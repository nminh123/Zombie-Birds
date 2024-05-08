package com.zomebiebrids.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Rectangle rectangle = new Rectangle(0,0,17,12);
    public void update(float delta)
    {
        Gdx.app.log("GameWorld", "updated");
        rectangle.x++;
        if(rectangle.x > 137)
        {
            rectangle.x = 0;
        }
    }
    public Rectangle getRectangle()
    {
        return rectangle;
    }
}
