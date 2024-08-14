package in.ac.jssate.usermodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> listAll(){
		return repo.findAll();
}
	//retreive by id
	public User get(Integer id) {
		return repo.findById(id).get();
		
	}
	//create
	public void save(User user) {
		repo.save(user);
	}
	//delete by id
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
