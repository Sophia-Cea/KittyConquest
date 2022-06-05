package com.ceashell.kittyconquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ceashell.kittyconquest.world.Tile;
import com.ceashell.kittyconquest.world.World;
import com.ceashell.kittyconquest.world.tiles.Player;
import com.ceashell.kittyconquest.world.tiles.TileType;

import java.awt.*;
import java.util.Arrays;

public class WorldState extends State {
    public SpriteBatch batch;
    private GameCamera camera;
    World world;
    Player player;

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
        player = new Player(new Point(2,2), AssetManager.getInstance().get(TileType.PLAYER.assetName), world);
        camera = new GameCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void update(float delta) {
        camera.setPosition(player.getPosition());
        world.update(delta);
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Tile brick = world.getForegroundTile(1, 2);
            Tile brick1 = world.getForegroundTile(3, 2);
            System.out.println("brick.sprite.getX()= " + brick.sprite.getX() + "y: " + brick.sprite.getY());
            System.out.println("brick1.sprite.getX()= " + brick1.sprite.getX() + "y: " + brick1.sprite.getY());
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.setProjectionMatrix(camera.combined);
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
