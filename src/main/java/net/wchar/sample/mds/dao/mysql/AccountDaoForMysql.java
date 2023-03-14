package net.wchar.sample.mds.dao.mysql;

import net.wchar.sample.mds.model.po.AccountPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Account Dao For Mysql
 *
 * @author wchar.net
 */
@Mapper
public interface AccountDaoForMysql {

    List<AccountPo> findAllAccount();

    Integer createAccount(@Param("accountName") String accountName);
}
