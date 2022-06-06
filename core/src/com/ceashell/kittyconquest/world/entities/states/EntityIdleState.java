package com.ceashell.kittyconquest.world.entities.states;

import com.ceashell.kittyconquest.world.entities.Entity;

public class EntityIdleState extends EntityState{


    public EntityIdleState(Entity entity) {
        super(entity);

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void onEnter() {
        this.entity.changeAnimation("idle");
    }

    @Override
    public void onExit() {

    }
}
