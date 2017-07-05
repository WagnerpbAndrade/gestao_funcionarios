package dao;

import memento.Funcionario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author wagner
 */
public class TxtDAO implements IFuncionarioDAO {

    private final File arquivo;

    public TxtDAO() throws IOException {
        this.arquivo = new File("src/funcionarios/data/funcionarios.txt");
        if(!this.arquivo.exists())
            this.arquivo.createNewFile();
    }

    @Override
    public void inserir(Funcionario f) throws Exception {

        FileWriter w = new FileWriter(arquivo, true);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(f.toString());
        bf.newLine();
        bf.close();

    }

    @Override
    public TreeSet<Funcionario> getAll() throws Exception {
        TreeSet<Funcionario> funcionarios = new TreeSet<>();

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

                Funcionario f = new Funcionario(nome, telefone, salario, salarioComBonus, cargo, regiao, getBonus(bonus), assiduidade, dependentes);
                //System.out.println("getALL: " + f.toString());
                funcionarios.add(f);
            }
        }
        //arquivo.delete();

        return funcionarios;
    }

    @Override
    public void editarFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception {

        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);

        for (Funcionario f : c) {
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

}
