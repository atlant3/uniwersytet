package pl.ciechocinek.mb.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

//	@PostConstruct
//	public void addFirstUser() {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String pass = passwordEncoder.encode("admin");
//		User user = new User("Maks", "Maks", "maks", pass, 20, 1, 200, UserRole.ROLE_USER);
//		userRepository.save(user);
//	}
	//add a new user to DataBase
	public void save(User user) {
//		logger.info("Register new user {} : " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	public User findByUserName(String username) {
		logger.info("Get user {} by email: " + username);
		return userRepository.findByUserName(username).get();
	}
}
