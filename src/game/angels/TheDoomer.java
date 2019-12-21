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

    }

    @Override
    public void visit(Rogue rogue) {

    }

    @Override
    public void visit(Wizard wizard) {

    }

    @Override
    public void visit(Pyromancer pyromancer) {

    }
}
