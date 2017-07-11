package log;

import model.Log;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public interface ILog {
    public void salvarLog(ArrayList<Log> logs) throws Exception;
}
