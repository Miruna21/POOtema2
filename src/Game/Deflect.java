package Game;

public class Deflect implements Ability{
    private Player player = new Wizard();
    Deflect(Player p){
        this.player = p;
    }
    @Override
    public void attack(Rogue rogue, Ground ground) {

    }

    @Override
    public void attack(Wizard wizard, Ground ground) {

    }

    @Override
    public void attack(Knight knight, Ground ground) {

    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground) {

    }
}
