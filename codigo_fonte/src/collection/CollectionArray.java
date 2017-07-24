package collection;

import iterator.IteratorArray;
import iterator.IteratorIF;
import managementcollaborators.Collaborator;
import managementcollaborators.ManagementCollaboratorsSystem;

/**
 *
 * @author Wagner
 */
public class CollectionArray implements ICollection{
    
    private Collaborator collaboratorSelecionado;
    Collaborator[] vetor;

    public CollectionArray() {
        this.vetor = ManagementCollaboratorsSystem.getCollaborators();
    }

    @Override
    public IteratorIF criaIterator() {
        return new IteratorArray(vetor);
    }

    public Collaborator getCollaboratorSelecionado() {
        return collaboratorSelecionado;
    }

    public void setCollaboratorSelecionado(Collaborator collaboratorSelecionado) {
        this.collaboratorSelecionado = collaboratorSelecionado;
    }
    
}
