package Game;

public class Deflect implements Ability{
    private final static float RogueVictimModifier = 0.2f;
    private final static float KnightVictimModifier = 0.4f;
    private final static float PyromancerVictimModifier = 0.3f;
    // private final static float WizardVictimModifier = 0.05f;
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {

    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {

    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {

    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {

    }
}
