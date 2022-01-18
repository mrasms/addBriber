package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class CorruptOfficial extends Hero {
    public CorruptOfficial(int health, int damage, Names name) {
        super(health, damage, SuperAbility.BRIBE, name);
    }


    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        this.setCorruptionPoints(RPG_Game.random.nextInt(10)+2);
        for (int i = 0; i < heroes.length ; i++) {

            if (this.getCorruptionPoints() >= heroes[i].getCorruptionPoints() && this.getCorruptionPoints() >= boss.getCorruptionPoints()) {
            this.setHealth(this.getHealth()+ heroes[i].getCorruptionPoints()/10);
            heroes[i].setHealth(heroes[i].getHealth()-(getCorruptionPoints()/2));
            this.setDamage(this.getDamage()+ 1);
            }
            else if (heroes[i].getCorruptionPoints()>this.getCorruptionPoints() && heroes[i].getCorruptionPoints()>= boss.getCorruptionPoints()){
                heroes[i].setHealth(heroes[i].getHealth() + (boss.getCorruptionPoints()/2));
                this.setHealth(this.getHealth() + (heroes[i].getCorruptionPoints()/4));
                boss.setHealth(boss.getHealth() - (boss.getCorruptionPoints()/2));
            }
            else if (boss.getCorruptionPoints()>=heroes[i].getCorruptionPoints() && boss.getCorruptionPoints()> this.getCorruptionPoints()){
                heroes[i].setHealth(heroes[i].getHealth() - (boss.getCorruptionPoints() - heroes[i].getCorruptionPoints()));
                boss.setDamage(boss.getDamage()+(heroes[i].getCorruptionPoints()/2));
                this.setHealth(this.getHealth() + ((boss.getCorruptionPoints()+heroes[i].getCorruptionPoints())/10));
            }
        }

    }
}

