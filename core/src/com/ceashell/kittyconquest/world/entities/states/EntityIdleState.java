package com.ceashell.kittyconquest.world.entities.states;

import com.ceashell.kittyconquest.world.entities.Entity;

public class EntityIdleState extends EntityState{


    public EntityIdleState(Entity entity) {
        super(entity);
        this.entity.changeAnimation("idle");
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}
