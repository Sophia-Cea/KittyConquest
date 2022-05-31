package com.ceashell.kittyconquest.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;


public class World {
    public static final float TILE_SIZE = 100f;
    private Tile[][] background;
    private Tile[][] foreground;
    public final int width;
    public final int height;
//    The bottom left tile will be at point (0,0) if camera is at origin
    public World(int width, int height){
        background = new Tile[height][width];
        foreground = new Tile[height][width];
        this.width = width;
        this.height = height;
    }

    public void init(int[] bg, int[] fg, AssetManager assetManager) {
        background = initTiles(bg, assetManager);
        foreground = initTiles(fg, assetManager);
    }

//    TODO : Use camera
    public void draw(SpriteBatch batch){
        drawArray(background, batch);
        drawArray(foreground, batch);
    }

    public void setForegroundTile(Tile tile, int x, int y){
        setTile(foreground, tile, x, y);
    }

    public void setBackgroundTile(Tile tile, int x, int y){
        setTile(background, tile, x, y);
    }

    private void setTile(Tile[][] target, Tile tile, int x, int y){
        tile.setPosition(new Point(x, y));
        target[y][x] = tile;
    }

    public Tile getForegroundTile(int x, int y){
        return foreground[y][x];
    }

    public Tile getBackgroundTile(int x, int y){
        return background[y][x];
    }

    private void drawArray(Tile[][] list, SpriteBatch batch){ // prevent code duplication
        for(int y = height-1; y >= 0; y--){
            for(int x = 0; x < width; x++){
                Tile tile = list[y][x];
                if(tile != null) list[y][x].render(batch);
            }
        }
    }

    private Tile[][] initTiles(int[] source, AssetManager assetManager) {
        assert source.length == this.width * this.height; // make sure they're the same size
        Tile[][] target = new Tile[height][width];

        TileType[] types = TileType.values(); // turn int[] -> TileType[]
        int x = 0;
        int y = height-1;
        for(int i = 0; i < source.length; i++){
            if(source[i] != -1) { // -1 -> no tile there
                TileType type = types[source[i]];
                Tile tile = type.fromType(assetManager);
                setTile(target, tile, x, y);
            }

            x++;
            if(x == width) {
                x = 0;
                y--;
            }
        }
        return target;
    }

    public void dispose(){
        this.background = null;
        this.foreground = null;
    }
}
