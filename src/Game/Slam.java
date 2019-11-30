package Game;

public class Slam implements Ability{
    private final static int baseDamage = 100;
    private final static int plusDamagePerLevel = 40;

    private final static float RogueVictimModifier = -0.2f;
    private final static float KnightVictimModifier = 0.2f;
    private final static float PyromancerVictimModifier = -0.1f;
    private final static float WizardVictimModifier = 0.05f;

    private float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = baseDamage + attackerLevel * plusDamagePerLevel;
        //System.out.println(landModifier + " " + attackerLevel + " " + levelDamage);
        return levelDamage * landModifier;
    }
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
        // modificare hp
        rogue.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        rogue.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        rogue.setNrRoundParalyzed(0);
        rogue.setOvertimeDamage(0);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        //System.out.println(wizard.getDamageWithoutRaceModifier());
        //System.out.println("slam");
        wizard.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        //System.out.println(wizard.getDamageWithoutRaceModifier());
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
        // modificare hp
        //System.out.println(finalDamage);
        wizard.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        wizard.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        wizard.setNrRoundParalyzed(0);
        wizard.setOvertimeDamage(0);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
        // modificare hp
        knight.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        knight.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        knight.setNrRoundParalyzed(0);
        knight.setOvertimeDamage(0);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
        // modificare hp
        pyromancer.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        pyromancer.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        pyromancer.setNrRoundParalyzed(0);
        pyromancer.setOvertimeDamage(0);
    }
}
