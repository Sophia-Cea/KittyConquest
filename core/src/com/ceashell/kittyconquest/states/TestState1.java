package com.ceashell.kittyconquest.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.Main;

public class TestState1 extends BaseState {
    Sprite testSprite;
    Vector2 velocity;
    @Override
    public void onEnter() {

        // randomize position
        float x = (float) (Math.random() * Gdx.graphics.getWidth());
        float y = (float) (Math.random() * Gdx.graphics.getHeight());

        testSprite = new Sprite(AssetManager.getInstance().get("clover"));
        testSprite.setPosition(x, y);
        testSprite.setSize(100, 100);

    }

    @Override
    public void onExit() {
        System.out.println("Exiting!");
    }

    @Override
    public void update(float delta) {
        float changeX = (float) ((Math.random() - 0.5f) * delta * 100);
        float changeY = (float) ((Math.random() - 0.5f)  * delta * 100);
        testSprite.setPosition(testSprite.getX() + changeX, testSprite.getY() + changeY);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            GameStateManager.getInstance().push(new TestState1());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT)){
            GameStateManager.getInstance().pop();
        }
    }

    @Override
    public void render() {
        Main.spriteBatch.begin();
        testSprite.draw(Main.spriteBatch);
        Main.spriteBatch.end();
    }
}
