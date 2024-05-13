package com.zombiebrids.GameObjects;

import com.badlogic.gdx.math.Vector2;
public class Scrollable {
    //Protected í similar to private, but allows inheritance by subclasses
    protected Vector2 position;
    protected Vector2  velocity;
    protected int width;
    protected int height;
    protected boolean isScrolledLeft;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed)
    {
        position = new Vector2(x,y);
        velocity = new Vector2(scrollSpeed,0);
        this.width = width;
        this.height = height;
        isScrolledLeft = false;
    }

    public void update(float delta)
    {
        position.add(velocity.cpy().scl(delta));
        //If the Scrollable object is no longer visible:
        if(position.x + width < 0)
        {
            isScrolledLeft = false;
        }
    }

    void reset(float newX)
    {
        position.x = newX;
        isScrolledLeft = false;
    }

    void stop()
    {
        velocity.x = 0;
    }

    boolean isScrolledLeft()
    {
        return isScrolledLeft;
    }

    public float getTailX()
    {
        return position.x + width;
    }

    public float GetX()
    {
        return position.x;
    }

    public float GetY()
    {
        return position.y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
