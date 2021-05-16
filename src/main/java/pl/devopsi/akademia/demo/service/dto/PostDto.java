package pl.devopsi.akademia.demo.service.dto;

import pl.devopsi.akademia.demo.model.Post;

public class PostDto {
	private Long id;
	private String title;
	private String text;

	public PostDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.text = post.getText();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
