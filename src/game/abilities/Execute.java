package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public final class Execute implements Ability {
    private static final float PERCENT = 0.2f;
    private static final int BASE_DAMAGE = 200;
    private static final int PLUS_DAMAGE_PER_LEVEL = 30;

    private static final float ROGUE_VICTIM_MODIFIER = 0.15f;
    private static final float KNIGHT_VICTIM_MODIFIER = 0;
    private static final float PYROMANCER_VICTIM_MODIFIER = 0.1f;
    private static final float WIZARD_VICTIM_MODIFIER = -0.2f;

    private float variableRogueVictimModifier;
    private float variableKnightVictimModifier;
    private float variablePyromancerVictimModifier;
    private float variableWizardVictimModifier;

    public Execute(){
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
        float levelDamage = BASE_DAMAGE + attackerLevel * PLUS_DAMAGE_PER_LEVEL;
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
                    * (1 + ROGUE_VICTIM_MODIFIER));
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
                    * (1 + WIZARD_VICTIM_MODIFIER));
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
                    * (1 + KNIGHT_VICTIM_MODIFIER));
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
                    * (1 + PYROMANCER_VICTIM_MODIFIER));
            // modificare hp
            pyromancer.subHp(finalDamage);
        }
    }
}
