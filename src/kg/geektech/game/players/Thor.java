package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage, Names name) {
        super(health, damage, SuperAbility.STUN_THE_BOSS, name);
    }
    private static int thorWillHit() {
        Random hit = new Random();
        boolean hitThor = hit.nextBoolean();
        if (hitThor) {
            return 1;
        } else return 0;
    }
    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        this.setJusticePoints(RPG_Game.random.nextInt(10)+2);
        if (this.getHealth() > 0 && (thorWillHit() == 1)){
                boss.setDamage(0);
            } else boss.setDamage(50);
        }
    }

