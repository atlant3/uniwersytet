package pl.ciechocinek.mb.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.ciechocinek.mb.dao.UserRepository;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	// add a new user to DataBase
	public void save(User user, MultipartFile file) throws IOException {
//		logger.info("Register new user {} : " + user);
		user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	public void saveOnlyUser(User user) {
		userRepository.save(user);
	}

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
		return userRepository.findAllOnlyStudents();
	}

	// Delete user from DataBase by ID
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

}
