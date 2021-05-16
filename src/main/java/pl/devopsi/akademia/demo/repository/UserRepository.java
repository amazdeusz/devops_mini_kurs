package pl.devopsi.akademia.demo.repository;

import pl.devopsi.akademia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
