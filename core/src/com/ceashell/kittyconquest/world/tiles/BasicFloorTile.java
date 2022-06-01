package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;

import java.awt.*;

public class BasicFloorTile extends Tile {
    public BasicFloorTile(Point position, TileType type, TextureRegion texture) {
        super(position, type, texture);
    }
}
