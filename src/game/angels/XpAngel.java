package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class XpAngel extends Angel {
    private static final int XP_MODIFIER_FOR_KNIGHT = 45;
    private static final int XP_MODIFIER_FOR_PYROMANCER = 50;
    private static final int XP_MODIFIER_FOR_ROGUE = 40;
    private static final int XP_MODIFIER_FOR_WIZARD = 60;

    public XpAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "XpAngel";
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
