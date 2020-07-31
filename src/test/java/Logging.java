import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Logging {

    private final static Logger logger = (Logger)LogManager.getLogger(Logging.class);


    public static void main(String[] args) {
        logger.info("CESI logger course examples :");
        logger.debug("Debug message.");
        logger.error("Error message.");
        logger.warn("Warning message.");
        logger.fatal("Fatal error message.");
        logger.info("End examples;");
    }
}
