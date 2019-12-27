package reader;

import constants.AuxiliaryConstants;
import fileio.FileSystem;

import java.awt.Point;
import java.util.Vector;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;
    public GameInputLoader(final String inputPath, final String outputPath) {
        this.mInputPath = inputPath;
        this.mOutputPath = outputPath;
    }

    public GameInput load() {
        int mapLength = 0;
        int mapWidth = 0;
        int nrPlayers = 0;
        int nrRounds = 0;
        Vector<Vector<Character>> groundMatrix = new Vector<>();
        Vector<Character> playersTypeVector = new Vector<>();
        Vector<Vector<Integer>> playersPosMatrix = new Vector<>();
        Vector<Vector<Character>> movesMatrix = new Vector<>();
        Vector<Integer> nrAngelsPerRound = new Vector<>();
        Vector<Vector<String>> angelsNames = new Vector<>();
        Vector<Vector<Point>> angelsPos = new Vector<>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            mapLength = fs.nextInt();
            mapWidth = fs.nextInt();

            for (int i = 0; i < mapLength; ++i) {
                Vector<Character> g = new Vector<>();
                String word = fs.nextWord();
                char character;
                for (int j = 0; j < mapWidth; j++) {
                    character = word.charAt(j);
                    g.add(character);

                }
                groundMatrix.add(g);
            }
            nrPlayers = fs.nextInt();
            // citire jucatori
            for (int i = 0; i < nrPlayers; ++i) {
                String word = fs.nextWord();
                playersTypeVector.add(word.charAt(0));
                Vector<Integer> t = new Vector<>();
                for (int j = 0; j < 2; j++) {
                    t.add(fs.nextInt());
                }
                playersPosMatrix.add(t);
            }
            nrRounds = fs.nextInt();
            // citire mutari
            for (int i = 0; i < nrRounds; ++i) {
                Vector<Character> m = new Vector<>();
                String word = fs.nextWord();
                char character;
                for (int j = 0; j < nrPlayers; j++) {
                    character = word.charAt(j);
                    m.add(character);
                }
                movesMatrix.add(m);
            }
            // citire ingeri
            for (int i = 0; i < nrRounds; i++) {
                int nrAngels = fs.nextInt();
                nrAngelsPerRound.add(nrAngels);
                Vector<Point> angelsRound = new Vector<>();
                Vector<String> namesRound = new Vector<>();
                if (nrAngels == 0) {
                    angelsPos.add(angelsRound);
                    angelsNames.add(namesRound);
                    continue;
                }
                for (int j = 0; j < nrAngels; j++) {
                    String word = fs.nextWord();
                    String[] substrings = word.split(",");
                    namesRound.add(substrings[0]);
                    String xPosString = substrings[1];
                    String yPosString = substrings[2];
                    int xPos = 0;
                    for (int p = 0; p < xPosString.length(); p++) {
                        xPos = xPos * AuxiliaryConstants.ATOI_MULTIPLIER
                                + xPosString.charAt(p) - '0';
                    }
                    int yPos = 0;

                    for (int p = 0; p < yPosString.length(); p++) {
                        yPos = yPos * AuxiliaryConstants.ATOI_MULTIPLIER
                                + yPosString.charAt(p) - '0';
                    }
                    Point pos = new Point(xPos, yPos);
                    angelsRound.add(pos);
                }
                angelsPos.add(angelsRound);
                angelsNames.add(namesRound);
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapLength, mapWidth, groundMatrix, nrPlayers,
                playersTypeVector, playersPosMatrix, nrRounds, movesMatrix,
                                nrAngelsPerRound, angelsNames, angelsPos);
    }
}
