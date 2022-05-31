package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldState extends State {
    public SpriteBatch batch;
    public Texture img;
    Animation cat = new Animation(new TextureRegion(new Texture("cats.png"), 0, 100, 144, 52), 3, .5f);

    public WorldState() {
        super();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void update(float delta) {
        cat.update(delta);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        batch.draw(cat.getFrame(), 100, 100, 250,200);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
