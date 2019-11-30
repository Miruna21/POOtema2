package writer;
import game.Player;
import fileio.FileSystem;

import java.util.Vector;

public final class GameOutput {
    private final String mInputPath;
    private final String mOutputPath;

    public GameOutput(final String inputPath, final String mOutputPath) {
        this.mInputPath = inputPath;
        this.mOutputPath = mOutputPath;
    }
    public void writePlayersInFile(final Vector<Player> players) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (Player index : players) {
                fs.writeWord(index.toString());
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
