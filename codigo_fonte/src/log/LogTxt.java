package log;

import model.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class LogTxt implements ILog {

    private final File arquivo;

    public LogTxt() {
        this.arquivo = new File("src/data/log.txt");
        if(!this.arquivo.exists())
            try {
                
                this.arquivo.createNewFile();
                
        } catch (IOException ex) {
            Logger.getLogger(LogTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salvarLog(ArrayList<Log> logs) throws Exception {
        
        FileWriter w = new FileWriter(arquivo, true);
        BufferedWriter bf = new BufferedWriter(w);

        for (Log l : logs) {
            bf.write(l.toString());
            bf.newLine();
        }
        
        
        bf.close();

    }

}
