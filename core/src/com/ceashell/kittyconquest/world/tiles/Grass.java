package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.TileType;

import java.awt.*;

public class Grass extends Tile {
    public Grass(Point position, TextureRegion texture) {
        super(position, TileType.GRASS, texture);
    }
}
