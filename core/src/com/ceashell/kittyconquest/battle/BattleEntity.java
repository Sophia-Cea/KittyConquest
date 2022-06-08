package com.ceashell.kittyconquest.battle;

public class BattleEntity {
    // needs attacks, health, stats (speed, strength, )
    int health;
    int speed;
    int strength;

    public BattleEntity(int health, int speed, int strength) {
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }

    public void incrementHealth(int amount) {
        health += amount;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }



}
