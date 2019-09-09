package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int robotCount = 2;
        int iRobType;
        int fightCount = 4;

        //Create robots
        Robot[] robots = new Robot[robotCount];
        Integer[] winners = new Integer[robotCount];
        for (int rb = 1; rb <= robotCount; rb++) {
            Random r = new Random();
            iRobType = r.nextInt((RobotType.values().length - 1) + 1) + 1;
            robots[rb - 1] = new Robot("Soldier_" + rb, RobotType.get(iRobType));
            winners[rb - 1] = 0;
        }

        //Get robots info
        for (int rb = 1; rb <= robotCount; rb++) {
            System.out.println(robots[rb - 1].getName() + ": " + "Robot Type - " + robots[rb - 1].getType()+ "; Health - " + robots[rb - 1].health);
        }

        //FIGHT
        for (int a = 1; a <=fightCount; a++){
            boolean existWinner = false;
            int winner = -1;
            for (int s=0; s<robotCount; s++)
            {
                robots[s].restoreRobot();
                System.out.println(robots[s].getName() + " - " + robots[s].getType()+ " - " + robots[s].health);
            }

            do {
                for (int s=0; s<robotCount; s++)
                {
                    Random r = new Random();
                    int enemy = r.nextInt(robotCount);

                    if (robots[s].health > 0 && s!=enemy) {
                        robots[enemy].health = robots[enemy].health - robots[s].getPower();
                    }
                }

                int liveRobots = 0;
                for (int s=0; s<robotCount; s++)
                {
                    System.out.println("Robot " + (s+1) +" health = " + robots[s].health);
                    if (robots[s].health > 0) {
                        liveRobots++;
                        winner = s;
                    }
                }

                if (liveRobots < 2) {
                    existWinner = true;
                    winners[winner] = winners[winner]++;
                    System.out.println("Winner round " + (a+1) + " is " + robots[winners[winner]].getName());
                }
                System.out.println("Count of live robots = " + liveRobots);

            } while (existWinner == false);

        }
        //Fight ended
        int maxIndex = 0;
        for (int s=0; s<robotCount; s++)
        {
            if (winners[s] > maxIndex){
                maxIndex = winners[s];
            }
        }

        System.out.println("Winner total is " + robots[maxIndex].getName());



    }

    public static void fight (int robotCount){

    }

};