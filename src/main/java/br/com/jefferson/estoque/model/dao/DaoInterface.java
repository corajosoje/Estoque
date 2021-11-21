package br.com.jefferson.estoque.model.dao;

import br.com.jefferson.estoque.model.Persistable;
import br.jefferson.exeptions.DaoException;
import javax.persistence.EntityManager;

/**
 *
 * @author jeffe
 */
public interface DaoInterface {

    public Persistable persist(Persistable object, EntityManager manager) throws DaoException;

}
