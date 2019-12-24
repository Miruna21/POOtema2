package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Drain implements Ability {
    private static final float MULTIPLIER = 0.3f;
    private static final float BASE_PERCENT = 0.2f;
    private static final float PLUS_PERCENT_PER_LEVEL = 0.05f;

    private static final float ROGUE_VICTIM_MODIFIER = -0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = -0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.05f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Drain() {
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

    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float percent = BASE_PERCENT + rogue.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variableRogueVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = rogue.getInitialHp() + rogue.getLevel()
                * rogue.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = rogue.getHp();
        baseHp = Math.min(a, b);
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float percent = BASE_PERCENT + wizard.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variableWizardVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = wizard.getInitialHp() + wizard.getLevel()
                * wizard.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = wizard.getHp();
        baseHp = Math.min(a, b);
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float percent = BASE_PERCENT + knight.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variableKnightVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = knight.getInitialHp() + knight.getLevel()
                * knight.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = knight.getHp();
        baseHp = Math.min(a, b);
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float percent = BASE_PERCENT + pyromancer.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variablePyromancerVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = pyromancer.getInitialHp() + pyromancer.getLevel()
                * pyromancer.getPlusHpPerLevel();
        float a = MULTIPLIER * victimMaxHpOnHerLevel;
        float b = pyromancer.getHp();
        baseHp = Math.min(a, b);
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
