package com.ceashell.kittyconquest.states;

import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Stack;

public class GameStateManager {

    private static GameStateManager instance;
    public static GameStateManager getInstance(){
        if(instance == null) {
            return new GameStateManager();
        }
        return instance;
    }

    public GameStateManager(){
        if(instance != null){
            throw new Error("AssetManager has already been instantiated!");
        }
        instance = this;
        gameStates = new Stack<>();
    }

    private final Stack<State> gameStates;

    public State peek(){
        return this.gameStates.peek();
    }

    public void push(State state){
        this.gameStates.push(state);
        state.onEnter();
    }

    public State pop() {
        this.peek().onExit();
        return this.gameStates.pop();
    }

    public void handleInput(){
        this.gameStates.peek().handleInput();
    }

    public void update(float delta){
        // updates top 3 states in the stack
        for (int i = this.gameStates.size()-1; i > this.gameStates.size()-4; i--) {
            if(i >= 0) this.gameStates.get(i).update(delta);
        }
    }

    public void render(){
        ScreenUtils.clear(1,1,1,1);
        // updates top 3 states in the stack
        for (int i = this.gameStates.size()-1; i > this.gameStates.size()-4; i--) {
            if(i >= 0) this.gameStates.get(i).render();
        }
    }

    public void dispose() {
        // disposes of all states
        this.gameStates.forEach(State::dispose);
    }

    public void resize(int width, int height) {
        // resizes all states
        this.gameStates.forEach((State state) -> state.resize(width, height));
    }



}
