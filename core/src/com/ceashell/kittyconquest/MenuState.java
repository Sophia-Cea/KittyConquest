package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuState extends State {
    public SpriteBatch batch;
    public Texture img;
    Animation cat = new Animation(new TextureRegion(new Texture("cats.png"), 0, 100, 144, 48), 3, 2);

    public MenuState() {
        super();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void update() {
        cat.update();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(img, 100, 100);
		batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
		img.dispose();
    }


}
