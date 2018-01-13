package keolid.profiler.services.io;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import keolid.profiler.services.model.User;


@RequestMapping(value="/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public interface IUserServices {

	@RequestMapping(method=RequestMethod.GET,value="/hello")
	ResponseEntity<String> sayHello();
	
	@RequestMapping(method=RequestMethod.POST,value="/submit")
	ResponseEntity<String> submitUserInfo( User inputUser);
	
}
