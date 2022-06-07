package com.ceashell.kittyconquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ceashell.kittyconquest.states.GameStateManager;
import com.ceashell.kittyconquest.states.TestState1;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	public static int WIDTH = 1000;
	public static int HEIGHT = 700;
	public static SpriteBatch spriteBatch; // TODO : Find a way to share SpriteBatch

	GameStateManager gameStateManager;
	AssetManager assetManager;
	
	@Override
	public void create () {
		assetManager = new AssetManager();
		spriteBatch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		gameStateManager.push(new TestState1());

	}

	@Override
	public void render () {
		gameStateManager.handleInput();
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render();
	}

	@Override
	public void dispose () {
		gameStateManager.dispose();
		assetManager.dispose();
	}

	@Override
	public void resize(int width, int height) {
		gameStateManager.resize(width, height);
	}
}
