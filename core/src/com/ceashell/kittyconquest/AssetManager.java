package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {
    /*
    AssetManager is a Singleton shared across the program. It only needs to be instantiated once,
    After that, call AssetManager.getInstance() to get the instance.
     */

    private TextureAtlas atlas;
    private static AssetManager instance;

    public static AssetManager getInstance(){
        if(instance == null) {
            return new AssetManager();
        }
        return instance;
    }

    public TextureRegion get(String name) {
        TextureAtlas.AtlasRegion region = atlas.findRegion(name);
        if(region != null) return region;
        System.err.println("(AssetManager) Texture with name " + name + " not found!");
        return this.getTextureNotFound();
    }

    protected AssetManager(){
        if(instance != null){
            throw new Error("AssetManager has already been instantiated!");
        }
        instance = this;
        atlas = new TextureAtlas("world-tiles.atlas");
    }

    public void printTextureNames(){
        System.out.println("Textures in atlas: ");
        atlas.getRegions().forEach((TextureAtlas.AtlasRegion region) -> {
            System.out.println("Region name = " + region.name);
        });
    }

    public TextureRegion getTextureNotFound(){
        return this.atlas.findRegion("not_found");
    }

    public void dispose(){
        atlas.dispose();
    }
}
