package com.joaopaulo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaopaulo.workshopmongo.domain.Post;
import com.joaopaulo.workshopmongo.repository.PostRepository;
import com.joaopaulo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
