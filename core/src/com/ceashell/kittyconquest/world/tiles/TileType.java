package com.ceashell.kittyconquest.world.tiles;

public enum TileType {
    GRASS(0, "clover"),
    BRICK(1, "brick1"),
    PLAYER(1, "rock03");

    public final int z_index; // used in determining layer: i.e. whether 1 tile can pass through another, which should be drawn on top of another, etc
    public final String assetName;
    TileType(int z_index, String assetName){
        this.z_index = z_index;
        this.assetName = assetName;
    }



}
