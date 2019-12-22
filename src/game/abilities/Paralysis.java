package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Paralysis implements Ability {
    private static final int BASE_DAMAGE = 40;
    private static final int PLUS_HP_PER_LEVEL = 10;

    private static final float ROGUE_VICTIM_MODIFIER = -0.1f;
    private static final float KNIGHT_VICTIM_MODIFIER = -0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = 0.2f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.25f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Paralysis(){
        variableRogueVictimModifier = ROGUE_VICTIM_MODIFIER;
        variableKnightVictimModifier = KNIGHT_VICTIM_MODIFIER;
        variablePyromancerVictimModifier = PYROMANCER_VICTIM_MODIFIER;
        variableWizardVictimModifier = WIZARD_VICTIM_MODIFIER;
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
    public void changeWizardVictimModifier(final float number){
        variableWizardVictimModifier += number;
    }

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = BASE_DAMAGE + attackerLevel * PLUS_HP_PER_LEVEL;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + variableRogueVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        rogue.setNrRoundsParalyzed(nrRoundsParalyzed);
        rogue.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        rogue.setMovPermission(true);
        rogue.setNrRoundsIgniteHit(0);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + variableWizardVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        wizard.setNrRoundsParalyzed(nrRoundsParalyzed);
        wizard.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        wizard.setMovPermission(true);
        wizard.setNrRoundsIgniteHit(0);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + variableKnightVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        knight.setNrRoundsParalyzed(nrRoundsParalyzed);
        knight.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        knight.setMovPermission(true);
        knight.setNrRoundsIgniteHit(0);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + variablePyromancerVictimModifier));
        int nrRoundsParalyzed = ground.getNrRoundsParalyzed();
        pyromancer.setNrRoundsParalyzed(nrRoundsParalyzed);
        pyromancer.setOvertimeDamage(finalDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        pyromancer.setMovPermission(true);
        pyromancer.setNrRoundsIgniteHit(0);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
