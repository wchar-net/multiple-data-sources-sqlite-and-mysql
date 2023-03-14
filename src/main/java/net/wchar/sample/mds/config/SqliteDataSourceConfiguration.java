package net.wchar.sample.mds.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * sqlite datasource config
 *
 * @author wchar.net
 */
@MapperScan(basePackages = {"net.wchar.sample.mds.dao.sqlite"}, sqlSessionFactoryRef = "sqliteSqlSessionFactory")
@Configuration
public class SqliteDataSourceConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.sqlite")
    public HikariConfig sqliteHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource sqliteDataSource(@Qualifier("sqliteHikariConfig") HikariConfig sqliteHikariConfig) {
        return new HikariDataSource(sqliteHikariConfig);
    }


    @Primary
    @Bean
    public SqlSessionFactory sqliteSqlSessionFactory(@Qualifier("sqliteDataSource") DataSource sqliteDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(sqliteDataSource);

        //print log
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);

        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mappers/sqlite/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate sqliteSqlSessionTemplate(@Qualifier("sqliteSqlSessionFactory") SqlSessionFactory sqliteSqlSessionFactory) {
        return new SqlSessionTemplate(sqliteSqlSessionFactory);
    }

    @Primary
    @Bean
    public DataSourceTransactionManager sqliteTransactionManager(@Qualifier("sqliteDataSource") DataSource sqliteDataSource) {
        return new DataSourceTransactionManager(sqliteDataSource);
    }
}
