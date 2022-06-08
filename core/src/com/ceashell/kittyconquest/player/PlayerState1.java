package com.ceashell.kittyconquest.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerState1 implements EntityState{
    @Override
    public void enter() {
        Player.getInstance().setAnimation("test");
        Player.getInstance().sprite.setBounds(200, 200, 100, 100);
    }

    @Override
    public void exit() {

    }

    @Override
    public EntityState update(float delta) {
        Sprite sprite = Player.getInstance().sprite;
        float newX = sprite.getX() + 10 * delta;
        float newY = sprite.getY() - 0.5f * delta;

        if(newX > Gdx.graphics.getWidth()) {
            newX = 0;
        }
        if(newX > Gdx.graphics.getHeight()) {
            newY = 0;
        }
        sprite.setPosition(newX, newY);

        return null;
    }

    @Override
    public EntityState handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            return new PlayerState2();
        }
        return null;
    }
}
