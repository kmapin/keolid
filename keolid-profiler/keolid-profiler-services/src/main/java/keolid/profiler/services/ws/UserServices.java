package keolid.profiler.services.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import keolid.profiler.services.io.IUserServices;
import keolid.profiler.services.model.User;

@RestController
public class UserServices implements IUserServices{

	@Value( "${webservices.hello.message}" )
	private String welcomMessage;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServices.class);
	
	@Override
	
	public ResponseEntity<String> sayHello() {
		 
		 LOGGER.info("toc toc toc "+welcomMessage);
		 ResponseEntity<String> resp=new ResponseEntity<String>(welcomMessage,HttpStatus.OK);
		 return resp;
		 
	}

	@Override

	public ResponseEntity<String> submitUserInfo(  @RequestBody User inputUser) {
		LOGGER.info("Call user submit ==>"+inputUser.toString());
		 ResponseEntity<String> resp=new ResponseEntity<String>("submit called",HttpStatus.CREATED);
		
		return resp;
	}

}
