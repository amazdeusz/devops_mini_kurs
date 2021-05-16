package pl.devopsi.akademia.demo.controller;


import pl.devopsi.akademia.demo.service.UserService;
import pl.devopsi.akademia.demo.service.dto.CreationUserDto;
import pl.devopsi.akademia.demo.service.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	private UserDto getUserById(@PathVariable Long id) {
		return userService.getUserByIdDto(id);
	}

	@GetMapping
	private List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private UserDto createUser(@RequestBody CreationUserDto dto) {
		return userService.createUser(dto);
	}


}
