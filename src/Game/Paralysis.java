package Game;

public class Paralysis implements Ability{
    private final static int baseDamage = 40;
    private final static int plusDamagePerLevel = 10;

    private final static float RogueVictimModifier = -0.1f;
    private final static float KnightVictimModifier = -0.2f;
    private final static float PyromancerVictimModifier = 0.2f;
    private final static float WizardVictimModifier = 0.25f;
    public float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = baseDamage + attackerLevel * plusDamagePerLevel;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
        int nrRoundsParalyzed;
        if (ground instanceof Woods){
            nrRoundsParalyzed = 6;
        } else {
            nrRoundsParalyzed = 3;
        }
        rogue.setNrRoundParalyzed(nrRoundsParalyzed);
        rogue.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        rogue.setMovPermission(true);
        // modificare hp
        rogue.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, rogue);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
        int nrRoundsParalyzed;
        if (ground instanceof Woods){
            nrRoundsParalyzed = 6;
        } else {
            nrRoundsParalyzed = 3;
        }
        wizard.setNrRoundParalyzed(nrRoundsParalyzed);
        wizard.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        wizard.setMovPermission(true);
        // modificare hp
        wizard.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, wizard);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
        int nrRoundsParalyzed;
        if (ground instanceof Woods){
            nrRoundsParalyzed = 6;
        } else {
            nrRoundsParalyzed = 3;
        }
        knight.setNrRoundParalyzed(nrRoundsParalyzed);
        knight.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        knight.setMovPermission(true);
        // modificare hp
        knight.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, knight);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
        int nrRoundsParalyzed;
        if (ground instanceof Woods){
            nrRoundsParalyzed = 6;
        } else {
            nrRoundsParalyzed = 3;
        }
        pyromancer.setNrRoundParalyzed(nrRoundsParalyzed);
        pyromancer.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        pyromancer.setMovPermission(true);
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
