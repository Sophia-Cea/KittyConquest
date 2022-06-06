package com.ceashell.kittyconquest.world.entities.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.ceashell.kittyconquest.world.World;
import com.ceashell.kittyconquest.world.entities.Direction;
import com.ceashell.kittyconquest.world.entities.Entity;

import java.awt.*;

public class EntityWalkingState extends EntityState {
    private static final float DURATION = 50f;

    private World world;

    // original and target position in pixels
    private float elapsedTime;
    private Point originalPos;
    private Point targetPos;

    public EntityWalkingState(Entity entity, World world) {
        super(entity);
        this.world = world;
        this.originalPos = this.entity.getPosition();
        this.targetPos = this.getTargetPosition();
        elapsedTime = 0f;
        this.attemptMove();
    }

    public void attemptMove(){
        this.entity.changeAnimation("walking");
        if(world.isInBounds(targetPos) && world.getForegroundTile(targetPos) == null){
            Vector2 spritePos = new Vector2(this.entity.sprite.getX(), this.entity.sprite.getY());
            this.entity.setPosition(targetPos);
            this.entity.sprite.setX(spritePos.x);
            this.entity.sprite.setY(spritePos.y);
        } else {
            this.entity.stateMachine.change("idle");
        }
    }

    @Override
    public void update(float delta) {
        this.elapsedTime += delta;
        this.updateLerpToTarget();
        if(this.elapsedTime > DURATION){
            this.onWalkFinished();
        }
    }

    void updateLerpToTarget(){
        Vector2 spritePos = pointToPixels(originalPos).lerp(pointToPixels(targetPos), getPercentDone());
        this.entity.sprite.setPosition(spritePos.x, spritePos.y);
    }

    void onWalkFinished(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            this.entity.direction = Direction.LEFT;
            this.entity.stateMachine.change("walking");
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            this.entity.direction = Direction.RIGHT;
            this.entity.stateMachine.change("walking");
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            this.entity.direction = Direction.UP;
            this.entity.stateMachine.change("walking");
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            this.entity.direction = Direction.DOWN;
            this.entity.stateMachine.change("walking");
        } else {
            this.entity.stateMachine.change("idle");
        }
    }

    Point getTargetPosition(){
        Point target = this.entity.getPosition();
        switch(this.entity.direction){
            case UP: target.y += 1; break;
            case DOWN: target.y -= 1; break;
            case LEFT: target.x -= 1; break;
            case RIGHT: target.x += 1; break;
        }
        return target;
    }

    float getPercentDone(){
        return elapsedTime / DURATION;
    }

    Vector2 pointToPixels(Point point){
        return new Vector2(point.x * World.TILE_SIZE, point.y * World.TILE_SIZE);
    }
}
