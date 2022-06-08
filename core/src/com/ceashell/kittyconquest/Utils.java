package com.ceashell.kittyconquest;

import com.ceashell.kittyconquest.states.GameStateManager;

public class Utils {

    public static GameStateManager GSM;
    public static AssetManager assetManager;

    public void init(){
        GSM = new GameStateManager();
        assetManager = new AssetManager();

    }

    public void dispose(){
        GSM.dispose();
        assetManager.dispose();
    }

}
