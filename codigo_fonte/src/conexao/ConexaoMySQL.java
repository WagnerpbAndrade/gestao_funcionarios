package conexao;

import java.sql.Statement;

/**
 *
 * @author wagner
 */
public final class ConexaoMySQL extends ConexaoAbstract {

    private static ConexaoMySQL INSTANCE;

    public static ConexaoMySQL getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexaoMySQL();
        }

        return INSTANCE;
    } 

    public Statement getStatement() {
        return this.stat;
    }

}
