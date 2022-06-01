package com.ceashell.kittyconquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ceashell.kittyconquest.world.World;
import com.ceashell.kittyconquest.world.tiles.Player;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;
import java.util.Arrays;

public class WorldState extends State {
    public SpriteBatch batch;
    World world;
    Player player;

    public WorldState() {
        batch = new SpriteBatch();
        world = new World(5,5);
        int[] fg = {
                1,1,-1,-1,1,
                -1,-1,1,1,1,
                1,-1,1,1,1,
                -1,-1,1,1,1,
                -1,1,1,1,1,
        };

        int[] bg = new int[25];
        Arrays.fill(bg, 0);

        world.init(bg, fg);
        player = new Player(new Point(2,2), AssetManager.getInstance().get(TileType.PLAYER.assetName), world);


    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            player.move(0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            player.move(1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            player.move(2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            player.move(3);
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        world.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        world.dispose();

    }
}
