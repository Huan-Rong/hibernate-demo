package site.blbc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.blbc.entity.SysAccountEntity;

import java.util.List;

/**
 * @description:
 * @author: Ian Zheng
 * @date: 2019-08-02
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(SysAccountEntity account) {
        return (Long) sessionFactory.openSession().save(account);
    }

    @Override
    public List<SysAccountEntity> list() {
        return sessionFactory.openSession().createQuery(" from SysAccountEntity ").list();
    }
}
