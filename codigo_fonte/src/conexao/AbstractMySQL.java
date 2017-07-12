package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author paula
 */
public abstract class AbstractMySQL {

    public ResultSet querySelect(String sql) throws SQLException {
        ConexaoMySQL conexao = ConexaoMySQL.getInstance();
        Statement st = conexao.getStatement();
        return st.executeQuery(sql);
    }

    public int updateDB(String sql) throws SQLException {
        ConexaoMySQL conexao = ConexaoMySQL.getInstance();
        Statement st = conexao.getStatement();
        return st.executeUpdate(sql);
    }

}
