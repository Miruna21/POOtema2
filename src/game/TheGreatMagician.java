package game;

public class TheGreatMagician implements Observer {
    private static TheGreatMagician instance = null;

    private TheGreatMagician(){

    }
    public static TheGreatMagician getInstance() {
        if (instance == null) {
            instance = new TheGreatMagician();
        }
        return instance;
    }
}
