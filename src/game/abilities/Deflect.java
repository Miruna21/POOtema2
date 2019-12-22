package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Deflect implements Ability {
    private static final float BASE_PERCENT = 0.35f;
    private static final float PLUS_PERCENT_PER_LEVEL = 0.02f;

    private static final float ROGUE_VICTIM_MODIFIER = 0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.4f;
    private static final float PYROMANCER_VICTIM_MODIFIER = 0.3f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;

    public Deflect(){
        variableRogueVictimModifier = ROGUE_VICTIM_MODIFIER;
        variableKnightVictimModifier = KNIGHT_VICTIM_MODIFIER;
        variablePyromancerVictimModifier = PYROMANCER_VICTIM_MODIFIER;
    }
    @Override
    public void changeRogueVictimModifier(final float number){
        variableRogueVictimModifier += number;
    }
    @Override
    public void changeKnightVictimModifier(final float number){
        variableKnightVictimModifier += number;
    }
    @Override
    public void changePyromancerVictimModifier(final float number){
        variablePyromancerVictimModifier += number;
    }
    @Override
    public void changeWizardVictimModifier(float number) {

    }

    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = BASE_PERCENT + rogue.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variableRogueVictimModifier * percent;
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
        float percent = BASE_PERCENT + knight.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variableKnightVictimModifier * percent;
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * damage * landModifier);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = BASE_PERCENT + pyromancer.getLevel() * PLUS_PERCENT_PER_LEVEL;
        float newPercent = percent + variablePyromancerVictimModifier * percent;
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * damage * landModifier);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
