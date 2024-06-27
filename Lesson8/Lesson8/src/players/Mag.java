package players;

import game.RPG_Game;

public class Mag extends Hero {

    public Mag(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int boostAmount = RPG_Game.random.nextInt(3) + 1;
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + boostAmount);
            System.out.println("Mag " + this.getName() + " boosted " + heroes[i].getName() + " " + boostAmount + " damage");
        }
    }
}
