package pl.devopsi.akademia.demo.service;

import pl.devopsi.akademia.demo.model.User;
import pl.devopsi.akademia.demo.repository.UserRepository;
import pl.devopsi.akademia.demo.service.dto.CreationUserDto;
import pl.devopsi.akademia.demo.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto getUserByIdDto(Long id) {
		var user = getUserById(id);
		return new UserDto(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Not found user by id"));
	}

	public UserDto createUser(CreationUserDto dto) {
		var user = userRepository.save(buildUser(dto));
		return new UserDto(user);
	}

	public List<UserDto> getAllUsers() {
		return covert(userRepository.findAll());
	}

	public void save(User user) {
		this.userRepository.save(user);
	}

	private List<UserDto> covert(List<User> users) {
		return users.stream()
				.map(UserDto::new)
				.collect(Collectors.toList());
	}

	private User buildUser(CreationUserDto dto) {
		return new User(dto.getName(), dto.getSurname());
	}

}
