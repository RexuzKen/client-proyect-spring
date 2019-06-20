package clientproyectspring.clientproyectspring.models.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import clientproyectspring.clientproyectspring.exceptions.NotFoundException;
import clientproyectspring.clientproyectspring.exceptions.ResourceNotFoundException;
import clientproyectspring.clientproyectspring.models.entity.Post;
import clientproyectspring.clientproyectspring.models.entity.User;
import clientproyectspring.clientproyectspring.models.repository.PostRepository;
import clientproyectspring.clientproyectspring.models.repository.UserRepository;
import clientproyectspring.clientproyectspring.models.service.IPostService;
import clientproyectspring.clientproyectspring.payload.PagedResponse;
import clientproyectspring.clientproyectspring.payload.PostResponse;
import clientproyectspring.clientproyectspring.payload.UserProfile;
import clientproyectspring.clientproyectspring.security.UserPrincipal;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<PostResponse> findAll() {
		List<PostResponse> postsResponse = new ArrayList<PostResponse>();
		List<Post> posts = postRepository.findAll();
		posts.forEach(post -> {
			PostResponse postResponse = new PostResponse();
			postResponse.setId(post.getId());
			postResponse.setDescription(post.getDescription());
			postResponse.setCreatedAt(post.getCreatedAt());
			
			Long userId = post.getCreatedBy();
			User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
			UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());
			postResponse.setUserProfile(userProfile);
			
			postsResponse.add(postResponse);
		});
		
		return postsResponse;
	}
	
	@Override
	public Page<PostResponse> findAllCreatedBy(UserPrincipal currentUser, int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Post> posts =  postRepository.findByCreatedBy(currentUser.getId(), pageable);
		
		List<PostResponse> postsResponse = new ArrayList<PostResponse>();
		posts.forEach(post -> {
			PostResponse postResponse = new PostResponse();
			postResponse.setId(post.getId());
			postResponse.setDescription(post.getDescription());
			postResponse.setCreatedAt(post.getCreatedAt());
			
			Long userId = post.getCreatedBy();
			User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
			UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());
			postResponse.setUserProfile(userProfile);
			
			postsResponse.add(postResponse);
		});
		
		return new PageImpl<>(postsResponse, pageable, posts.getTotalElements());
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
