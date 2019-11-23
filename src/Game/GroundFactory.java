package Game;

import java.util.Vector;

public class GroundFactory {
    private static GroundFactory instance = null;
    private GroundFactory(){
    }
    public static GroundFactory getInstance(){
        if (instance == null) {
            instance = new GroundFactory();
        }
        return instance;
    }
    public Ground createGround(String groundType) {
        switch (groundType){
            case "Land": return new Land();
            case "Vulcanic": return new Vulcanic();
            case "Woods": return new Woods();
            case "Desert": return new Desert();
            default: return null;
        }
    }
}
