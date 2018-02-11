package news.kireeti.bioscope.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kireeti Eluri
 */

@Configuration
@Profile({ "prd" })
@PropertySource({"classpath:data-source.properties"})
@ComponentScan(basePackages = { "news.kireeti.bioscope.services" })
@EnableMongoRepositories(basePackages = "news.kireeti.bioscope.repositories")
public class DataSourceConfig extends AbstractMongoConfiguration {

	@Autowired private Environment env;

	@Override
	public String getDatabaseName(){
		return env.getRequiredProperty("mongo.name");
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"), 31588);
		MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "heroku_6f3xn8cd", "password".toCharArray());
		return new MongoClient(serverAddress, Arrays.asList(credential));
	}

}
