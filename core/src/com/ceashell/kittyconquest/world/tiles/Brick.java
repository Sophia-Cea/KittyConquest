package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.World;

import java.awt.*;

public class Brick extends Tile {
    // unused at the moment
    public Brick(Point position, TextureRegion texture) {
        super(position, TileType.BRICK, texture);
        this.sprite.setSize(World.TILE_SIZE, World.TILE_SIZE*1.5f);
    }
}
