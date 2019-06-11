package clientproyectspring.clientproyectspring.models.service;

import java.util.List;

import org.springframework.data.domain.Page;

import clientproyectspring.clientproyectspring.models.entity.Post;
import clientproyectspring.clientproyectspring.security.UserPrincipal;

public interface IPostService {

	List<Post> findAll();
	
	Page<Post> findAllCreatedBy(UserPrincipal currentUser, int page, int size);
	
	Post save(Post post);
	
	Post update(Long id, Post post);
	
	void delete(Long id);
}
