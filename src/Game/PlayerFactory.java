package Game;

public final class PlayerFactory {
    private static PlayerFactory instance = null;
    private PlayerFactory(){

    }
    public static PlayerFactory getInstance(){
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }
    public Player createPlayer(final Character type, final int id) {
        switch (type) {
            case 'R': return new Rogue(id);
            case 'W': return new Wizard(id);
            case 'K': return new Knight(id);
            case 'P': return new Pyromancer(id);
            default : return null;
        }
    }
}
