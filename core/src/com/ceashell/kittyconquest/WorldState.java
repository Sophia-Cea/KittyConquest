package com.ceashell.kittyconquest;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ceashell.kittyconquest.world.World;

import java.util.Arrays;

public class WorldState extends State {
    public SpriteBatch batch;
    World world;
    public WorldState() {
        batch = new SpriteBatch();
        world = new World(5,5);
        int[] fg = {
                0,0,-1,-1,0,
                -1,-1,0,0,0,
                0,-1,1,1,0,
                -1,-1,0,0,0,
                -1,0,0,0,0,
        };

        int[] bg = new int[25];
        Arrays.fill(bg, -1);

        world.init(bg, fg);

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {

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
