package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Backstab implements Ability {
    private static final int BASE_DAMAGE = 200;
    private static final int PLUS_HP_PER_LEVEL = 20;

    private static final float ROGUE_VICTIM_MODIFIER = 0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = -0.1f;
    private static final float PYROMANCER_VICTIM_MODIFIER = 0.25f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.25f;
    private static final float CRITICAL_HIT_VALUE = 1.5f;
    private static final float NO_CRITICAL_HIT_VALUE = 1f;

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASE_DAMAGE + attackerLevel * PLUS_HP_PER_LEVEL;
        float criticalHit;
        // critical hit o data la 3 lovituri daca se afla pe Woods
        if ((attacker.getNrBackstabHit() % 3 == 0) && (ground.criticalPower())) {
            criticalHit = CRITICAL_HIT_VALUE;
        } else {
            criticalHit = NO_CRITICAL_HIT_VALUE;
        }
        attacker.addNrBackstabHit(1);
        return levelDamage * criticalHit * landModifier;
    }

    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + ROGUE_VICTIM_MODIFIER));
        // modificare hp
        rogue.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARD_VICTIM_MODIFIER));
        // modificare hp
        wizard.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHT_VICTIM_MODIFIER));
        // modificare hp
        knight.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCER_VICTIM_MODIFIER));
        // modificare hp
        pyromancer.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }
}
