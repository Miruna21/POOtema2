package game;

public final class Deflect implements Ability {
    private static final float BASEPERCENT = 0.35f;
    private static final float PLUSPERCENTPERLEVEL = 0.02f;

    private static final float ROGUEVICTIMMODIFIER = 0.2f;
    private static final float KNIGHTVICTIMMODIFIER = 0.4f;
    private static final float PYROMANCERVICTIMMODIFIER = 0.3f;
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = BASEPERCENT + rogue.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + ROGUEVICTIMMODIFIER * percent;
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * damage * landModifier);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {

    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = BASEPERCENT + knight.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + KNIGHTVICTIMMODIFIER * percent;
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * damage * landModifier);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = BASEPERCENT + pyromancer.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + PYROMANCERVICTIMMODIFIER * percent;
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * damage * landModifier);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
