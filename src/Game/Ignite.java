package Game;

public class Ignite implements Ability{
    private final static int baseDamage = 150;
    private final static int plusDamagePerLevel1 = 20;
    private final static int otherDamage = 50;
    private final static int plusDamagePerLevel2 = 30;
    private final static float RogueVictimModifier = -0.2f;
    private final static float KnightVictimModifier = 0.2f;
    private final static float PyromancerVictimModifier = -0.1f;
    private final static float WizardVictimModifier = 0.05f;

    private float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage;
        levelDamage = baseDamage + attackerLevel * plusDamagePerLevel1;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
        int overtimeDamage = Math.round((otherDamage + attacker.getLevel() * plusDamagePerLevel2) *
                attacker.acceptLandModifier(ground) * (1 + RogueVictimModifier));
        rogue.setNrRoundsIgniteHit(2);
        rogue.setOvertimeDamage(overtimeDamage);
        // modificare hp
        //System.out.println(finalDamage);
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
        int overtimeDamage = Math.round((otherDamage + attacker.getLevel() * plusDamagePerLevel2) *
                attacker.acceptLandModifier(ground) * (1 + WizardVictimModifier));
        System.out.println("ignite " + Math.round(damageWithoutRaceModifier));
        wizard.setNrRoundsIgniteHit(2);
        wizard.setOvertimeDamage(overtimeDamage);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
        int overtimeDamage = Math.round((otherDamage + attacker.getLevel() * plusDamagePerLevel2) *
                attacker.acceptLandModifier(ground) * (1 + KnightVictimModifier));
        knight.setNrRoundsIgniteHit(2);
        knight.setOvertimeDamage(overtimeDamage);
        // modificare hp
        knight.subHp(finalDamage);

    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
        int overtimeDamage = Math.round((otherDamage + attacker.getLevel() * plusDamagePerLevel2) *
                attacker.acceptLandModifier(ground) * (1 + PyromancerVictimModifier));
        pyromancer.setNrRoundsIgniteHit(2);
        pyromancer.setOvertimeDamage(overtimeDamage);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
