package site.blbc;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import site.blbc.entity.SysAccountEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("localhost.mysql");
    }

    @AfterClass
    public static void tearDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void persistTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        SysAccountEntity sysAccountEntity =
                SysAccountEntity.builder().name("lna").username("lna").password("lna").birthday(LocalDate.now()).build();
        Assert.assertNull(sysAccountEntity.getId());
        entityManager.persist(sysAccountEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(sysAccountEntity.getId());
    }
}
