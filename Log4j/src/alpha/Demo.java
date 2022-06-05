package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Demo {

		private static Logger log = (Logger) LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args) {

		log.debug("I am debugging");

		log.debug("Object is present");

		log.error("Object is not present");
		
		log.fatal("This is fatal");
	}

}
