package com.ceashell.kittyconquest;

import com.badlogic.gdx.ApplicationAdapter;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	public static int WIDTH = 1000;
	public static int HEIGHT = 700;
	static int state = 1;
	ArrayList<State> states;
	AssetManager assetManager;
	
	@Override
	public void create () {

		assetManager = new AssetManager();
		states = new ArrayList<>();

		states.add(new MenuState());
		states.add(new WorldState());

	}

	@Override
	public void render () {
		State.run(state);
	}

	@Override
	public void dispose () {
		states.forEach(State::dispose);
		assetManager.dispose();
	}

	@Override
	public void resize(int width, int height) {
		states.get(state).resize(width, height);
	}
}
