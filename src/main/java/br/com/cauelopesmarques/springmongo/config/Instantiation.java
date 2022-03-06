package br.com.cauelopesmarques.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.cauelopesmarques.springmongo.domains.User;
import br.com.cauelopesmarques.springmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository ur;
	
	@Override
	public void run(String... args) throws Exception {
		ur.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		ur.saveAll(Arrays.asList(maria, alex, bob));
	}

}
