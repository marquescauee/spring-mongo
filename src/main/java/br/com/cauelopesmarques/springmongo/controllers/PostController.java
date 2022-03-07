package br.com.cauelopesmarques.springmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.springmongo.domains.Post;
import br.com.cauelopesmarques.springmongo.services.PostService;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

	@Autowired
	private PostService ps;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = ps.findById(id);	
		
		return ResponseEntity.ok().body(post);
	}
}
