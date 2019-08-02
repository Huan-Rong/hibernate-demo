package site.blbc.dao;

import site.blbc.entity.SysAccountEntity;

import java.util.List;

/**
 * @description:
 * @author: Ian Zheng
 * @date: 2019-08-02
 */
public interface AccountDao {

    Long save(SysAccountEntity account);

    List<SysAccountEntity> list();
}
