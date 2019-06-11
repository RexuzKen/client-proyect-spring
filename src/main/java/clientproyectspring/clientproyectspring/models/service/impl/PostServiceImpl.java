package clientproyectspring.clientproyectspring.models.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import clientproyectspring.clientproyectspring.exceptions.NotFoundException;
import clientproyectspring.clientproyectspring.models.entity.Post;
import clientproyectspring.clientproyectspring.models.repository.PostRepository;
import clientproyectspring.clientproyectspring.models.service.IPostService;
import clientproyectspring.clientproyectspring.security.UserPrincipal;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	@Override
	public Page<Post> findAllCreatedBy(UserPrincipal currentUser, int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return postRepository.findByCreatedBy(currentUser.getId(), pageable);	
	}

	@Override
	public Post save(Post post) {
		post.setId(null);
		return postRepository.save(post);
	}

	@Override
	public Post update(Long id, Post post) {
		
		Post postAux = postRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("Post with id " + id + " not found"));
		
		post.setId(id);
		post.setCreatedBy(postAux.getCreatedBy());
		post.setCreatedAt(postAux.getCreatedAt());

		return postRepository.save(post);
		
	}

	@Override
	public void delete(Long id) {
		postRepository.findById(id)
		.orElseThrow(() -> new NotFoundException("Post with id " + id + " not found"));
		postRepository.deleteById(id);
	}

}
