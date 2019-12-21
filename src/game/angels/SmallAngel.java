package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class SmallAngel extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.15f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.05f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.1f;

    private static final int HP_MODIFIER_FOR_KNIGHT = 10;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 15;
    private static final int HP_MODIFIER_FOR_ROGUE = 20;
    private static final int HP_MODIFIER_FOR_WIZARD = 25;

    public SmallAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "SmallAngel";
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
