package game.abilities;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public final class AtackFightBehavior implements FightBehavior {
    private static final float KNIGHT_ATTACKER_MODIFIER = 0.5f;
    private static final float ROGUE_ATTACKER_MODIFIER = 0.4f;
    private static final float WIZARD_ATTACKER_MODIFIER = 0.6f;
    private static final float PYROMANCER_ATTACKER_MODIFIER = 0.7f;

    private static final float HP_PROCENT_KNIGHT_MODIFIER = 1 / 5f;
    private static final float HP_PROCENT_ROGUE_MODIFIER = 1 / 7f;
    private static final float HP_PROCENT_WIZARD_MODIFIER = 1 / 10f;
    private static final float HP_PROCENT_PYROMANCER_MODIFIER = 1 / 4f;

    @Override
    public void changeFightPowers(final Knight knight) {
        // jucatorul renunta la un anumit procent din hp
        int newHp = (int) (knight.getHp() - HP_PROCENT_KNIGHT_MODIFIER * knight.getHp());
        knight.setHp(newHp);
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        knight.getFirstAbility().changeKnightVictimModifier(KNIGHT_ATTACKER_MODIFIER);
        knight.getSecondAbility().changeKnightVictimModifier(KNIGHT_ATTACKER_MODIFIER);
    }

    @Override
    public void changeFightPowers(final Rogue rogue) {
        // jucatorul renunta la un anumit procent din hp
        int newHp = (int) (rogue.getHp() - HP_PROCENT_ROGUE_MODIFIER * rogue.getHp());
        rogue.setHp(newHp);
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        rogue.getFirstAbility().changeKnightVictimModifier(ROGUE_ATTACKER_MODIFIER);
        rogue.getSecondAbility().changeKnightVictimModifier(ROGUE_ATTACKER_MODIFIER);
    }

    @Override
    public void changeFightPowers(final Wizard wizard) {
        // jucatorul renunta la un anumit procent din hp
        int newHp = (int) (wizard.getHp() - HP_PROCENT_WIZARD_MODIFIER * wizard.getHp());
        wizard.setHp(newHp);
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        wizard.getFirstAbility().changeKnightVictimModifier(WIZARD_ATTACKER_MODIFIER);
        wizard.getSecondAbility().changeKnightVictimModifier(WIZARD_ATTACKER_MODIFIER);
    }

    @Override
    public void changeFightPowers(final Pyromancer pyromancer) {
        // jucatorul renunta la un anumit procent din hp
        int newHp = (int) (pyromancer.getHp() - HP_PROCENT_PYROMANCER_MODIFIER
                * pyromancer.getHp());
        pyromancer.setHp(newHp);
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        pyromancer.getFirstAbility().changeKnightVictimModifier(PYROMANCER_ATTACKER_MODIFIER);
        pyromancer.getSecondAbility().changeKnightVictimModifier(PYROMANCER_ATTACKER_MODIFIER);
    }
}
