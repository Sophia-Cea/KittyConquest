package com.ceashell.kittyconquest.world;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.tiles.Grass;

import java.awt.*;

public enum TileType {
    GRASS(Grass.class){
        @Override
        public Tile fromType(AssetManager assetManager) {
            TextureRegion texure = assetManager.get("clover");
            return new Grass(new Point(0,0), texure);
        }
    };

    public final Class<? extends Tile> tileClass;
    TileType(Class<? extends Tile> tileClass){
        this.tileClass = tileClass;
    }

    public abstract Tile fromType(AssetManager assetManager);


}
