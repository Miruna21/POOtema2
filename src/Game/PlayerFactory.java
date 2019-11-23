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
    public Player createPerson(final String type, final int id, final int hp, final int xp, final int level) {
        switch (type) {
            case "Rogue": return new Rogue(id, hp, xp, level);
            case "Wizard": return new Wizard(id, hp, xp, level);
            case "Knight": return new Knight(id, hp, xp, level);
            case "Pyromancer": return new Pyromancer(id, hp, xp, level);
            default : return null;
        }
    }
}
