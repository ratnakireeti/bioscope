package news.kireeti.bioscope.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kireeti Eluri
 */

@Configuration
@PropertySource("classpath:test-blog.properties")
public class TestApplicationConfig {
}
