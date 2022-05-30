package com.ceashell.kittyconquest;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public abstract class State {
    public static ArrayList<State> states = new ArrayList();
    int index;

    public State() {
        states.add(this);
        index = states.size() - 1;
    }

    public abstract void update(float delta);

    public abstract void handleInput();

    public abstract void render();

    public static void run(int state) {
        states.get(state).update(Gdx.graphics.getDeltaTime());
        states.get(state).handleInput();
        states.get(state).render();
    }

    public abstract void dispose();
}
