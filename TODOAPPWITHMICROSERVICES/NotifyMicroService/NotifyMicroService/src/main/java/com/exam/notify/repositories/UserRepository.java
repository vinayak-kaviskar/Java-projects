package com.exam.notify.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exam.notify.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmailIgnoreCase(String username);

	Optional<User> findById(long l);

}
