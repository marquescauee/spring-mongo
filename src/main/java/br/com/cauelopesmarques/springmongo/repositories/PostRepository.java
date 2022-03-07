package br.com.cauelopesmarques.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cauelopesmarques.springmongo.domains.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
