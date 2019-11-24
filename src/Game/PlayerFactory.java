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
    public Player createPlayer(final Character type, final int id, final int xPos, final int yPos) {
        switch (type) {
            case 'R': return new Rogue(id, xPos, yPos);
            case 'W': return new Wizard(id, xPos, yPos);
            case 'K': return new Knight(id, xPos, yPos);
            case 'P': return new Pyromancer(id, xPos, yPos);
            default : return null;
        }
    }
}
