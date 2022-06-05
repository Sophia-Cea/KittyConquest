package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.Tile;

import java.awt.*;

public class ScaledTile extends Tile {
    protected ScaledTile(Point position, TileType type, TextureRegion texture, float scaleX, float scaleY) {
        super(position, type, texture);
        this.sprite.setOrigin(0,0);
        this.sprite.setScale(scaleX, scaleY);
    }
}
