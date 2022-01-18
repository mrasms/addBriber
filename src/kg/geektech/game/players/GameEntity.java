package kg.geektech.game.players;

public abstract class GameEntity {
    private int health;
    private int damage;
    private int justicePoints;

    public int getJusticePoints() {
        return justicePoints;
    }

    public void setJusticePoints(int justicePoints) {
        this.justicePoints = justicePoints;
    }

    public GameEntity(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else
            this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
