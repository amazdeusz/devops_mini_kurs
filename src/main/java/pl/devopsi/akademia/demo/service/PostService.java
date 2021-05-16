package pl.devopsi.akademia.demo.service;

import pl.devopsi.akademia.demo.model.Post;
import pl.devopsi.akademia.demo.repository.PostRepository;
import pl.devopsi.akademia.demo.service.dto.CreationPostDto;
import pl.devopsi.akademia.demo.service.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
	private final PostRepository postRepository;
	private final UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}


	public PostDto findPostById(Long id) {
		var post = this.postRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Not found post by id"));
		return new PostDto(post);
	}

	public List<PostDto> getAllUsersPost(Long idUser) {
		var posts = postRepository.findAllByUserId(idUser);
		return covert(posts);
	}

	public PostDto createPost(Long userId, CreationPostDto dto) {
		var user = userService.getUserById(userId);
		var post = buildPost(dto);
		post.setUser(user);
		userService.save(user);
		return new PostDto(post);
	}

	private List<PostDto> covert(List<Post> posts) {
		return posts.stream()
				.map(PostDto::new)
				.collect(Collectors.toList());
	}

	private Post buildPost(CreationPostDto creationPostDto) {
		return new Post(creationPostDto.getTitle(), creationPostDto.getText());
	}
}
