package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author wagner
 */
public class PersistenciaTxtDAO implements IPersistenciaDAO {

    private final File arquivoDAO;
    private final File arquivoLog;

    public PersistenciaTxtDAO() throws IOException {
        this.arquivoDAO = new File("src/funcionarios/data/persistencia.txt");
        this.arquivoLog = new File("src/funcionarios/data/persistenciaLog.txt");

        if (!this.arquivoDAO.exists()) {
            this.arquivoDAO.createNewFile();
            inicializarArqPersistenciaFunc(arquivoDAO);
        }

        if (!this.arquivoLog.exists()) {
            this.arquivoLog.createNewFile();
            inicializarArqPersistenciaLog(arquivoLog);
        }
    }

    private void inicializarArqPersistenciaFunc(File arquivo) throws IOException {
        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write("TxtDAO");
        bf.newLine();
        bf.close();
    }
    
    private void inicializarArqPersistenciaLog(File arquivo) throws IOException {
        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write("LogTxtDAO");
        bf.newLine();
        bf.close();
    }

    @Override
    public String obterPersistenciaSalva() throws Exception {
        Scanner scan = new Scanner(arquivoDAO);
        String nomeDAO = "";
        if (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);
            nomeDAO = scanline.next();
        }

        return nomeDAO;
    }

    @Override
    public void atualizarPersistenciaSalva(String nome) throws Exception {
        FileWriter w = new FileWriter(arquivoDAO);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(nome);
        bf.newLine();
        bf.close();
    }

    @Override
    public String obterLogSalvo() throws Exception {
        Scanner scan = new Scanner(arquivoLog);
        String nomeDAO = "";
        if (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);
            nomeDAO = scanline.next();
        }

        return nomeDAO;
    }

    @Override
    public void atualizarLogSalvo(String nome) throws Exception {
        FileWriter w = new FileWriter(arquivoLog);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(nome);
        bf.newLine();
        bf.close();
    }
}
