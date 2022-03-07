package br.com.cauelopesmarques.springmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.springmongo.domains.Post;
import br.com.cauelopesmarques.springmongo.repositories.PostRepository;
import br.com.cauelopesmarques.springmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository pr;
	
	public Post findById(String id) {
		Optional<Post> post = pr.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontado"));
	}
}
