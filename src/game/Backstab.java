package game;

public final class Backstab implements Ability {
    private static final int BASEDAMAGE = 200;
    private static final int PLUSHPPERLEVEL = 20;

    private static final float ROGUEVICTIMMODIFIER = 0.2f;
    private static final float KNIGHTVICTIMMODIFIER = -0.1f;
    private static final float PYROMANCERVICTIMMODIFIER = 0.25f;
    private static final float WIZARDVICTIMMODIFIER = 0.25f;
    private static final float CRITICALHITVALUE = 1.5f;
    private static final float NOCRITICALHITVALUE = 1f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASEDAMAGE + attackerLevel * PLUSHPPERLEVEL;
        float criticalHit;
        // critical hit o data la 3 lovituri daca se afla pe Woods
        if ((attacker.getNrBackstabHit() % 3 == 0) && (ground instanceof Woods)) {
            criticalHit = CRITICALHITVALUE;
        } else {
            criticalHit = NOCRITICALHITVALUE;
        }
        attacker.addNrBackstabHit(1);
        return levelDamage * criticalHit * landModifier;
    }

    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + ROGUEVICTIMMODIFIER));
        // modificare hp
        System.out.println("Backstab dmg: " + finalDamage);
        rogue.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARDVICTIMMODIFIER));
        // modificare hp
        System.out.println("Backstab dmg: " + finalDamage);
        wizard.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHTVICTIMMODIFIER));
        // modificare hp
        System.out.println("Backstab dmg: " + finalDamage);
        knight.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCERVICTIMMODIFIER));
        // modificare hp
        System.out.println("Backstab dmg: " + finalDamage);
        pyromancer.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }
}
