package net.wchar.sample.mds;

import lombok.extern.log4j.Log4j2;
import net.wchar.sample.mds.service.UnifyAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * test springboot application
 *
 * @author wchar.net
 */
@Log4j2
@SpringBootTest
class MDSApplicationTests {

    @Resource
    private UnifyAccountService unifyAccountService;


    /**
     * test find account for mysql
     */
    @Test
    void testFindAccountForMysql() {
        log.info("testFindAccountForMysql: {}", unifyAccountService.findAllAccountForMysql());
    }

    /**
     * test find account for sqlite
     */
    @Test
    void testFindAccountForSqlite() {
        log.info("testFindAccountForSqlite: {}", unifyAccountService.findAllAccountForSqlite());
    }


    @Test
    void testTransactionForSqlite() {
        log.info("testTransactionForSqlite: {}", unifyAccountService.createAccountForSqlite("haha,I am Sqlite"));
    }

    @Test
    void testTransactionForMysql() {
        log.info("testTransactionForMysql: {}", unifyAccountService.createAccountForMysql("haha,I am mysql"));
    }


    @Test
    void contextLoads() {
    }

}
