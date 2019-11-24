package Game;

public class Backstab implements Ability{
    private final static float RogueVictimModifier = 0.2f;
    private final static float KnightVictimModifier = -0.1f;
    private final static float PyromancerVictimModifier = 0.25f;
    private final static float WizardVictimModifier = 0.25f;
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacher) {

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
