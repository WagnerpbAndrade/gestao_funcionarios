package dao;

import conexao.AbstractMySQL;
import funcionarios.model.Log;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class LogMySQL extends AbstractMySQL implements ILogDAO{

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
