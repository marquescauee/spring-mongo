package br.com.cauelopesmarques.springmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.springmongo.domains.User;
import br.com.cauelopesmarques.springmongo.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = us.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
}
