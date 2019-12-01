package game;

public final class Fireblast implements Ability {
    private static final int BASE_DAMAGE = 350;
    private static final int PLUS_DAMAGE_PER_LEVEL = 50;

    private static final float ROGUE_VICTIM_MODIFIER = -0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = -0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.05f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASE_DAMAGE + attackerLevel * PLUS_DAMAGE_PER_LEVEL;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + ROGUE_VICTIM_MODIFIER));
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + WIZARD_VICTIM_MODIFIER));
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + KNIGHT_VICTIM_MODIFIER));
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + PYROMANCER_VICTIM_MODIFIER));
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
