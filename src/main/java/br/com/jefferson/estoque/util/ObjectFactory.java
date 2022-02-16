/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.estoque.util;

import br.com.jefferson.estoque.model.dao.*;
import br.com.jefferson.estoque.model.util.JPAConfiguration;
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
    public static final DaoCliente DaoCliente = new DaoCliente();
    public static final DaoTerceiro DaoTerceiro = new DaoTerceiro();
    public static final DaoSku DaoSku = new DaoSku();
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

    public static EntityManager getNewManager() throws DaoException {
        return JPAConfiguration.getEntityManager();
    }

    public static org.apache.logging.log4j.Logger getLogger(Object classe) {
        return LogManager.getLogger(classe.getClass().getName());
    }

   

}
