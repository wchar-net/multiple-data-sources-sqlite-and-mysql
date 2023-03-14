package net.wchar.sample.mds.service;


import net.wchar.sample.mds.model.po.AccountPo;

import java.util.List;

/**
 * Unify Account Service
 *
 * @author wchar.net
 */
public interface UnifyAccountService {

    List<AccountPo> findAllAccountForMysql();

    List<AccountPo> findAllAccountForSqlite();

    Boolean createAccountForMysql(String accountName);

    Boolean createAccountForSqlite(String accountName);
}
