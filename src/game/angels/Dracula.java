package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class Dracula extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.3f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.4f;

    private static final int HP_MODIFIER_FOR_KNIGHT = 60;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 40;
    private static final int HP_MODIFIER_FOR_ROGUE = 35;
    private static final int HP_MODIFIER_FOR_WIZARD = 20;

    public Dracula(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "Dracula";
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
