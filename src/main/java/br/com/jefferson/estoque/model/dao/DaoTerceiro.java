package br.com.jefferson.estoque.model.dao;

import br.com.jefferson.estoque.model.Persistable;
import br.com.jefferson.estoque.model.reg.Terceiro;
import br.jefferson.exeptions.DaoException;
import java.lang.reflect.Field;
import javax.persistence.EntityManager;

/**
 *
 * @author Jefferson Oliveira
 */
public class DaoTerceiro implements DaoInterface {

    @Override
    public Persistable persist(Persistable persistable, EntityManager manager) throws DaoException {
        try {

            persistable.validade();

            if(!manager.getTransaction().isActive()){
                manager.getTransaction().begin();
            }
            
            Object id = getID(persistable);

            if (id == null) {
                manager.persist(persistable);
                return persistable;
            } else {
                Terceiro find = manager.find(Terceiro.class, id);
                if (find == null) {
                    manager.persist(persistable);
                } else {
                    return manager.merge(persistable);
                }
            }

        } catch (IllegalArgumentException | IllegalAccessException | UnsupportedOperationException ex) {
            new DaoException(ex);
        }
        throw new DaoException("Problema ao persistir");
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
