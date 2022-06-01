package com.ceashell.kittyconquest;

import com.badlogic.gdx.ApplicationAdapter;

public class Main extends ApplicationAdapter {
	public static int WIDTH = 1000;
	public static int HEIGHT = 700;
	static int state = 1;
	MenuState menuState;
	WorldState worldState;
	AssetManager assetManager;
	
	@Override
	public void create () {
		assetManager = new AssetManager();
		menuState = new MenuState();
		worldState = new WorldState();

	}

	@Override
	public void render () {
		State.run(state);
	}

	@Override
	public void dispose () {
		menuState.dispose();
		worldState.dispose();
		assetManager.dispose();
	}
}
