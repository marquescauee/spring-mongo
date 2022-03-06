package br.com.cauelopesmarques.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.springmongo.domains.User;
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
}
