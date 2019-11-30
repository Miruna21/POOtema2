package game;

public final class Drain implements Ability {
    private static final float MULTIPLIER = 0.3f;
    private static final float BASEPERCENT = 0.2f;
    private static final float PLUSPERCENTPERLEVEL = 0.05f;

    private static final float ROGUEVICTIMMODIFIER = -0.2f;
    private static final float KNIGHTVICTIMMODIFIER = 0.2f;
    private static final float PYROMANCERVICTIMMODIFIER = -0.1f;
    private static final float WIZARDVICTIMMODIFIER = 0.05f;
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float percent = BASEPERCENT + rogue.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + ROGUEVICTIMMODIFIER * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = rogue.getInitialHp() + rogue.getLevel()
                * rogue.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = rogue.getHp();
        if (a < b) {
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float percent = BASEPERCENT + wizard.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + WIZARDVICTIMMODIFIER * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = wizard.getInitialHp() + wizard.getLevel()
                * wizard.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = wizard.getHp();
        if (a < b) {
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float percent = BASEPERCENT + knight.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + KNIGHTVICTIMMODIFIER * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = knight.getInitialHp() + knight.getLevel()
                * knight.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = knight.getHp();
        if (a < b) {
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float percent = BASEPERCENT + pyromancer.getLevel() * PLUSPERCENTPERLEVEL;
        float newPercent = percent + PYROMANCERVICTIMMODIFIER * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = pyromancer.getInitialHp() + pyromancer.getLevel()
                * pyromancer.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = pyromancer.getHp();
        if (a < b) {
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
