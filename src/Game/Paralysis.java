package Game;

public class Paralysis implements Ability{
    private final static int baseDamage = 40;
    private final static int plusDamagePerLevel = 10;

    private final static float RogueVictimModifier = -0.1f;
    private final static float KnightVictimModifier = -0.2f;
    private final static float PyromancerVictimModifier = 0.2f;
    private final static float WizardVictimModifier = 0.25f;

    private float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = baseDamage + attackerLevel * plusDamagePerLevel;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        rogue.setNrRoundsParalyzed(nrRoundsParalyzed);
        rogue.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        rogue.setMovPermission(true);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        wizard.setNrRoundsParalyzed(nrRoundsParalyzed);
        wizard.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        wizard.setMovPermission(true);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        knight.setNrRoundsParalyzed(nrRoundsParalyzed);
        knight.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        knight.setMovPermission(true);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        //System.out.println(finalDamage);
        pyromancer.setNrRoundsParalyzed(nrRoundsParalyzed);
        pyromancer.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        pyromancer.setMovPermission(true);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
