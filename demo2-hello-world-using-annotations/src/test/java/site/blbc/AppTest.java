package site.blbc;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import site.blbc.entity.SysAccountEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            log.error("创建 SessionFactory 失败！", e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void saveTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SysAccountEntity sysAccountEntity = SysAccountEntity.builder()
                .name("test").username("test").password("test").birthday(LocalDate.now()).build();
        Long id = (Long) session.save(sysAccountEntity);
        session.getTransaction().commit();
        session.close();
        Assert.assertNotNull(id);
    }

    @Test
    public void listTest() {
        Session session = sessionFactory.openSession();
        List<SysAccountEntity> list = session.createQuery(" from SysAccountEntity ").list();
        for (SysAccountEntity sysAccountEntity : list) {
            log.info(sysAccountEntity.toString());
        }
    }
}
