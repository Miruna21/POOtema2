package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Slam implements Ability {
    private static final int BASE_DAMAGE = 100;
    private static final int PLUS_HP_PER_LEVEL = 40;

    private static final float ROGUE_VICTIM_MODIFIER = -0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = -0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.05f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Slam(){
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
                * (1 + ROGUE_VICTIM_MODIFIER));
        // modificare hp
        rogue.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        rogue.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        rogue.setNrRoundsParalyzed(0);
        rogue.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + WIZARD_VICTIM_MODIFIER));
        // modificare hp
        wizard.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        wizard.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        wizard.setNrRoundsParalyzed(0);
        wizard.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + KNIGHT_VICTIM_MODIFIER));
        // modificare hp
        knight.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        knight.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        knight.setNrRoundsParalyzed(0);
        knight.setNrRoundsIgniteHit(0);
    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier)
                * (1 + PYROMANCER_VICTIM_MODIFIER));
        // modificare hp
        pyromancer.subHp(finalDamage);
        // incapacitatea de a se misca in urmatoarea runda
        pyromancer.setMovPermission(false);
        // inlocuiesc abilitatea trecuta overtime cu imposibilitatea de miscare
        pyromancer.setNrRoundsParalyzed(0);
        pyromancer.setNrRoundsIgniteHit(0);
    }
}
