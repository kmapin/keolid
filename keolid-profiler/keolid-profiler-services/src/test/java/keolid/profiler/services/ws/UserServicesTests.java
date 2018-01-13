package keolid.profiler.services.ws;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import keolid.profiler.services.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserServicesTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesTests.class);
	final static String HOST_PORT="http://localhost:8080";

	RestTemplate restTemplate=new RestTemplate();
	private MediaType jsonContentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
										            MediaType.APPLICATION_JSON.getSubtype(),
										            Charset.forName("utf8"));
	private MediaType textContentType = new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),
            Charset.forName("utf8"));
	
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

         }
//	@Test
//	public void testUserHello(){
//		ResponseEntity<String> response =	restTemplate.getForEntity(HOST_PORT+"/user/hello", String.class);
//		LOGGER.info(response.toString());
//		Assert.assertEquals( response.getStatusCode(), HttpStatus.OK);
//		Assert.assertTrue(response.toString().contains("developpement") );
//
//	}
	
	@Test
	public void testUserHello(){
		 try {
			mockMvc.perform(get(HOST_PORT+"/user/hello"))
			            .andExpect(status().isOk())
			            .andExpect(content().contentType(textContentType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
    
   
	@Test
	public void testSubmitUser(){
		try {
			String userJson = json(new User("Constant","Konate","kc@gmail.com","0909098877"));
			String creatorId="system";
			
			this.mockMvc.perform(post(HOST_PORT+"/user/submit" )
					.contentType(jsonContentType)
					.accept(jsonContentType)
					.content(userJson))
			.andExpect(status().isCreated());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        

	}
	 @Autowired
	    void setConverters(HttpMessageConverter<?>[] converters) {

	        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
	            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
	            .findAny()
	            .orElse(null);

	        assertNotNull("the JSON message converter must not be null",
	                this.mappingJackson2HttpMessageConverter);
	    }
	protected String json(Object o) throws IOException, HttpMessageNotWritableException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}