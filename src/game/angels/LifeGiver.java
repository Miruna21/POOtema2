package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class LifeGiver extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 100;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 80;
    private static final int HP_MODIFIER_FOR_ROGUE = 90;
    private static final int HP_MODIFIER_FOR_WIZARD = 120;

    public LifeGiver(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "LifeGiver";
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
