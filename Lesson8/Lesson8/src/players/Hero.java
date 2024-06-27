package players;

public abstract class Hero extends GameEntity implements HavingSuperAbility{

    private SuperAbilityEnum superAbilityEnum;

    public Hero(int health, int damage, String name, SuperAbilityEnum superAbilityEnum) {
        super(health, damage, name);
        this.superAbilityEnum = superAbilityEnum;
    }

    public SuperAbilityEnum getSuperAbilityEnum() {
        return superAbilityEnum;
    }

    public void attackHero(Boss boss){
        boss.setHealth(boss.getHealth() - this.getDamage());
    }

    @Override
    public String toString() {
        return "Avengers " + super.toString();
    }
}
