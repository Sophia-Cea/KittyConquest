package com.ceashell.kittyconquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	public static int WIDTH = 1000;
	public static int HEIGHT = 700;
	static int state = 0;
	MenuState menuState;
	
	@Override
	public void create () {
		menuState = new MenuState();
	}

	@Override
	public void render () {
		State.run(state);
	}

	
	@Override
	public void dispose () {
//		menuState.batch.dispose();
//		menuState.img.dispose();
		menuState.dispose();
	}
}
