package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {

    private TextureAtlas atlas;

    public AssetManager(){
        atlas = new TextureAtlas("world-tiles.atlas");
    }

    public TextureRegion get(String name) {
        TextureAtlas.AtlasRegion region = atlas.findRegion(name);
        if(region != null) return region;
        System.err.println("(AssetManager) Texture with name " + name + " not found!");
        return this.getTextureNotFound();
    }

    public TextureRegion getTextureNotFound(){
        return this.atlas.findRegion("not_found");
    }

    public void dispose(){
        atlas.dispose();
    }
}
