package clientproyectspring.clientproyectspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import clientproyectspring.clientproyectspring.models.entity.Post;
import clientproyectspring.clientproyectspring.models.service.IPostService;
import clientproyectspring.clientproyectspring.security.CurrentUser;
import clientproyectspring.clientproyectspring.security.UserPrincipal;
import clientproyectspring.clientproyectspring.util.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostResource {

	@Autowired
	private IPostService postService;
	
	@GetMapping
	public List<Post> findAll(){
		return postService.findAll();
	}

	@GetMapping("/me")
	public Page<Post> findAllCreatedBy(@CurrentUser UserPrincipal currentUser, 
			@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
		return postService.findAllCreatedBy(currentUser, page, size);
	}
	
	@PostMapping
	public Post save(@RequestBody Post post){
		return postService.save(post);
	}
	
	@PutMapping("/{postId}")
	public Post update(@PathVariable Long postId, @RequestBody Post post){
		return postService.update(postId, post);
	}
	
	@DeleteMapping("/{postId}")
	public void delete(@PathVariable Long postId){
		postService.delete(postId);
	}
}
