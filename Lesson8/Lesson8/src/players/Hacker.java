package players;

import game.RPG_Game;

public class Hacker extends Hero {

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.STEAL_HEALTH);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int stealAmount = RPG_Game.random.nextInt(11) + 1;
        int heroIndex = RPG_Game.random.nextInt(heroes.length);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[heroIndex].setHealth(heroes[heroIndex].getHealth() + stealAmount);
            }
        }
        System.out.println("Hacker " + this.getName() + " has healed " + heroes[heroIndex].getName() + " " + stealAmount);
    }
}
