package model;

/**
 *
 * @author wagner
 */
public class Log {
    private String msg;
    private String dataHora;
    private String tipoOperacao;

    public Log(String tipoOperacao, String msg, String dataHora) {
        this.msg = msg;
        this.dataHora = dataHora;
        this.tipoOperacao = tipoOperacao;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    @Override
    public String toString() {
        return tipoOperacao + "," + msg + "," + dataHora;
    }
    
    
           
}
