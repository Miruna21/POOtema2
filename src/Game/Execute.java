package Game;

public class Execute implements Ability{
    private Player player = new Knight();
    Execute(Player p){
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
