package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Judge extends Hero {
    public Judge(int health, int damage, Names name) {
        super(health, damage, SuperAbility.ADJUDICATION, name);
    }


    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        this.setJusticePoints(RPG_Game.random.nextInt(10)+2);
        if (this.getHealth()>0) {
            for (int i = 0; i < heroes.length; i++) {
                if (this.getJusticePoints() >= heroes[i].getJusticePoints() && this.getJusticePoints() >= boss.getJusticePoints()) {
                    this.setHealth(this.getHealth() + heroes[i].getJusticePoints() / 10);
                    heroes[i].setHealth(heroes[i].getHealth() - (heroes[i].getJusticePoints() / 2));
                    this.setDamage(this.getDamage() + 1);
                }
                else if (heroes[i].getJusticePoints() > this.getJusticePoints() && heroes[i].getJusticePoints() >= boss.getJusticePoints()) {
                    heroes[i].setHealth(heroes[i].getHealth() + (boss.getJusticePoints() / 2));
                    this.setHealth(this.getHealth() + (heroes[i].getJusticePoints() / 4));
                    boss.setHealth(boss.getHealth() - (boss.getJusticePoints() / 2));
                }
                else if (boss.getJusticePoints() >= heroes[i].getJusticePoints() && boss.getJusticePoints() > this.getJusticePoints()) {
                    heroes[i].setHealth(heroes[i].getHealth() - (boss.getJusticePoints() - heroes[i].getJusticePoints()));
                    boss.setDamage(boss.getDamage() + (heroes[i].getJusticePoints() / 2));
                    boss.setHealth(boss.getHealth() + 20);
                    this.setHealth(this.getHealth() + ((boss.getJusticePoints() + heroes[i].getJusticePoints()) / 4));
                }
                else this.setHealth(this.getHealth() - 10);
            }
        }

    }
}

