package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Fireblast implements Ability {
    private static final int BASE_DAMAGE = 350;
    private static final int PLUS_DAMAGE_PER_LEVEL = 50;

    private static final float ROGUE_VICTIM_MODIFIER = -0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = -0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.05f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Fireblast() {
        variableRogueVictimModifier = ROGUE_VICTIM_MODIFIER;
        variableKnightVictimModifier = KNIGHT_VICTIM_MODIFIER;
        variablePyromancerVictimModifier = PYROMANCER_VICTIM_MODIFIER;
        variableWizardVictimModifier = WIZARD_VICTIM_MODIFIER;
    }

    @Override
    public void changeAllVictimModifier(float number) {
        variableKnightVictimModifier += number;
        variableRogueVictimModifier += number;
        variablePyromancerVictimModifier += number;
        variableWizardVictimModifier += number;
    }

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
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variableRogueVictimModifier));
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variableWizardVictimModifier));
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variableKnightVictimModifier));
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier
                            * (1 + variablePyromancerVictimModifier));
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
