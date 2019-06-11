package clientproyectspring.clientproyectspring.models.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import clientproyectspring.clientproyectspring.models.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	Page<Post> findByCreatedBy(Long userId, Pageable pageable);
}
