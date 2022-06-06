package com.ceashell.kittyconquest.world.entities;

import com.ceashell.kittyconquest.Animation;
import com.ceashell.kittyconquest.AssetManager;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;

public class WorldPlayer extends Entity {
    public WorldPlayer(Point position) {
        super(position, TileType.PLAYER);
    }

    @Override
    public void createAnimations() {

        AssetManager am = AssetManager.getInstance();
        Animation idleAnimation = new Animation(am.get("rock01"), 2, 0.5f);
        this.animations.put("idle", idleAnimation);

        Animation walkingAnimation = new Animation(am.get("wave"), 3, 0.75f);
        this.animations.put("walking", walkingAnimation);

        this.currentAnimation = this.animations.get("idle");
    }




}
