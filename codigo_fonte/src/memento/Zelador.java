package memento;

import java.util.ArrayList;
import model.FuncionarioMemento;

/**
 *
 * @author Wagner Andrade
 */
public class Zelador {

    private ArrayList<FuncionarioMemento> estados = new ArrayList<>();
    private static Zelador INSTANCE;

    private Zelador() {

    }

    public static Zelador getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Zelador();
        }

        return INSTANCE;
    }

    public void addMemento(FuncionarioMemento memento) {
        this.estados.add(memento);
    }

    public FuncionarioMemento getUltimoSalvo() {
        FuncionarioMemento estadoSalvo = this.estados.get(this.estados.size() - 1);
        this.estados.remove(this.estados.size() - 1);

        return estadoSalvo;
    }

    public int getQtdEstados() {
        return estados.size();
    }

}
