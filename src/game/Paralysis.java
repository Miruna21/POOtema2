package game;

public final class Paralysis implements Ability {
    private static final int BASEDAMAGE = 40;
    private static final int PLUSHPPERLEVEL = 10;

    private static final float ROGUEVICTIMMODIFIER = -0.1f;
    private static final float KNIGHTVICTIMMODIFIER = -0.2f;
    private static final float PYROMANCERVICTIMMODIFIER = 0.2f;
    private static final float WIZARDVICTIMMODIFIER = 0.25f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASEDAMAGE + attackerLevel * PLUSHPPERLEVEL;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + ROGUEVICTIMMODIFIER));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        rogue.setNrRoundsParalyzed(nrRoundsParalyzed);
        rogue.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        rogue.setMovPermission(true);
        rogue.setNrRoundsIgniteHit(0);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARDVICTIMMODIFIER));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        wizard.setNrRoundsParalyzed(nrRoundsParalyzed);
        wizard.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        wizard.setMovPermission(true);
        wizard.setNrRoundsIgniteHit(0);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHTVICTIMMODIFIER));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        knight.setNrRoundsParalyzed(nrRoundsParalyzed);
        knight.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        knight.setMovPermission(true);
        knight.setNrRoundsIgniteHit(0);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCERVICTIMMODIFIER));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        pyromancer.setNrRoundsParalyzed(nrRoundsParalyzed);
        pyromancer.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        pyromancer.setMovPermission(true);
        pyromancer.setNrRoundsIgniteHit(0);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
