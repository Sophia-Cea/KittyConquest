package com.ceashell.kittyconquest.world.tiles;

import com.ceashell.kittyconquest.world.entities.WorldPlayer;

public enum TileType {
    GRASS(0, "clover", BasicFloorTile.class),
    BRICK(1, "brick1", ScaledTile.class),
    WAVE(0, "wave", AnimatedTile.class),
    PLAYER(1, "rock03", WorldPlayer.class);


    public final int z_index; // used in determining layer: i.e. whether 1 tile can pass through another, which should be drawn on top of another, etc
    public final String assetName;
    public final Class<?> classType;
    TileType(int z_index, String assetName, Class<?> classType){
        this.z_index = z_index;
        this.assetName = assetName;
        this.classType = classType;
    }

    public static TileType FromOrdinal(int type){
        return TileType.values()[type];
    }

}
