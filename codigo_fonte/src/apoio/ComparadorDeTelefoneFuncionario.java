/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package apoio;

import model.AbstractFuncionario;
import java.util.Comparator;

/**
 *
 * @author Clayton
 */
public class ComparadorDeTelefoneFuncionario implements Comparator<AbstractFuncionario> {
   @Override
   public int compare(AbstractFuncionario aPerson, AbstractFuncionario anotherPerson) {
      return aPerson.getTelefone().compareTo(anotherPerson.getTelefone());
   }   
}

