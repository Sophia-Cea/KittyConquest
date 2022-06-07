package com.ceashell.kittyconquest.states;

public interface State {
    void onEnter();
    void onExit();
    void update(float delta);  // returns the new state to transition to or null
    void handleInput();        // returns the new state to transition to or null
    void render();
    void resize(int width, int height);
    void dispose();
}
