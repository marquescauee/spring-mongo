package br.com.cauelopesmarques.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.springmongo.domains.User;
import br.com.cauelopesmarques.springmongo.dto.UserDTO;
import br.com.cauelopesmarques.springmongo.repositories.UserRepository;
import br.com.cauelopesmarques.springmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = ur.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontado"));
	}
	
	public User insert(User user) {
		return ur.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		ur.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		
		return ur.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
