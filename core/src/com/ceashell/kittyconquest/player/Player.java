package com.ceashell.kittyconquest.player;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ceashell.kittyconquest.Animation;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.Main;

import java.util.HashMap;

public class Player {

    private static Player instance;
    public static Player getInstance(){
        if(instance == null){
            instance = new Player();
        }
        return instance;
    }

    public PlayerData playerData;
    private EntityState state;
    public Sprite sprite;
    private Animation currentAnimation;
    private HashMap<String, Animation> animations;

    public Player(){
        playerData = new PlayerData();
        initAnimations();
        this.sprite = new Sprite();
    }

    public void setState(EntityState state){
        this.state = state;
        state.enter();
    }

    private void initAnimations() {
        this.animations = new HashMap<>();
        this.animations.put("test", new Animation(AssetManager.getInstance().get("wave"), 1, 1f));
        this.animations.put("test1", new Animation(AssetManager.getInstance().get("rock01"), 2, 0.2f));
    }

    public void setAnimation(String animationName) {
        if(animations.containsKey(animationName)){
            currentAnimation = animations.get(animationName);
            sprite.setRegion(currentAnimation.getFrame());
        } else {
            throw new Error("Animation with name " + animationName + " does not exist!");
        }
    }

    public void update(float delta) {
        // switches to new state potentially returned by update()
        // if no state returned, the current state remains
        this.currentAnimation.update(delta);
        switchState(state.update(delta));
    }

    public void handleInput(){
        // switches to new state potentially returned by update()
        // if no state returned, the current state remains
        switchState(state.handleInput());
    }

    public void render(){
        this.sprite.setRegion(this.currentAnimation.getFrame());
        this.sprite.draw(Main.spriteBatch);
    }

    private void switchState(EntityState newState){
        if(newState != null){
            this.state.exit();
            this.state = newState;
            this.state.enter();
        }
    }
}
