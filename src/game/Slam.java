package game;

public final class Slam implements Ability {
    private static final int BASEDAMAGE = 100;
    private static final int PLUSHPPERLEVEL = 40;

    private static final float ROGUEVICTIMMODIFIER = -0.2f;
    private static final float KNIGHTVICTIMMODIFIER = 0.2f;
    private static final float PYROMANCERVICTIMMODIFIER = -0.1f;
    private static final float WIZARDVICTIMMODIFIER = 0.05f;

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
        // modificare hp
        rogue.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        rogue.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        rogue.setNrRoundsParalyzed(0);
        rogue.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARDVICTIMMODIFIER));
        // modificare hp
        wizard.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        wizard.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        wizard.setNrRoundsParalyzed(0);
        wizard.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHTVICTIMMODIFIER));
        // modificare hp
        knight.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        knight.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        knight.setNrRoundsParalyzed(0);
        knight.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCERVICTIMMODIFIER));
        // modificare hp
        pyromancer.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        pyromancer.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        pyromancer.setNrRoundsParalyzed(0);
        pyromancer.setNrRoundsIgniteHit(0);
    }
}
