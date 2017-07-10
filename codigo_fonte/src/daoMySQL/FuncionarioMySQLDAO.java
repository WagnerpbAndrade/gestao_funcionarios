package daoMySQL;

import conexao.AbstractMySQL;
import conexao.ConexaoMySQL;
import dao.IFuncionarioDAO;
import funcionarios.model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author wagner
 */
public class FuncionarioMySQLDAO extends AbstractMySQL implements IFuncionarioDAO {

    @Override
    public void inserir(Funcionario f) throws Exception {

        int idFuncionario = 0;
        String sql = "INSERT INTO funcionario (nome, telefone, salario, salarioBonus, assiduidade, cargo, regiao, dependentes) VALUES('"
                + f.getNome() + "','"
                + f.getTelefone() + "','"
                + f.getSalarioBase() + "','"
                + f.getSalarioComBonus() + "','"
                + f.getAssiduidade() + "','"
                + f.getCargo() + "','"
                + f.getRegiao() + "','"
                + f.getNumeroDependentes() + "')";

        updateDB(sql);

        String sqlId = "SELECT MAX(idFuncionario) from funcionario";
        ResultSet result = querySelect(sqlId);
        if (result.next()) {
            idFuncionario = result.getInt(1);
        }

        for (int i = 0; i < f.getBonus().size(); i++) {
            int id = 0;
            String bonusSql = "SELECT idBonus FROM bonus WHERE tipoDeBonus = '" + f.getBonus().get(i).trim() + "'";

            ResultSet rs = querySelect(bonusSql);
            while (rs.next()) {
                id = rs.getInt("idBonus");
            }

            String sqlBonusFuncionario = "INSERT INTO bonusFuncionario (idFuncionario, idBonus) VALUES ('"
                    + idFuncionario + "','"
                    + id + "')";

            updateDB(sqlBonusFuncionario);

            rs.close();
        }

        result.close();

    }

    @Override
    public TreeSet<Funcionario> getAll() throws Exception {
        TreeSet<Funcionario> funcionarios = new TreeSet<>();

        Connection con = ConexaoMySQL.getInstance().getConexao();
        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("SELECT * FROM funcionario WHERE status = 1");
        while (rs.next()) {
            ArrayList<String> bonus = new ArrayList<>();
            ResultSet result;

            int id = rs.getInt("idFuncionario");
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            double salarioBase = rs.getDouble("salario");
            double salarioBonus = rs.getDouble("salarioBonus");
            int assiduidade = rs.getInt("assiduidade");
            String cargo = rs.getString("cargo");
            String regiao = rs.getString("regiao");
            int dependentes = rs.getInt("dependentes");

            result = querySelect("SELECT * FROM bonus WHERE idBonus IN ("
                    + "SELECT idBonus FROM bonusFuncionario WHERE idFuncionario = " + id + ")");
            while (result.next()) {
                String tipoBonus = result.getString("tipoDeBonus");
                bonus.add(tipoBonus);
            }

            result.close();

            Funcionario f = new Funcionario(id, nome, telefone, salarioBase, salarioBonus, cargo, regiao, bonus, assiduidade, dependentes);

            funcionarios.add(f);
        }

        stat.close();
        rs.close();

        return funcionarios;
    }

    @Override
    public void editarFuncionario(Collection<Funcionario> c, Funcionario f) throws Exception {

        String query = "UPDATE funcionario SET "
                + "nome = '" + f.getNome() + "',"
                + "telefone = '" + f.getTelefone() + "',"
                + "salario = '" + f.getSalarioBase() + "',"
                + "salarioBonus = '" + f.getSalarioComBonus() + "',"
                + "assiduidade = '" + f.getAssiduidade() + "',"
                + "cargo = '" + f.getCargo() + "',"
                + "regiao = '" + f.getRegiao() + "',"
                + "dependentes = '" + f.getNumeroDependentes() + "' WHERE idFuncionario = " + f.getId();

        updateDB(query);

        String queryDelete = "DELETE FROM bonusFuncionario where idFuncionario = " + f.getId();

        updateDB(queryDelete);

        int id = 0;
        for (int i = 0; i < f.getBonus().size(); i++) {
            String bonusSql = "SELECT idBonus FROM bonus WHERE tipoDeBonus = '" + f.getBonus().get(i).trim() + "'";

            ResultSet rs = querySelect(bonusSql);
            while (rs.next()) {
                id = rs.getInt("idBonus");
            }

            String sqlBonusFuncionario = "INSERT INTO bonusFuncionario (idFuncionario, idBonus) VALUES ('"
                    + f.getId() + "','"
                    + id + "')";

            updateDB(sqlBonusFuncionario);

            rs.close();
        }
    }

    @Override
    public void removerFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception {

        String sql = "DELETE FROM funcionario WHERE idFuncionario = '" + funcionario.getId() + "'";

        updateDB(sql);
    }

    @Override
    public void atualizarStatus(Funcionario f) throws Exception {

        System.out.println("id: " + f.getId());

        String sql = "UPDATE funcionario SET status = 0 WHERE nome = '" + f.getNome() + "'";

        updateDB(sql);
    }

}
