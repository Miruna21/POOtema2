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
        // daca jucatorul este mort
        if (!knight.getLife()){
            // readuc jucatorul la viata
            knight.setLife(true);
            // setez noul hp
            knight.setHp(HP_MODIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este mort
        if (!rogue.getLife()){
            // readuc jucatorul la viata
            rogue.setLife(true);
            // setez noul hp
            rogue.setHp(HP_MODIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este mort
        if (!wizard.getLife()){
            // readuc jucatorul la viata
            wizard.setLife(true);
            // setez noul hp
            wizard.setHp(HP_MODIFIER_FOR_WIZARD);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este mort
        if (!pyromancer.getLife()){
            // readuc jucatorul la viata
            pyromancer.setLife(true);
            // setez noul hp
            pyromancer.setHp(HP_MODIFIER_FOR_PYROMANCER);
        }
    }
}
