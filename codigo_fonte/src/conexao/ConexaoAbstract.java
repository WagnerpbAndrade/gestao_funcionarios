package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wagner
 */
public abstract class ConexaoAbstract {

    private String serverName;
    private String database;
    private String porta;
    private String usuario;
    private String senha;
    private String url;

    private String DRIVER = "com.mysql.jdbc.Driver";

    private Connection conexao = null;
    Statement stat = null;

    public ConexaoAbstract() {}

    public ConexaoAbstract(String serverName, String database, String porta, String usuario, String senha) {
        this.serverName = serverName;
        this.database = database;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;

        this.url = "jdbc:mysql:" + this.porta + "//" + this.serverName + "/" + this.database;
    }

    public void criarConexao() throws Exception {

        Class.forName(DRIVER);
        
        this.conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);

        this.stat = this.conexao.createStatement();
        
    }

    public Connection getConexao() {
        return conexao;
    }

    public void closeConexao() throws SQLException {
        this.conexao.close();
    }

    public void closeConexao(Connection c, Statement stat) throws SQLException {
        c.close();
        stat.close();
    }

}
