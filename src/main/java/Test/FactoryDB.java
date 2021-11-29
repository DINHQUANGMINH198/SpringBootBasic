package Test;

//import minhdq.demo.springboot.DemoApplication;
import minhdq.demo.springboot.common.DBSelection;
import minhdq.demo.springboot.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class FactoryDB  {
    @Bean
    public static AbstractDB getDB() {
        Logger log = LoggerFactory.getLogger(FactoryDB.class);
        Properties prop= new Properties();
        InputStream input;
        try {
            input = new FileInputStream("src/main/java/Test/config/config.properties");
            // load a properties file
            prop.load(input);
            // get the database value
            int database = Integer.parseInt(prop.getProperty("database"));
            if (database == DBSelection.mysql) {
                return new MysqlDB();
            }
            if (database == DBSelection.mongo) {
                return new MongoDB();
            }

        } catch (IOException ex) {
            log.error(ex.getMessage());
            return null;
        }
        return null;
    }

}

