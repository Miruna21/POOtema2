package game;

public final class Execute implements Ability {
    private static final float PERCENT = 0.2f;
    private static final int BASEDAMAGE = 200;
    private static final int PLUSDAMAGEPERLEVEL = 30;

    private static final float ROGUEVICTIMMODIFIER = 0.15f;
    private static final float KNIGHTVICTIMMODIFIER = 0;
    private static final float PYROMANCERVICTIMMODIFIER = 0.1f;
    private static final float WIZARDVICTIMMODIFIER = -0.2f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASEDAMAGE + attackerLevel * PLUSDAMAGEPERLEVEL;
        return levelDamage * landModifier;
    }

    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        int maxVictimHpOnHerLevel = rogue.getInitialHp() + rogue.getLevel()
                * rogue.getPlusHpPerLevel();
        float hpLimit = PERCENT * maxVictimHpOnHerLevel + rogue.getLevel();
        if (rogue.getHp() < hpLimit) {
            rogue.setDamageWithoutRaceModifier(rogue.getHp());
            rogue.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                    * (1 + ROGUEVICTIMMODIFIER));
            // modificare hp
            rogue.subHp(finalDamage);
        }
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        int maxVictimHpOnHerLevel = wizard.getInitialHp() + wizard.getLevel()
                * wizard.getPlusHpPerLevel();
        float hpLimit = PERCENT * maxVictimHpOnHerLevel + wizard.getLevel();
        if (wizard.getHp() < hpLimit) {
            wizard.setDamageWithoutRaceModifier(wizard.getHp());
            wizard.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                    * (1 + WIZARDVICTIMMODIFIER));
            // modificare hp
            wizard.subHp(finalDamage);
        }
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        int maxVictimHpOnHerLevel = knight.getInitialHp() + knight.getLevel()
                * knight.getPlusHpPerLevel();
        float hpLimit = PERCENT * maxVictimHpOnHerLevel + knight.getLevel();
        if (knight.getHp() < hpLimit) {
            knight.setDamageWithoutRaceModifier(knight.getHp());
            knight.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                    * (1 + KNIGHTVICTIMMODIFIER));
            // modificare hp
            knight.subHp(finalDamage);
        }
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        int maxVictimHpOnHerLevel = pyromancer.getInitialHp() + pyromancer.getLevel()
                * pyromancer.getPlusHpPerLevel();
        float hpLimit = PERCENT * maxVictimHpOnHerLevel + pyromancer.getLevel();
        if (pyromancer.getHp() < hpLimit) {
            pyromancer.setDamageWithoutRaceModifier(pyromancer.getHp());
            pyromancer.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                    * (1 + PYROMANCERVICTIMMODIFIER));
            // modificare hp
            pyromancer.subHp(finalDamage);
        }
    }
}
