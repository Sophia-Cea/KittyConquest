package com.ceashell.kittyconquest.player;

public interface EntityState {

    void enter();
    void exit();

    EntityState update(float delta);
    EntityState handleInput();

}
