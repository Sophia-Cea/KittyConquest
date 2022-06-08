package com.ceashell.kittyconquest.player;

import com.badlogic.gdx.utils.Timer;

public class PlayerState2 implements EntityState{

    boolean shouldReturn;
    @Override
    public void enter() {
        Player.getInstance().setAnimation("test1");
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                shouldReturn = true;
            }
        }, 5);
    }

    @Override
    public void exit() {

    }

    @Override
    public EntityState update(float delta) {
        Player.getInstance().sprite.setPosition(500, 300);
        if(shouldReturn){
            return new PlayerState1();
        }
        return null;
    }

    @Override
    public EntityState handleInput() {
        return null;
    }
}
