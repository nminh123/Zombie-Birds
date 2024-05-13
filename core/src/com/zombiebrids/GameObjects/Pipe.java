package com.zombiebrids.GameObjects;

import java.util.Random;
public class Pipe extends Scrollable{
    private Random radius;

    //When Pipe's constructor invoked, invoke the super (Scrollable)
    public Pipe(float x, float y, int width, int height, float scrollingSpeed) {
        super(x, y, width, height, scrollingSpeed);
        radius = new Random();
    }
    @Override
    public void reset(float newX)
    {
        //call the reset method in the superclass (Scrollable)
        super.reset(newX);
        //Change the height to a random number
        height = radius.nextInt(90) + 15;
    }
}
