package funcionarios.collection;

import funcionarios.model.Log;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class Logs {
    private ArrayList<Log> logs;
    private static Logs INSTANCE;
    
    private Logs(){
        this.logs = new ArrayList<>();
    }
    
    public static Logs getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Logs();
        
        return INSTANCE;
    }
    
    public void addLog(Log log){
        this.logs.add(log);
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }
    
}
