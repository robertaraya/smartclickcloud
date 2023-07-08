package smartclick.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import smartclick.cloud.security.config.AppProperties;
import smartclick.cloud.system.mdb.api.MdbProperties;

@SpringBootApplication
//@EnableMongoAuditing
@EnableConfigurationProperties({AppProperties.class, MdbProperties.class})
public class SmartclickcloudApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SmartclickcloudApplication.class, args);
	}
	
}
