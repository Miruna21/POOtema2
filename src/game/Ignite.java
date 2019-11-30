package game;

public final class Ignite implements Ability {
    private static final int BASEDAMAGE = 150;
    private static final int PLUSDAMAGEPERLEVEL1 = 20;
    private static final int OTHERDAMAGE = 50;
    private static final int PLUSDAMAGEPERLEVEL2 = 30;
    private static final float ROGUEVICTIMMODIFIER = -0.2f;
    private static final float KNIGHTVICTIMMODIFIER = 0.2f;
    private static final float PYROMANCERVICTIMMODIFIER = -0.1f;
    private static final float WIZARDVICTIMMODIFIER = 0.05f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage;
        levelDamage = BASEDAMAGE + attackerLevel * PLUSDAMAGEPERLEVEL1;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + ROGUEVICTIMMODIFIER));
        int overtimeDamage = Math.round((OTHERDAMAGE + attacker.getLevel()
                * PLUSDAMAGEPERLEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + ROGUEVICTIMMODIFIER));
        rogue.setNrRoundsIgniteHit(2);
        rogue.setOvertimeDamage(overtimeDamage);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARDVICTIMMODIFIER));
        int overtimeDamage = Math.round((OTHERDAMAGE + attacker.getLevel()
                * PLUSDAMAGEPERLEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + WIZARDVICTIMMODIFIER));
        wizard.setNrRoundsIgniteHit(2);
        wizard.setOvertimeDamage(overtimeDamage);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHTVICTIMMODIFIER));
        int overtimeDamage = Math.round((OTHERDAMAGE + attacker.getLevel()
                * PLUSDAMAGEPERLEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + KNIGHTVICTIMMODIFIER));
        knight.setNrRoundsIgniteHit(2);
        knight.setOvertimeDamage(overtimeDamage);
        // modificare hp
        knight.subHp(finalDamage);

    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCERVICTIMMODIFIER));
        int overtimeDamage = Math.round((OTHERDAMAGE + attacker.getLevel()
                * PLUSDAMAGEPERLEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + PYROMANCERVICTIMMODIFIER));
        pyromancer.setNrRoundsIgniteHit(2);
        pyromancer.setOvertimeDamage(overtimeDamage);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
