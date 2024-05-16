package com.zombiebrids.ZBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.audio.Sound;

public class AssetLoader {

    public static Texture texture;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;

    public static TextureRegion skullUp, skullDown, bar;

    public static Sound dead, flap, coin;

    public static BitmapFont font, shadow;

    public static void load() {

        texture = new Texture(Gdx.files.internal("texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);

        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        //birdAnimation.setPlayMode(Animation.LOOP_PINGPONG);

        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        // Create by flipping existing skullUp
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);

        dead = Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));

        //font = new BitmapFont(Gdx.files.internal("ka1.ttf"), false);

        //font.getData().setScale(.25f, -.25f);
        //shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        //shadow.getData().setScale(.25f, -.25f);
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();

        // Dispose sounds
        dead.dispose();
        flap.dispose();
        coin.dispose();

        //font.dispose();
        //shadow.dispose();
    }
}
