/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author wagner
 */
public interface IPersistenciaDAO {

    public String obterPersistenciaSalva() throws Exception;

    public void atualizarPersistenciaSalva(String nome) throws Exception;
    
    public String obterLogSalvo() throws Exception;

    public void atualizarLogSalvo(String nome) throws Exception;
}
