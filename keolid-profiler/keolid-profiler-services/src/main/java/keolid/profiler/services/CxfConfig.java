package keolid.profiler.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = "keolid")
public class CxfConfig {

	
//  @Autowired
//  private Bus bus;

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	 
//  @Bean
//  public Server rsServer() {
//    final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
//    endpoint.setProvider(new JacksonJsonProvider());
////    endpoint.setProvider(getExceptionHandler());
//    endpoint.setBus(bus);
//    endpoint.setAddress("/");
//    endpoint.setServiceBeans(Arrays.<Object>asList(new UserServices()));
//    endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
//    return endpoint.create();
//  }

//  @Bean
//  public ExceptionHandler getExceptionHandler() {
//    return new ExceptionHandler();
//  }

//  @Bean
//  public UserServices indexController() {
//    return new UserServices();
//  }

}