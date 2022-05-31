package com.ceashell.kittyconquest.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;

public abstract class Tile {

    public final TileType type;
    private Point position; // decided to use this class bc its small and has everything we need, usually I use vector2, but we won't need most of the functions it has
    public Sprite sprite;

    protected Tile(Point position, TileType type, TextureRegion texture) {
        this.type = type;
        this.sprite = new Sprite(texture);
        this.sprite.setSize(World.TILE_SIZE, World.TILE_SIZE);
        this.position = position;
    }

    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
        this.sprite.setPosition(position.x * World.TILE_SIZE, position.y * World.TILE_SIZE);
    }
}
