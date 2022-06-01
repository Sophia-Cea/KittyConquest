package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.World;

import java.awt.*;

public class Player extends Tile {
    private World world;
    public Player(Point position, TextureRegion texture, World world) {
        super(position, TileType.PLAYER, texture);
        this.world = world;
        world.setForegroundTile(this, position.x, position.y);
    }

    public void move(int direction){
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        int dx = 0, dy = 0;
        switch (direction){
            case 0: dx = -1; break;
            case 1: dx = 1; break;
            case 2: dy = -1; break;
            case 3: dy = 1; break;
            default: break;
        }
        if(world.getForegroundTile(x + dx, y + dy) != null){ // tile occupying desired space
            System.out.println("Bumped into a wall!");
        } else {
            if(world.isInBounds(x + dx, y + dy)) { // desired space is not out of bounds
                world.setForegroundTile(this, x + dx, y + dy); // move to desired space
                world.setForegroundTile(null, x, y); // ensure no duplicates remain in the array
            }
        }
    }



}
