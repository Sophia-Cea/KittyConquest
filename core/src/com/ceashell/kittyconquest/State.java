package com.ceashell.kittyconquest;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public abstract class State {
    public static ArrayList<State> states = new ArrayList<>();
    int index;

/*
 Note: I was worried here that states might not get added to the list if super() isn't called in the subclass'
 constructor, but that turned out not to be an issue. Still, it could be an issue later. Delete this when you read it.
 -Andrew
 */
    public State() {
        states.add(this);
        index = states.size() - 1;
    }

    public abstract void update(float delta);

    public abstract void handleInput();

    public abstract void render();

    public static void run(int state) {
        states.get(state).handleInput();
        states.get(state).update(Gdx.graphics.getDeltaTime());
        states.get(state).render();
    }

    public void resize(int width, int height){}

    public abstract void dispose();
}
