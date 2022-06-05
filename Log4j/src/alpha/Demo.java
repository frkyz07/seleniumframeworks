package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		log.debug("I am debugging");

		log.debug("Object is present");

		log.error("Object is not present");

		log.fatal("This is fatal");
	}

}
