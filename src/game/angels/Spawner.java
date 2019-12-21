package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class Spawner extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 200;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 150;
    private static final int HP_MODIFIER_FOR_ROGUE = 180;
    private static final int HP_MODIFIER_FOR_WIZARD = 120;

    public Spawner(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "Spawner";
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
