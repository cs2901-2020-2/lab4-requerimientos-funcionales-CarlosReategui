package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public void checkIfStringHasMoreThanTwoHundredCharacters(String subsequence) throws SubsequenceLengthException {
        if (subsequence.length() > 200) {
            throw new SubsequenceLengthException("A subsequence exceeds 200 characters");
        }
    }

    public String calculate(List<String> parts) throws SubsequenceLengthException, SubsequenceListSizeException {
        if (parts.size() > 160000) {
            throw new SubsequenceListSizeException("Too many subsequences");
        }
        checkIfStringHasMoreThanTwoHundredCharacters(parts.get(0));
        StringBuilder solution = new StringBuilder(parts.get(0));
        for (int i = 1; i < parts.size(); ++i) {
            StringBuilder subsequence = new StringBuilder();
            checkIfStringHasMoreThanTwoHundredCharacters(parts.get(i));
            for (int j = 0; j < parts.get(i).length(); ++j) {
                subsequence.append(Character.toString(parts.get(i).charAt(j)));
                if (!solution.toString().contains(subsequence)) {
                    solution.append(Character.toString(parts.get(i).charAt(j)));
                }
            }
        }
        return solution.toString();
    }
}
