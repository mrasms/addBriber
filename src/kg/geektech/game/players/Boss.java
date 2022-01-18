package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Boss extends GameEntity {
    public Boss(int health, int damage) {
        super(health, damage);
        this.setJusticePoints(RPG_Game.random.nextInt(10)+2);

    }
}
