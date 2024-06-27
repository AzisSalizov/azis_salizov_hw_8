package game;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int round = 0;

    public static void startGame() {
        Boss thanos = new Boss(1200, 50, "Thanos");

        Berserk captainAmerica = new Berserk(250, 15, "Captain America");
        Warrior ironMan = new Warrior(220, 15, "Iron man");
        Mag thor = new Mag(270, 13, "Thor");
        Medic drStrange = new Medic(200, 5, "DR Strange", 8);
        Medic wong = new Medic(200, 3, "Wong", 4);
        Hacker hacker = new Hacker(180, 3, "Hacker");

        Hero[] avengers = {captainAmerica, ironMan, thor, drStrange, wong, hacker};

        System.out.println("------------- Start game Assemble  -------------");
        printStatistics(thanos, avengers);

        while (!isGameOver(thanos, avengers)) {
            round(thanos, avengers);
        }
    }

    private static boolean isGameOver(Boss thanos, Hero[] heroes) {
        if (thanos.getHealth() <= 0) {
            boolean allHeroesDead = true;
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead) {
                System.out.println("It's a draw!!!");
                return true;
            } else {
                System.out.println("Avengers won!!!");
                return true;
            }
        }

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                return false;
            }
        }

        System.out.println("Thanos won!!!");
        return true;
    }

    private static void round(Boss thanos, Hero[] avengers) {
        round++;
        thanos.chooseDefence();
        System.out.println("-------------ROUND " + round + " -------------");
        thanos.attackBoss(avengers);

        for (Hero avenger : avengers) {
            if (avenger.getSuperAbilityEnum() != thanos.getDefence() && avenger.getHealth() > 0) {
                avenger.attackHero(thanos);
            }

            // Применяем суперспособности героев
            if (avenger instanceof Hacker) {
                if (round % 2 == 0) {
                    avenger.applySuperAbility(thanos, avengers);
                }
            } else if (avenger instanceof Mag) {
                avenger.applySuperAbility(thanos, avengers);
            } else {
                avenger.applySuperAbility(thanos, avengers);
            }
        }
        printStatistics(thanos, avengers);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
