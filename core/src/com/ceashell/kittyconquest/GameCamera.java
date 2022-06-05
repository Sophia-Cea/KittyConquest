package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ceashell.kittyconquest.world.World;

import java.awt.*;

public class GameCamera extends OrthographicCamera {
    public GameCamera(float viewportWidth, float viewportHeight) {
        super(viewportWidth, viewportHeight);
    }

    public void setPosition(Point gridPosition){
        this.position.x = gridPosition.x * World.TILE_SIZE;
        this.position.y = gridPosition.y * World.TILE_SIZE;
        this.update();
    }
}
