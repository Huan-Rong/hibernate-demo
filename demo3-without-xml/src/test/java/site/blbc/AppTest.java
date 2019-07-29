package site.blbc;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import site.blbc.entity.SysAccountEntity;

import java.util.List;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        Properties properties = new Properties();
        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/test?useSSL=false");
        properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.setProperty(Environment.USER, "ian");
        properties.setProperty(Environment.PASS, "ian");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");

        try {
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);

            configuration.addAnnotatedClass(SysAccountEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.error("创建 SessionFactory 失败！", e);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void listTest() {
        Session session = sessionFactory.openSession();
        List<SysAccountEntity> list = session.createQuery(" from SysAccountEntity ").list();
        for (SysAccountEntity sysAccountEntity : list) {
            log.info(sysAccountEntity.toString());
        }
        session.close();
    }
}
