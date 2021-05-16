package pl.devopsi.akademia.demo.repository;

import pl.devopsi.akademia.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("from Post p where p.user.id = ?1")
	List<Post> findAllByUserId(Long userId);
}
