package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.ceashell.kittyconquest.world.World;

import java.awt.*;

public class GameCamera extends OrthographicCamera {

    private Sprite following;

    public GameCamera(float viewportWidth, float viewportHeight) {
        super(viewportWidth, viewportHeight);
    }

    public void follow(Sprite sprite){
        this.following = sprite;
    }

    public void stopFollowing(){
        this.following = null;
    }

    @Override
    public void update() {

        if(this.following != null) {
            this.position.lerp(getFollowingPosition(), 0.03f);

        }
        super.update();
    }

    public void setPosition(Point gridPosition){
        this.position.x = gridPosition.x * World.TILE_SIZE;
        this.position.y = gridPosition.y * World.TILE_SIZE;
        this.update();
    }

    private Vector3 getFollowingPosition(){
        return new Vector3(this.following.getX(), this.following.getY(), this.position.z);
    }
}
