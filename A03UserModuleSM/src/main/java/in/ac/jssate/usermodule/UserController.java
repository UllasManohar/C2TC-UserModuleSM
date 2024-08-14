package in.ac.jssate.usermodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> list(){
		return service.listAll();
	}
	
	//retreivebyid
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		try {
			User user = service.get(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	//create
	@PostMapping("/users")
	public void add(@RequestBody User user) {
		service.save(user);
	}
	
	//update
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody User user){
		try {
			User euser = service.get(id);
			service.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
		@DeleteMapping("/users/{id}")
		public void delete(@PathVariable Integer id) {
			service.delete(id);	
		}
		
	}
	
	


