package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Wizard;
import game.players.Rogue;
import game.players.Player;

public final class Dracula extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.3f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.4f;

    private static final int HP_MODIFIER_FOR_KNIGHT = 60;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 40;
    private static final int HP_MODIFIER_FOR_ROGUE = 35;
    private static final int HP_MODIFIER_FOR_WIZARD = 20;

    public Dracula(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "Dracula";
    }

    @Override
    public boolean visitLivePlayers() {
        return true;
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            knight.getFirstAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_KNIGHT);
            // scad hp-ul jucatorului
            knight.subHp(HP_MODIFIER_FOR_KNIGHT);
            // anunt magicianul de lovitura ingerului
            knight.getEvent().anEventHappened(knight, this, "complicate");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(knight, this);
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_ROGUE);
            // scad hp-ul jucatorului
            rogue.subHp(HP_MODIFIER_FOR_ROGUE);
            // anunt magicianul de lovitura ingerului
            rogue.getEvent().anEventHappened(rogue, this, "complicate");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(rogue, this);
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_WIZARD);
            // scad hp-ul jucatorului
            wizard.subHp(HP_MODIFIER_FOR_WIZARD);
            // anunt magicianul de lovitura ingerului
            wizard.getEvent().anEventHappened(wizard, this, "complicate");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(wizard, this);
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().
                    changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().
                    changeAllVictimModifier(-DAMAGE_MODIFIER_FOR_PYROMANCER);
            // scad hp-ul jucatorului
            pyromancer.subHp(HP_MODIFIER_FOR_PYROMANCER);
            // anunt magicianul de lovitura ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "complicate");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(pyromancer, this);
        }
    }

    private void verifyPlayerKilledByAngel(final Player player, final Angel angel) {
        // daca jucatorul a fost omorat de inger, anunt magicianul
        if (!player.getLife()) {
            player.getEvent().anEventHappened(player, angel, "kill");
        }
    }
}
