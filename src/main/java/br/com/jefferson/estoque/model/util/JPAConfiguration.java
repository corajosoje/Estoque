/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.estoque.model.util;

import br.jefferson.exeptions.DaoException;
import br.jefferson.util.LeitorProperties;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jeffe
 */
public class JPAConfiguration {

    private static LeitorProperties vLeitorProperties = null;
    private static final ObjectFactory factory = ObjectFactory.getInstance();
    private static EntityManagerFactory emf = null;
    private static String PERSISTENCE_UNIT = null;
    private static String IP = null;
    private static String USER = null;
    private static String SENHA = null;
    private static String PORTA = null;
    private static String BANCO = null;

    public JPAConfiguration() {

    }

    private static void load() {
        vLeitorProperties = factory.getLeitorPropertiesInstance();
        vLeitorProperties.lerPropertiesAtResource("/aplication.properties");
        PERSISTENCE_UNIT = vLeitorProperties.getResouceValor("prop.server.persistenceUnit");
        IP = vLeitorProperties.getResouceValor("prop.server.ip");
        USER = vLeitorProperties.getResouceValor("prop.server.user");
        SENHA = vLeitorProperties.getResouceValor("prop.server.password");
        PORTA = vLeitorProperties.getResouceValor("prop.server.port");
        BANCO = vLeitorProperties.getResouceValor("prop.server.schema");
    }

    public static EntityManager getEntityManager() throws DaoException {
        if (emf == null) {
            createEntityManagerFactory();
        }
        if (emf.isOpen()) {
            return emf.createEntityManager();
        } else {
            createEntityManagerFactory();
            return emf.createEntityManager();
        }
    }

    public static EntityManagerFactory createEntityManagerFactory() throws DaoException {
        load();
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + IP + ":"
               + PORTA + "/" + BANCO + "?allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true");
        properties.put("javax.persistence.jdbc.user", USER);
        properties.put("javax.persistence.jdbc.password", SENHA);
        properties.put("hibernate.connection.useSSL", "false");
        properties.put("hibernate.connection.serverTimezone", "UTC");
        //properties.put("openjpa.MetaDataFactory", "jpa(Types=" + classNames + ")");

       properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
       emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
        return emf;

    }

}
