package pl.ciechocinek.mb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.ciechocinek.mb.domain.User;

@Transactional 
@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {
	public Optional<User> findByUserName(String username);

	@Query(value = "SELECT * FROM user u WHERE u.user_name = :name", nativeQuery = true)
	public User getByUsername(@Param("name") String userName);

	@Query(value = "SELECT * FROM user u WHERE u.role = 1 and u.status = 1", nativeQuery = true)
	public List<User> findAllOnlyStudents();
	
	@Query(value = "SELECT * FROM user u WHERE u.role = 1 and u.status = 1 and u.faculty_id = :facultyID ORDER BY u.amount DESC LIMIT :limitFaculty", nativeQuery = true)
	public List<User> getStudentsByFacultyId(Long facultyID, int limitFaculty);
	
	@Modifying
	@Query(value = "UPDATE user u SET u.status = 3 where u.status = 1", nativeQuery = true)
	public void setStatusSorry();
}
