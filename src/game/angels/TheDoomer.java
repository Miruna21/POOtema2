package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "TheDoomer";
    }

    @Override
    public void visit(Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // omor jucatorul
            knight.setLife(false);
            // anunt magicianul de omorarea unui jucator de catre un inger
            knight.getEvent().anEventHappened(knight, this, "kill");
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // omor jucatorul
            rogue.setLife(false);
            // anunt magicianul de omorarea unui jucator de catre un inger
            rogue.getEvent().anEventHappened(rogue, this, "kill");        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // omor jucatorul
            wizard.setLife(false);
            // anunt magicianul de omorarea unui jucator de catre un inger
            wizard.getEvent().anEventHappened(wizard, this, "kill");
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // omor jucatorul
            pyromancer.setLife(false);
            // anunt magicianul de omorarea unui jucator de catre un inger
            pyromancer.getEvent().anEventHappened(pyromancer, this, "kill");
        }
    }
}
