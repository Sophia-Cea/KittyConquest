package com.ceashell.kittyconquest.world.entities.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.ceashell.kittyconquest.world.entities.Direction;
import com.ceashell.kittyconquest.world.entities.Entity;

public class PlayerIdleState extends EntityIdleState{

    public PlayerIdleState(Entity entity) {
        super(entity);
    }

    @Override
    public void update(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            this.entity.direction = Direction.LEFT;
            this.entity.stateMachine.change("walking");
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            this.entity.direction = Direction.RIGHT;
            this.entity.stateMachine.change("walking");
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            this.entity.direction = Direction.UP;
            this.entity.stateMachine.change("walking");
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            this.entity.direction = Direction.DOWN;
            this.entity.stateMachine.change("walking");
        }
    }


}
