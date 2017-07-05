/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcionarios.presenter.apoio;

import java.util.Comparator;
import memento.Funcionario;

/**
 *
 * @author Clayton
 */
public class ComparadorDeTelefoneFuncionario implements Comparator<Funcionario> {
   @Override
   public int compare(Funcionario aPerson, Funcionario anotherPerson) {
      return aPerson.getTelefone().compareTo(anotherPerson.getTelefone());
   }   
}

