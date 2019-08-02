package site.blbc;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import site.blbc.entity.SysAccountEntity;
import site.blbc.service.AccountService;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class AppTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void saveTest() {
        Long id = accountService.save(SysAccountEntity.builder().username("abc").build());
        assertNotNull(id);
    }

    @Test
    public void listTest() {
        List<SysAccountEntity> list = accountService.list();
        Assert.assertNotNull(list);
        Assert.assertNotEquals(0, list.size());
    }

}
