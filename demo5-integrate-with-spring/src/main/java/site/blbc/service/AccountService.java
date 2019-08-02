package site.blbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.blbc.dao.AccountDao;
import site.blbc.entity.SysAccountEntity;

import java.util.List;

/**
 * @description:
 * @author: Ian Zheng
 * @date: 2019-08-02
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public Long save(SysAccountEntity account) {
        return accountDao.save(account);
    }

    public List<SysAccountEntity> list() {
        return accountDao.list();
    }
}
