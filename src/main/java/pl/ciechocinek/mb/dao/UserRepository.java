package pl.ciechocinek.mb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>{
	public Optional<User> findByUserName(String username);
	
	@Query(value = "SELECT * FROM user u WHERE u.role = 1",nativeQuery = true)
	public List<User> findAllOnlyStudents();
} 
