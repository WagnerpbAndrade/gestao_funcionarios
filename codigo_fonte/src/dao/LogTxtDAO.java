package dao;

import funcionarios.model.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class LogTxtDAO implements ILogDAO {

    private final File arquivo;

    public LogTxtDAO() throws IOException {
        this.arquivo = new File("src/funcionarios/data/log.txt");
        if(!this.arquivo.exists())
            this.arquivo.createNewFile();
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
