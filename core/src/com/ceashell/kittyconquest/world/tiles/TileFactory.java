package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.Tile;

import java.awt.*;

public class TileFactory {
    /*
    Not a real factory. I could move this into a pre-existing file, but I'm not sure where I would put it.
    Not even sure if this is the way to go for creating Tiles. I know I don't want you to use the
    actual class's constructor, but how to separate it out without making the process of adding a new tile tedious?
    Tiles are so similar that there has to be a way to streamline the process.

    I have 3 options:
    Either clutter the World class by having it handle the instantiation of tiles,
    separate it out into a different file,
    or figure out a better way.

    I think in the long run it doesn't really matter too too much but I'd like to be able to quickly add new tiles.
     */
    public static Tile create(TileType type, Point position){
        TextureRegion texture = AssetManager.getInstance().get(type.assetName);

        switch(type){
            case GRASS: return new Grass(position, texture);
            case BRICK: return new Brick(position, texture);
            default: throw new Error("Type not supported by TileFactory!");
        }
    }
}
