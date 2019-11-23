package Main;

import Game.Ground;
import Game.GroundFactory;
import Game.Player;
import Game.PlayerFactory;
import Reader.GameInput;
import Reader.GameInputLoader;

import java.util.Vector;

public class Main {

    public static void main(String[] args){
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);;
        GameInput gameInput = gameInputLoader.load();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        GroundFactory groundFactory = GroundFactory.getInstance();
        Player[] players;
        Vector<Vector<Ground>> map = new Vector<>();
    }
}
