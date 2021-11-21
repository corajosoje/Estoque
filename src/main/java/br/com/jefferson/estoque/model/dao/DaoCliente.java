package br.com.jefferson.estoque.model.dao;

import br.com.jefferson.estoque.model.Cliente;
import br.com.jefferson.estoque.model.Persistable;
import br.jefferson.exeptions.DaoException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author jeffe
 */
public class DaoCliente implements DaoInterface {

    @Override
    public Persistable persist(Persistable object, EntityManager manager) throws DaoException {
        try {
            //TODO Implementar validações

            Object id = getID(object);
            if (id == null) {
                throw new DaoException("ID do objeto Nulo");
            }

            Cliente find = manager.find(Cliente.class, id);
            if (find == null) {
                manager.persist(object);
                return object;
            } else {
                return manager.merge(object);
            }

        } catch (IllegalArgumentException | IllegalAccessException ex) {
            new DaoException(ex);
        }
        throw new DaoException("Retorno improvavel ao persistir");
    }

    public Object getID(Object obj) throws IllegalArgumentException, IllegalAccessException, DaoException {
        Class classe = obj.getClass();
        for (Field declaredField : classe.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(javax.persistence.Id.class)) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);

            }
        }
        throw new DaoException("Não foi possivel acessar o ID do objeto");
    }
}
