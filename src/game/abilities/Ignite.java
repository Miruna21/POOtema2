package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Ignite implements Ability {
    private static final int BASE_DAMAGE = 150;
    private static final int PLUS_DAMAGE_PER_LEVEL1 = 20;
    private static final int OTHER_DAMAGE = 50;
    private static final int PLUS_DAMAGE_PER_LEVEL2 = 30;

    private static final float ROGUE_VICTIM_MODIFIER = -0.2f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0.2f;
    private static final float PYROMANCER_VICTIM_MODIFIER = -0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = 0.05f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Ignite() {
        variableRogueVictimModifier = ROGUE_VICTIM_MODIFIER;
        variableKnightVictimModifier = KNIGHT_VICTIM_MODIFIER;
        variablePyromancerVictimModifier = PYROMANCER_VICTIM_MODIFIER;
        variableWizardVictimModifier = WIZARD_VICTIM_MODIFIER;
    }

    @Override
    public void changeRogueVictimModifier(final float number) {
        variableRogueVictimModifier += number;
    }
    @Override
    public void changeKnightVictimModifier(final float number) {
        variableKnightVictimModifier += number;
    }
    @Override
    public void changePyromancerVictimModifier(final float number) {
        variablePyromancerVictimModifier += number;
    }
    @Override
    public void changeWizardVictimModifier(final float number) {
        variableWizardVictimModifier += number;
    }

    private float levelAndGroundDamage(final Ground ground, final Player attacker) {
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage;
        levelDamage = BASE_DAMAGE + attackerLevel * PLUS_DAMAGE_PER_LEVEL1;
        return levelDamage * landModifier;
    }
    @Override
    public void attack(final Rogue rogue, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variableRogueVictimModifier));
        int overtimeDamage = Math.round((OTHER_DAMAGE + attacker.getLevel()
                * PLUS_DAMAGE_PER_LEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + variableRogueVictimModifier));
        rogue.setNrRoundsIgniteHit(2);
        rogue.setOvertimeDamage(overtimeDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        rogue.setNrRoundsParalyzed(0);
        rogue.setMovPermission(true);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(final Wizard wizard, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.addDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(damageWithoutRaceModifier
                            * (1 + variableWizardVictimModifier));
        int overtimeDamage = Math.round((OTHER_DAMAGE + attacker.getLevel()
                * PLUS_DAMAGE_PER_LEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + variableWizardVictimModifier));
        wizard.setNrRoundsIgniteHit(2);
        wizard.setOvertimeDamage(overtimeDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        wizard.setNrRoundsParalyzed(0);
        wizard.setMovPermission(true);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(final Knight knight, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variableKnightVictimModifier));
        int overtimeDamage = Math.round((OTHER_DAMAGE + attacker.getLevel()
                * PLUS_DAMAGE_PER_LEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + variableKnightVictimModifier));
        knight.setNrRoundsIgniteHit(2);
        knight.setOvertimeDamage(overtimeDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        knight.setNrRoundsParalyzed(0);
        knight.setMovPermission(true);
        // modificare hp
        knight.subHp(finalDamage);

    }

    @Override
    public void attack(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.addDamageWithoutRaceModifier(damageWithoutRaceModifier);
        int finalDamage = Math.round(damageWithoutRaceModifier
                                * (1 + variablePyromancerVictimModifier));
        int overtimeDamage = Math.round((OTHER_DAMAGE + attacker.getLevel()
                * PLUS_DAMAGE_PER_LEVEL2) * attacker.acceptLandModifier(ground)
                * (1 + variablePyromancerVictimModifier));
        pyromancer.setNrRoundsIgniteHit(2);
        pyromancer.setOvertimeDamage(overtimeDamage);
        // inlocuiesc abilitatea trecuta overtime cu cea noua
        pyromancer.setNrRoundsParalyzed(0);
        pyromancer.setMovPermission(true);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
