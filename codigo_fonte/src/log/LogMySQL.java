package log;

import conexao.AbstractMySQL;
import model.Log;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class LogMySQL extends AbstractMySQL implements ILog{

    @Override
    public void salvarLog(ArrayList<Log> logs) throws Exception {
        String query;
        for(Log l: logs){
            query = "INSERT INTO log (log) VALUES('"
                    + l.toString() + "')";
            
            updateDB(query);
        }
    }
    
}
