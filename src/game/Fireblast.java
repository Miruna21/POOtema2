package game;

public final class Fireblast implements Ability {
    private static final int BASEDAMAGE = 350;
    private static final int PLUSDAMAGEPERLEVEL = 50;

    private static final float ROGUEVICTIMMODIFIER = -0.2f;
    private static final float KNIGHTVICTIMMODIFIER = 0.2f;
    private static final float PYROMANCERVICTIMMODIFIER = -0.1f;
    private static final float WIZARDVICTIMMODIFIER = 0.05f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASEDAMAGE + attackerLevel * PLUSDAMAGEPERLEVEL;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier* (1 + ROGUEVICTIMMODIFIER));
        System.out.println("FIREBLAST DMG: " + finalDamage);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + WIZARDVICTIMMODIFIER));
        System.out.println("FIREBLAST DMG: " + finalDamage);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + KNIGHTVICTIMMODIFIER));
        System.out.println("FIREBLAST DMG: " + finalDamage);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier * (1 + PYROMANCERVICTIMMODIFIER));
        System.out.println("FIREBLAST DMG: " + finalDamage);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
