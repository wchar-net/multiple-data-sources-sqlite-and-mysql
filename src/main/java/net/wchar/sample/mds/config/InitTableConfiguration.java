package net.wchar.sample.mds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * init sql script,please delete
 *
 * @author wchar.net
 */
@Configuration
public class InitTableConfiguration {

    private final DataSource mysqlDataSource;

    private final DataSource sqliteDataSource;

    public InitTableConfiguration(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
                                  @Qualifier("sqliteDataSource") DataSource sqliteDataSource) {
        this.mysqlDataSource = mysqlDataSource;
        this.sqliteDataSource = sqliteDataSource;
    }



    @Bean
    public DataSourceInitializer mysqlDataSourceInitializer() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/db/init/mysql.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(mysqlDataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

    @Bean
    public DataSourceInitializer sqliteDataSourceInitializer() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/db/init/sqlite.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(sqliteDataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

}
