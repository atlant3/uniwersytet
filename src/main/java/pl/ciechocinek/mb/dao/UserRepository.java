package pl.ciechocinek.mb.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>{
	public Optional<User> findByUserName(String username);
}
