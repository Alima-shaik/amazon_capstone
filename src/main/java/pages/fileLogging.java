package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class fileLogging {
	

	    private static final Logger logger = LogManager.getLogger(fileLogging.class);

	    public static void main(String[] args) {
	    	System.out.println("helo this is syso code");
	        logger.info("Hello World! in new file");
	        logger.debug("Hello World!");
	        logger.trace("this is trace code");
	    }
	}
