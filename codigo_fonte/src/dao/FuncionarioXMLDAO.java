package dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import memento.Funcionario;
import java.io.File;
import java.io.IOException;
import java.util.Collection;    
import java.util.TreeSet;

/**
 *
 * @author wagner
 */
public class FuncionarioXMLDAO implements IFuncionarioDAO{
    
    private final File arquivo;

    public FuncionarioXMLDAO() throws IOException {
        this.arquivo = new File("src/funcionarios/data/funcionarios.xml");
        if(!this.arquivo.exists())
            this.arquivo.createNewFile();
    }
    
    @Override
    public void inserir(Funcionario f) throws Exception {
        //FileWriter w = new FileWriter(arquivo, true);
        //BufferedWriter bf = new BufferedWriter(w);
        XStream stream = new XStream(new DomDriver());
        //bf.write(stream.toXML(f));
        //bf.close();
        
        stream.alias("funcionario", Funcionario.class);
        System.out.println("Funcionario: " + stream.toXML(f));
    }

    @Override
    public TreeSet<Funcionario> getAll() throws Exception {
        return null;
    }

    @Override
    public void editarFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
