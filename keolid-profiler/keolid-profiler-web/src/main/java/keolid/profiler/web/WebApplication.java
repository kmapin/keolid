package keolid.profiler.web;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
 
@EnableJaxRsWebClient
@SpringBootApplication
public class WebApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	CommandLineRunner initWebClientRunnerForGet(final WebClient webClient) {

		return new CommandLineRunner() {

			@Override
			public void run(String... runArgs) throws Exception {
				LOGGER.info(webClient.path("/user/hello").get(String.class));
			}
		};
	}


}