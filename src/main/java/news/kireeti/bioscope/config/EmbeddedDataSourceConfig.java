package news.kireeti.bioscope.config;

import com.mongodb.Mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

/**
 * @author Kireeti Eluri
 */
@Configuration
@Profile({ "dev", "default" })
@ComponentScan(basePackages = { "news.kireeti.bioscope.services" })
@EnableMongoRepositories(basePackages = "news.kireeti.bioscope.repositories")
public class EmbeddedDataSourceConfig {

    @Bean(destroyMethod = "close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder().build();
    }

    @Bean
    public MongoTemplate mongoTemplate(Mongo mongo){
        return new MongoTemplate(mongo, "blog");
    }

}
