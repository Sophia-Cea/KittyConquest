package com.ceashell.kittyconquest.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.tiles.*;

import java.awt.*;


public class World {
    public static final float TILE_SIZE = 100f;
    // might remove separation of background and foreground: might just make it an ArrayList.
    // Though if I do that, it'll be hard to have that effect with the hiding behind trees you were talking about that you want.
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

    public void init(int[] bg, int[] fg) {
        background = initTiles(bg);
        foreground = initTiles(fg);
    }

//    TODO : Use camera
    public void draw(SpriteBatch batch){
        drawArray(background, batch);
        drawArray(foreground, batch);
    }

    public boolean isInBounds(int x, int y){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public boolean isInBounds(Point p){
        return p.x >= 0 && p.x < width && p.y >= 0 && p.y < height;
    }

    public boolean setForegroundTile(Tile tile, int x, int y){
        return setTile(foreground, tile, x, y);
    }

    public boolean setBackgroundTile(Tile tile, int x, int y){
        return setTile(background, tile, x, y);
    }

    private boolean setTile(Tile[][] target, Tile tile, int x, int y) {
        if(isInBounds(x, y)) {
            if (tile != null) tile.setPosition(new Point(x, y));
            target[y][x] = tile;
            return true;
        }
        return false;
    }

    public Tile getForegroundTile(int x, int y){
        if(isInBounds(x, y)) return foreground[y][x];
        return null;
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

    private Tile[][] initTiles(int[] source) {
        assert source.length == this.width * this.height; // make sure they're the same size
        Tile[][] target = new Tile[height][width];


        int x = 0;
        int y = height-1;
        for (int type : source) {
            if (type > -1) { // type<=-1 -> no tile there
                TileType tileType = TileType.FromOrdinal(type);
                Tile tile = TileFactory.create(tileType, new Point(x, y));
                setTile(target, tile, x, y);
            }
            x++;
            if (x == width) {
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
