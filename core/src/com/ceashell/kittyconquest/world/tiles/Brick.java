package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;

import java.awt.*;

public class Brick extends Tile {
    protected Brick(Point position, TextureRegion texture) {
        super(position, TileType.BRICK, texture);
    }
}
