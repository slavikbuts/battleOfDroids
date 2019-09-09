package com.company;

import java.util.Random;

import static com.company.RobotType.*;

public class Robot {
    private String name;
    public int health;
    private int weapon;
    private RobotType rType;
    private int armor;
    private int accuracy;
    public int power;

    public Robot(String name, RobotType rType ) {
        this.name = name;
        this.health = 1;
        this.weapon = 1;
        this.rType = rType;
        this.armor = 1;
        switch (rType){
            case Droid:
                this.health= Droid.getHealth();
                this.weapon= Droid.getWeapon();
                this.weapon= Droid.getArmor();
                this.power= Droid.getPower();
                break;
            case Tower:
                this.health= Tower.getHealth();
                this.weapon= Tower.getWeapon();
                this.weapon= Tower.getArmor();
                this.power= Tower.getPower();
                break;
            case Tank:
                this.health= Tank.getHealth();
                this.weapon= Tank.getWeapon();
                this.weapon= Tank.getArmor();
                this.power= Tank.getPower();
                break;
        }

        Random r = new Random();
        this.accuracy = r.nextInt((80 - 20));
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return rType.getName();
    }

    public int getPower() {
        return rType.getPower();
    }

    public void restoreRobot(){
        this.health= Droid.getHealth();
    }
}
