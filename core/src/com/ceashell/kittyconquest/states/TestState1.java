package com.ceashell.kittyconquest.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.Main;
import com.ceashell.kittyconquest.player.Player;
import com.ceashell.kittyconquest.player.PlayerState1;

public class TestState1 extends BaseState {
    Player player;
    @Override
    public void onEnter() {
        player = Player.getInstance();
        player.setState(new PlayerState1());
    }

    @Override
    public void onExit() {
        System.out.println("Exiting!");
    }

    @Override
    public void update(float delta) {
        player.update(delta);
    }

    @Override
    public void handleInput() {
        player.handleInput();
    }

    @Override
    public void render() {
        Main.spriteBatch.begin();
        player.render();
        Main.spriteBatch.end();
    }
}
