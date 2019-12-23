package writer;

import fileio.FileSystem;
import game.players.Player;

import java.io.IOException;
import java.util.Vector;

public final class GameOutput {
    private final String mInputPath;
    private final String mOutputPath;
    private FileSystem fs;

    public GameOutput(final String inputPath, final String mOutputPath) {
        this.mInputPath = inputPath;
        this.mOutputPath = mOutputPath;
    }
    public void startWriting() throws IOException {
        fs = new FileSystem(mInputPath, mOutputPath);
    }
    public void endWriting() throws IOException {
        fs.close();
    }
    public void writePlayersInFile(final Vector<Player> players) {
        try {
            for (Player index : players) {
                fs.writeWord(index.toString());
                fs.writeNewLine();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void writeOutputFrame(final String schelet) {
        try {
            fs.writeWord(schelet);
            fs.writeNewLine();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void magicianWrites(final String outputString) {
        try {
            fs.writeWord(outputString);
            fs.writeNewLine();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
