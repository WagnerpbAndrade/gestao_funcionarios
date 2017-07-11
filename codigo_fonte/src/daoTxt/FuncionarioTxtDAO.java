package daoTxt;

import model.AbstractFuncionario;
import dao.IFuncionarioDAO;
import model.Funcionario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class FuncionarioTxtDAO implements IFuncionarioDAO {

    private final File arquivo;

    public FuncionarioTxtDAO()  {
        this.arquivo = new File("src/data/funcionarios.txt");
        if(!this.arquivo.exists())
            try {
                
                this.arquivo.createNewFile();
                
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioTxtDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(AbstractFuncionario f) throws Exception {

        FileWriter w = new FileWriter(arquivo, true);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(f.toString());
        bf.newLine();
        bf.close();

    }

    @Override
    public TreeSet<AbstractFuncionario> getAll() throws Exception {
        TreeSet<AbstractFuncionario> funcionarios = new TreeSet<>();

        Scanner scan = new Scanner(arquivo);
        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);
            scanline.useDelimiter(",");
            while (scanline.hasNext()) {
                String nome = scanline.next();
                String telefone = scanline.next();
                double salario = Double.parseDouble(scanline.next());
                double salarioComBonus = Double.parseDouble(scanline.next());
                String cargo = scanline.next();
                String regiao = scanline.next();
                int assiduidade = Integer.parseInt(scanline.next());
                int dependentes = Integer.parseInt(scanline.next());
                String bonus = scanline.nextLine();

                AbstractFuncionario f = new Funcionario(nome, telefone, salario, salarioComBonus, cargo, regiao, getBonus(bonus), assiduidade, dependentes);
                //System.out.println("getALL: " + f.toString());
                funcionarios.add(f);
            }
        }
        //arquivo.delete();

        return funcionarios;
    }

    @Override
    public void editarFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario funcionario) throws Exception {

        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);

        for (AbstractFuncionario f : c) {
            bf.write(f.toString());
            bf.newLine();
        }
        bf.close();

    }

    //  ,[Generoso, Assiduidade, Localidade]
    private ArrayList<String> getBonus(String bonus) {
        ArrayList<String> arrayBonus = new ArrayList<>();
        bonus = bonus.replace(",[", "");
        bonus = bonus.replaceFirst("]", "");
        //System.out.println("Bonus: " + bonus);

        String[] bonusSeparado = bonus.split(",\\s");
        for (int i = 0; i < bonusSeparado.length; i++) {
            arrayBonus.add(bonusSeparado[i]);
        }

        //System.out.println("ArrayBonus: " + arrayBonus.toString());
        return arrayBonus;
    }

    @Override
    public void removerFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario funcionario) throws Exception {
        for(AbstractFuncionario f : c){
            if( funcionario.equals(f))
                c.remove(f);
            
            break;        
        }
        
        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);

        for (AbstractFuncionario f : c) {
            bf.write(f.toString());
            bf.newLine();
        }
        bf.close();       
    }

}
