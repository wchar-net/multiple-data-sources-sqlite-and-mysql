package net.wchar.sample.mds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybaits multiple data sources:  sqlite  mysql
 *
 * @author wchar.net
 */
@SpringBootApplication
public class MDSApplication {

    public static void main(String[] args) {
        SpringApplication.run(MDSApplication.class, args);
    }

}
