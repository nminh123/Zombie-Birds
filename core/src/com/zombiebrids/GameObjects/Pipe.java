package com.zombiebrids.GameObjects;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Pipe extends Scrollable{
    private Random radius;
    private Rectangle skullUp, skullDown, barUp, barDown;
    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;
    private float groundY;
    private boolean isScored = false;

    //When Pipe's constructor invoked, invoke the super (Scrollable)
    //Constructor
    public Pipe(float x, float y, int width, int height, float scrollingSpeed, float groundY) {
        super(x, y, width, height, scrollingSpeed);
        radius = new Random();
        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();

        this.groundY = groundY;
    }
    @Override
    public void reset(float newX)
    {
        //call the reset method in the superclass (Scrollable)
        super.reset(newX);
        //Change the height to a random number
        height = radius.nextInt(90) + 15;
        isScored = false;
    }

    public boolean isScored()
    {
        return isScored;
    }

    public void setScored(boolean b)
    {
        isScored = b;
    }
    public void update(float delta)
    {
        //Call the update methods in the superclass(Scrollable)
        super.update(delta);

        //The set() methods allows you to set the top left corner's x, y
        //coordinates,
        //along with the width and height of the rectangle

        barUp.set(position.x,position.y,width,height);
        barDown.set(position.x,position.y+height+VERTICAL_GAP, width,
                groundY - (position.y+height + VERTICAL_GAP));

        //Our skull width is 24. The bar is only 22 pixels wide, So the skull
        //must be shfted by 1 pixel to the left(so that the skull is centered
        //with respect to its bar

        //This shift is equivalent to (SKULL_WIDTH - width)/2
        skullUp.set(position.x - (float)(SKULL_WIDTH - width) / 2,
                position.y + height - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (float)(SKULL_WIDTH - width)/2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);
    }

    boolean collides(Bird bird)
    {
        if(position.x < bird.getX() + bird.getWidth())
        {
            return (Intersector.overlaps(bird.getBoundingCircle(), barUp)
                    || Intersector.overlaps(bird.getBoundingCircle(), barDown)
                    || Intersector.overlaps(bird.getBoundingCircle(), skullUp)
                    || Intersector.overlaps(bird.getBoundingCircle(), skullDown));
        }
        return false;
    }

    public Rectangle getSkullUp()
    {
        return skullUp;
    }

    public Rectangle getSkullDown()
    {
        return skullDown;
    }

    public Rectangle getBarUp()
    {
        return barUp;
    }

    public Rectangle getBarDown()
    {
        return barDown;
    }
}
