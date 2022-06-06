package com.ceashell.kittyconquest.world.entities;

import com.ceashell.kittyconquest.Animation;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.entities.states.StateMachine;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;
import java.util.HashMap;

public abstract class Entity extends Tile {
    public StateMachine stateMachine;
    protected HashMap<String, Animation> animations;
    protected Animation currentAnimation;
    public Direction direction; // direction the entity is facing / trying to move
    public Entity(Point position, TileType type) {
        super(position, type, AssetManager.getInstance().get("clover"));
        this.animations = new HashMap<>();
        this.createAnimations();
        this.sprite.setRegion(this.currentAnimation.getFrame());
        this.direction = Direction.UP;
    }

    @Override
    public void update(float delta){

        this.currentAnimation.update(delta);
        this.sprite.setRegion(this.currentAnimation.getFrame());
        this.stateMachine.update(delta);
    }

    public void changeAnimation(String name) {
        this.currentAnimation.reset();
        this.currentAnimation = animations.get(name);
    }

    public abstract void createAnimations();

    public  void onInteract() {} // called when the player interacts with this entity



}
