package pl.ciechocinek.mb.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.ciechocinek.mb.dao.UserRepository;
import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	FacultyService facultyService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

//	@PostConstruct
//	public void addFirstUser() throws IOException {
//		userRepository.save(new User("admin", "admin", "admin", bCryptPasswordEncoder.encode("admin"), 25, 4, 4, UserRole.ROLE_ADMIN));
//	}
	// add a new user to DataBase
	public void save(User user, MultipartFile file) throws IOException {
		logger.info("Register new user {} : " + user.getUserName());
		user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	// Update user by user
	public void saveOnlyUser(User user) {
		logger.info("Register new user {} : " + user.getUserName());
		userRepository.save(user);
	}

	// Get User by userName
	public User findByUserName(String username) {
		logger.info("Get user {} by email: " + username);
		return userRepository.findByUserName(username).get();
	}

	public User getByUsername(String username) {
		logger.info("Get user {} by email: " + username);
		return userRepository.getByUsername(username);
	}

	// show all students
	public List<User> findAllStudents() {
		logger.info("Find all Students ");
		return userRepository.findAllOnlyStudents();
	}

	// Delete user from DataBase by ID
	public void deleteUser(Long id) {
		logger.info("Delete user by ID: " + id);
		userRepository.deleteById(id);
	}

	// Get user by id
	public User getUserById(Long id) {
		logger.info("GET user by ID: " + id);
		return userRepository.getOne(id);
	}

	public void acceptStudentsToFaculty() {
		List<Faculty> faculties = facultyService.listOfFaculty();
		System.out.println(faculties.size());
		for (Faculty faculty : faculties) {
			List<User> students = userRepository.getStudentsByFacultyId(faculty.getId(), faculty.getLimitAmount());
			for (User student : students) {
				student.setStatus(2);
				saveOnlyUser(student);
			}
		}

	}

	public List<User> getStudentsByFacultyId(Long id, int limitAmount) {
		return userRepository.getStudentsByFacultyId(id, limitAmount);
	}

	public void setStatusSorry() {
		userRepository.setStatusSorry();
	}

}
