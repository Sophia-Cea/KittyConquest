package com.ceashell.kittyconquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.World;
import com.ceashell.kittyconquest.world.entities.states.*;
import com.ceashell.kittyconquest.world.entities.WorldPlayer;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WorldState extends State {
    public SpriteBatch batch;
    private GameCamera camera;
    private final FitViewport viewport;
    World world;
    WorldPlayer overworldPlayer;

    public WorldState() {
        batch = new SpriteBatch();
        world = new World(10,10);
        int[] fg = {
                -1,-1,2,-1,-1,-1,-1,2,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                1,-1,-1,-1,-1,1,-1,-1,-1,-1,
                -1,-1,2,-1,-1,-1,-1,2,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                1,-1,-1,-1,-1,1,-1,-1,-1,-1,
        };

        int[] bg = new int[100];
        Arrays.fill(bg, 0);

        world.init(bg, fg);
        camera = new GameCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();

        overworldPlayer = new WorldPlayer(new Point(2,2));
        HashMap<String, StateGenerator> playerStates = new HashMap<>();
        playerStates.put("idle", () -> new PlayerIdleState(overworldPlayer));
        playerStates.put("walking", () -> new EntityWalkingState(overworldPlayer, world));
        overworldPlayer.stateMachine = new StateMachine(playerStates);
        overworldPlayer.stateMachine.change("idle");

        world.setForegroundTile(overworldPlayer, 2, 2);
        camera.follow(overworldPlayer.sprite);

    }

    @Override
    public void update(float delta) {
        world.update(delta);
        camera.update();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            System.out.println("overworldPlayer = " + overworldPlayer.getPosition());
            System.out.println("overworldPlayer sprite x = " + overworldPlayer.sprite.getX());
            System.out.println("overworldPlayer sprite y = " + overworldPlayer.sprite.getY());
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
//        viewport.apply(true);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        world.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        world.dispose();

    }
}
