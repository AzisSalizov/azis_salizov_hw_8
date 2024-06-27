package players;

import game.RPG_Game;

public class Warrior extends Hero{

    public Warrior(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * coefficient);
        System.out.println("Warrior " + this.getName() + " applySuperAbility " +
                this.getDamage() * coefficient);
    }
}
