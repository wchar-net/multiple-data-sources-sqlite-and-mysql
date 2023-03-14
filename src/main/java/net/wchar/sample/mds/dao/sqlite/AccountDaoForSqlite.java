package net.wchar.sample.mds.dao.sqlite;


import net.wchar.sample.mds.model.po.AccountPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Account Dao For Sqlite
 *
 * @author wchar.net
 */
@Mapper
public interface AccountDaoForSqlite {
    List<AccountPo> findAllAccount();

    Integer createAccount(String accountName);
}
