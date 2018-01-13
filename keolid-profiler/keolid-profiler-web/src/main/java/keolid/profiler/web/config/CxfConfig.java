package keolid.profiler.web.config;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import keolid.profiler.services.io.IUserServices;

@Configuration
@ComponentScan(basePackages = "keolid")
public class CxfConfig {
	@Autowired
	private Bus bus;

	@Autowired
	IUserServices usrService;

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setAddress("http://localhost:8080/");
		endpoint.setServiceBeans(Arrays.<Object>asList(usrService));
		endpoint.setProviders(Arrays.asList(jacksonJaxbJsonProvider(), jaxbElementProvider()));
		return endpoint.create();
	}

	@Bean
	public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
		return new JacksonJaxbJsonProvider();
	}

	@Bean
	public JAXBElementProvider jaxbElementProvider() {
		return new JAXBElementProvider();
	}
}