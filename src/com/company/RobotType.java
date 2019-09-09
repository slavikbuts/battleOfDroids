package com.company;

import java.util.HashMap;
import java.util.Map;

public enum RobotType {
    Droid ("Droid", 1, 100, 5, 10, 20), // name, number, health, weapon, armor, power
    Tank("Tank", 2, 100, 8, 15, 30),
    Tower("Tower", 3, 100, 6, 8, 40);

    private final String name;
    private final int number;
    private final int health;
    private final int weapon;
    private final int armor;
    private final int power;

    public static final Map<Integer, RobotType> lookup = new HashMap<Integer, RobotType>();

    static {
        for (RobotType d : RobotType.values()) {
            lookup.put(d.getNumber(), d);
        }
    }

    private RobotType(String name, int number, int health, int weapon, int armor, int power) {
        this.name = name;
        this.number = number;
        this.health = health;
        this.weapon = weapon;
        this.armor = armor;
        this.power = power;

    }

    public static RobotType get(int number) {
        return lookup.get(number);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getHealth() {
        return health;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getArmor() {
        return armor;
    }

    public int getPower() {
        return power;
    }

}
