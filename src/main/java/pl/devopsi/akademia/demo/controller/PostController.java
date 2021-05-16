package pl.devopsi.akademia.demo.controller;


import pl.devopsi.akademia.demo.service.PostService;
import pl.devopsi.akademia.demo.service.dto.CreationPostDto;
import pl.devopsi.akademia.demo.service.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts/{id}")
	private PostDto getPostById(@PathVariable Long id) {
		return postService.findPostById(id);
	}

	@GetMapping("/users/{idUser}/posts")
	private List<PostDto> getPostUser(@PathVariable Long idUser) {
		return postService.getAllUsersPost(idUser);
	}

	@PostMapping("/users/{idUser}/posts")
	@ResponseStatus(HttpStatus.CREATED)
	private PostDto createPostUsers(@PathVariable Long idUser, @RequestBody CreationPostDto dto) {
		return postService.createPost(idUser, dto);
	}
}
