package Writer;
import Game.Player;
import fileio.FileSystem;

import java.util.Vector;

public class GameOutput {
    private final String mInputPath;
    private final String mOutputPath;

    public GameOutput(final String inputPath, final String mOutputPath) {
        this.mInputPath = inputPath;
        this.mOutputPath = mOutputPath;
    }
    public void writePlayersInFile(Vector<Player> players) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (int i = 0; i < players.size(); i++) {
                fs.writeWord(players.get(i).toString());
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
