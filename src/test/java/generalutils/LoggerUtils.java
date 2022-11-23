package generalutils;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@UtilityClass
public class LoggerUtils {

    private static Logger log;

    public static Logger getLogger() {
        if (log == null) {
            log = LogManager.getLogger("LOGFILE");
        }
        return log;
    }

}
