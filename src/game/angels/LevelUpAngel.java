package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class LevelUpAngel extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.15f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.25f;

    public LevelUpAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "LevelUpAngel";
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
