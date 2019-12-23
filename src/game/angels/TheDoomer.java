package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public final class TheDoomer extends Angel {
    public TheDoomer(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "TheDoomer";
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // omor jucatorul
            knight.setLife(false);
            // anunt macicianul de lovitura ingerului
            knight.getEvent().anEventHappened(knight, this, "complicate");
            // anunt magicianul de omorarea unui jucator de catre un inger
            knight.getEvent().anEventHappened(knight, this, "kill");
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // omor jucatorul
            rogue.setLife(false);
            // anunt macicianul de lovitura ingerului
            rogue.getEvent().anEventHappened(rogue, this, "complicate");
            // anunt magicianul de omorarea unui jucator de catre un inger
            rogue.getEvent().anEventHappened(rogue, this, "kill");
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // omor jucatorul
            wizard.setLife(false);
            // anunt macicianul de lovitura ingerului
            wizard.getEvent().anEventHappened(wizard, this, "complicate");
            // anunt magicianul de omorarea unui jucator de catre un inger
            wizard.getEvent().anEventHappened(wizard, this, "kill");
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // omor jucatorul
            pyromancer.setLife(false);
            // anunt macicianul de lovitura ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "complicate");
            // anunt magicianul de omorarea unui jucator de catre un inger
            pyromancer.getEvent().anEventHappened(pyromancer, this, "kill");
        }
    }
}
