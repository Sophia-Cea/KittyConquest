package com.ceashell.kittyconquest.world.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.ceashell.kittyconquest.Animation;
import com.ceashell.kittyconquest.world.Tile;

import java.awt.*;

public class AnimatedTile extends Tile {
    private Animation animation;
    protected AnimatedTile(Point position, TileType type, Animation animation) {
        super(position, type, animation.getFrame());
        this.animation = animation;
    }

    @Override
    public void update(float delta){
        animation.update(delta);
        this.sprite.setRegion(animation.getFrame());
    }
}
