package br.com.cauelopesmarques.springmongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.springmongo.domains.User;
import br.com.cauelopesmarques.springmongo.dto.UserDTO;
import br.com.cauelopesmarques.springmongo.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = us.findAll();
		
		List<UserDTO> listDTO = list.stream().map(e -> new UserDTO(e)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		
	}
}
