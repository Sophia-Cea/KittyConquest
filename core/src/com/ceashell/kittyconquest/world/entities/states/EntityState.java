package com.ceashell.kittyconquest.world.entities.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ceashell.kittyconquest.world.entities.Entity;

public abstract class EntityState {
//    Concept from https://www.youtube.com/watch?v=gx_qorHxBpI
    protected Entity entity;
    public EntityState(Entity entity){
        this.entity = entity;
    }

    public void update(float delta){}
    public void onEnter(){}
    public void onExit(){}

}
