package Game;


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
    public Ground createGround(Character groundType) {
        switch (groundType){
            case 'L': return new Land();
            case 'V': return new Vulcanic();
            case 'W': return new Woods();
            case 'D': return new Desert();
            default: return null;
        }
    }
}
