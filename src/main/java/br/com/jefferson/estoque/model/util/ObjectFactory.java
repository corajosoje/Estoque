/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.estoque.model.util;

import br.com.jefferson.estoque.model.dao.DaoCliente;
import br.com.jefferson.estoque.model.dao.DaoInterface;
import br.jefferson.exeptions.DaoException;
import br.jefferson.validators.CpfCnpj;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author jeffe
 */
public class ObjectFactory extends br.jefferson.util.ObjectFactory {

    //private ObjectFactory factory = br.com.jefferson.estoque.model.util.ObjectFactory.getInstance();
    public static final SimpleDateFormat UTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    public static final SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
    public static final DaoCliente _DaoCliente = new DaoCliente();
    private static ObjectFactory facotory = null;
    public static final CpfCnpj validadorCNPJ = new CpfCnpj();

    public static ObjectFactory getInstance() {
        if (facotory == null) {
            facotory = new ObjectFactory();
        }
        return facotory;
    }

    public CpfCnpj getValidadorCNPJ() {
        return validadorCNPJ;
    }

    public EntityManager getNewManager() throws DaoException {
        return JPAConfiguration.getEntityManager();
    }

    public org.apache.logging.log4j.Logger getLogger(Object classe) {
        return LogManager.getLogger(classe.getClass().getName());
    }

    public DaoCliente getDaoCliente() {
        return _DaoCliente;
    }

}
