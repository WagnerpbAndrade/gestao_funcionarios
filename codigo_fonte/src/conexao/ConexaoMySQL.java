package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author wagner
 */
public final class ConexaoMySQL {

    private String serverName = "localhost";
    private String mydatabase = "funcionariodb";
    private String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    
    private String usuario = "root";
    private String senha = "root";
    
    private String DRIVER = "com.mysql.jdbc.Driver";
    
    private static ConexaoMySQL INSTANCE;
    private Connection conexao = null;
    private Statement stat = null;

    private ConexaoMySQL() {
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, usuario, senha);

            this.stat = conexao.createStatement();

        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public static ConexaoMySQL getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexaoMySQL();
        }

        return INSTANCE;
    }

    public Connection getConexao() {
        return conexao;
    }

    public Statement getStatement() {
        return stat;
    }

    public void closeConexao() throws SQLException {
        this.conexao.close();
    }

    public void closeConexao(Connection c, Statement stat) throws SQLException {
        c.close();
        stat.close();
    }

}
