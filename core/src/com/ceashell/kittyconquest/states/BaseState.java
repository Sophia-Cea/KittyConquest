package com.ceashell.kittyconquest.states;

public class BaseState implements State {
    public BaseState() {
    }

    /*
    Basic State class so that you don't have to have a wall of empty @Override functions
    And so that you can choose what to override and what not to.
     */

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
