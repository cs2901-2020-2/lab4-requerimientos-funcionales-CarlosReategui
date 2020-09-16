package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part) {
        String result = part.get(0);
        for (int i = 1; i < part.size(); ++i) {
            String subsequence = "";
            for (int j = 0; j < part.get(i).length(); ++j) {
                subsequence += part.get(i).charAt(j);
                if (!result.contains(subsequence)) {
                    result += part.get(i).charAt(j);
                }
            }
        }
        return result.toString();
    }
}
