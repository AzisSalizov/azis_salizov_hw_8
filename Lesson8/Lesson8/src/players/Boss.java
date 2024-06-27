package players;

import game.RPG_Game;

public class Boss extends GameEntity {

    private SuperAbilityEnum defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbilityEnum getDefence() {
        return defence;
    }

    public void chooseDefence() {
        SuperAbilityEnum[] variants = SuperAbilityEnum.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public void attackBoss(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0) {
                continue;
            }
            if (heroes[i] instanceof Berserk) {
                int randomDamage = RPG_Game.random.nextInt(10) + 1;
                ((Berserk) heroes[i]).setBlockedDamage(randomDamage);
                heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                System.out.println(heroes[i].getHealth() + " " + this.getDamage() + " " + ((Berserk) heroes[i]).getBlockedDamage());
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " Defence = " + this.defence;
    }
}
