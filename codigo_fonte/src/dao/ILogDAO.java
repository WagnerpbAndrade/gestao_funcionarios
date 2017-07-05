package dao;

import funcionarios.model.Log;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public interface ILogDAO {
    public void salvarLog(ArrayList<Log> logs) throws Exception;
}
