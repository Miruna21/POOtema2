package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class DarkAngel extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 40;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 30;
    private static final int HP_MODIFIER_FOR_ROGUE = 10;
    private static final int HP_MODIFIER_FOR_WIZARD = 20;

    public DarkAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "DarkAngel";
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
