package net.wchar.sample.mds.service.impl;

import net.wchar.sample.mds.dao.mysql.AccountDaoForMysql;
import net.wchar.sample.mds.dao.sqlite.AccountDaoForSqlite;
import net.wchar.sample.mds.model.po.AccountPo;
import net.wchar.sample.mds.service.UnifyAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Unify Account Service Impl
 *
 * @author wchar.net
 */
@Service
public class UnifyAccountServiceImpl implements UnifyAccountService {

    private final AccountDaoForMysql accountDaoForMysql;
    private final AccountDaoForSqlite accountDaoForSqlite;

    public UnifyAccountServiceImpl(AccountDaoForMysql accountDaoForMysql, AccountDaoForSqlite accountDaoForSqlite) {
        this.accountDaoForMysql = accountDaoForMysql;
        this.accountDaoForSqlite = accountDaoForSqlite;
    }

    @Override
    public List<AccountPo> findAllAccountForMysql() {
        return accountDaoForMysql.findAllAccount();
    }

    @Override
    public List<AccountPo> findAllAccountForSqlite() {
        return accountDaoForSqlite.findAllAccount();
    }

    @Override
    @Transactional(value = "mysqlTransactionManager", rollbackFor = Exception.class)
    public Boolean createAccountForMysql(String accountName) {
        Integer result = accountDaoForMysql.createAccount(accountName);

        //analog anomaly for mysql
        int n = 1 / 0;

        return result > 0;
    }

    @Override
    @Transactional(value = "sqliteTransactionManager", rollbackFor = Exception.class)
    public Boolean createAccountForSqlite(String accountName) {
        Integer result = accountDaoForMysql.createAccount(accountName);

        //analog anomaly for sqlite
        int n = 1 / 0;

        return result > 0;
    }


}
