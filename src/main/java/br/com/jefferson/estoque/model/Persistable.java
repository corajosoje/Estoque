
package br.com.jefferson.estoque.model;

import br.jefferson.exeptions.DaoException;

/**
 *
 * @author jeffe
 */
public interface Persistable {
    
    public void validade() throws DaoException;
}
