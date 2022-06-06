package com.ceashell.kittyconquest.battle;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class BattlePlayer {

    private int xp;
    private int level;
    private float hp;
    private float maxHP;
    private Sprite sprite;

    public BattlePlayer(TextureRegion textureRegion){
        this.sprite = new Sprite(textureRegion);
    }
}
