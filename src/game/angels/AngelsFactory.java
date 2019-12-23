package game.angels;

public final class AngelsFactory {

    private static AngelsFactory instance = null;
    private AngelsFactory() {
    }
    public static AngelsFactory getInstance() {
        if (instance == null) {
            instance = new AngelsFactory();
        }
        return instance;
    }
    public Angel createAngel(final String angelName, final int id, final int xPos,
                             final int yPos) {
        switch (angelName) {
            case "DamageAngel": return new DamageAngel(id, xPos, yPos);
            case "DarkAngel": return new DarkAngel(id, xPos, yPos);
            case "Dracula": return new Dracula(id, xPos, yPos);
            case "GoodBoy": return new GoodBoy(id, xPos, yPos);
            case "LevelUpAngel": return new LevelUpAngel(id, xPos, yPos);
            case "LifeGiver": return new LifeGiver(id, xPos, yPos);
            case "SmallAngel": return new SmallAngel(id, xPos, yPos);
            case "Spawner": return new Spawner(id, xPos, yPos);
            case "TheDoomer": return new TheDoomer(id, xPos, yPos);
            case "XPAngel": return new XpAngel(id, xPos, yPos);
            default: return null;
        }
    }
}
