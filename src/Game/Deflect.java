package Game;

public class Deflect implements Ability{
    private final static float basePercent = 0.35f;
    private final static float plusPercentPerLevel = 0.02f;

    private final static float RogueVictimModifier = 0.2f;
    private final static float KnightVictimModifier = 0.4f;
    private final static float PyromancerVictimModifier = 0.3f;
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damage = rogue.getDamageWithoutRaceModifier();
        float percent = basePercent + rogue.getLevel() * plusPercentPerLevel;
        float newPercent = percent + RogueVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        rogue.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, rogue);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {

    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damage = knight.getDamageWithoutRaceModifier();
        float percent = basePercent + knight.getLevel() * plusPercentPerLevel;
        float newPercent = percent + KnightVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        knight.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, knight);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damage = pyromancer.getDamageWithoutRaceModifier();
        float percent = basePercent + pyromancer.getLevel() * plusPercentPerLevel;
        float newPercent = percent + PyromancerVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        pyromancer.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, pyromancer);
    }
    public void verifyVictimDead(Player attacker, Player victim){
        if (!victim.getLife()){
            int max;
            int a = 0;
            int b = 200 - (attacker.getLevel() - victim.getLevel()) * 40;
            int xpWinner = attacker.getXp();
            int newXpWinner;
            if (a > b){
                max = a;
            } else {
                max = b;
            }
            newXpWinner = xpWinner + max;
            attacker.gainXp(newXpWinner, attacker.getInitialHp(), attacker.getPlusHpPerLevel());
        }
    }
}
