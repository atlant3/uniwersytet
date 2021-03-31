package pl.ciechocinek.mb.app;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import pl.ciechocinek.mb.dao.FacultyRepository;
import pl.ciechocinek.mb.dao.ResultRepository;
import pl.ciechocinek.mb.dao.SubjectRepository;
import pl.ciechocinek.mb.dao.UserRepository;
import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.Result;
import pl.ciechocinek.mb.domain.Subject;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;
import pl.ciechocinek.mb.service.FacultyService;
import pl.ciechocinek.mb.service.ResultService;
import pl.ciechocinek.mb.service.SubjectService;
import pl.ciechocinek.mb.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private ResultService resultService;

	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Bilozir");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getUserName().equals(user.getUserName()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}

	@Test
	public void testFindByUserName() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Maksym");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);

		User findByUserName = userService.findByUserName(user.getUserName());

		assertTrue(findByUserName.getUserName().equals(user.getUserName()));
		assertTrue(findByUserName.getFirstName().equals(user.getFirstName()));
		assertTrue(findByUserName.getLastName().equals(user.getLastName()));
		assertTrue(findByUserName.getRole().equals(user.getRole()));
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Maksym");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		User user2 = new User();
		user2.setUserName("igor");
		user2.setFirstName("Igor");
		user2.setLastName("admin");
		user2.setPassword("admin");
		user2.setRole(UserRole.ROLE_USER);
		user2.setAge(18);
		user2.setAmount(100);

		userRepository.saveAll(Arrays.asList(user, user2));

		users = userRepository.findAll();
		assertThat(users).hasSize(2);

		List<User> usersFromDb = userRepository.findAll();

		assertTrue(usersFromDb.get(0).getUserName().equals(user.getUserName()));
		assertTrue(usersFromDb.get(0).getFirstName().equals(user.getFirstName()));
		assertTrue(usersFromDb.get(0).getLastName().equals(user.getLastName()));
		assertTrue(usersFromDb.get(0).getRole().equals(user.getRole()));

		assertTrue(usersFromDb.get(1).getUserName().equals(user2.getUserName()));
		assertTrue(usersFromDb.get(1).getFirstName().equals(user2.getFirstName()));
		assertTrue(usersFromDb.get(1).getLastName().equals(user2.getLastName()));
		assertTrue(usersFromDb.get(1).getRole().equals(user2.getRole()));
	}

	@Test
	public void deleteUserById() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Maksym");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);
		userService.saveOnlyUser(user);
		users = userRepository.findAll();
		assertThat(users).hasSize(1);
		userService.deleteUser(user.getId());
		users = userRepository.findAll();
		assertThat(users).hasSize(0);
	}

	@Test
	public void testAcceptStudentsToFaculty() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);
		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Maksym");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);
		user.setStatus(0);
		userService.saveOnlyUser(user);
		users = userRepository.findAll();
		assertThat(users.get(0).getStatus()).isBetween(0, 0);
		users.get(0).setStatus(1);
		User user2 = userRepository.getOne(user.getId());
		assertThat(user2.getStatus()).isBetween(1, 3);
	}

	@Test
	public void testSaveFaculty() {

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties).hasSize(0);

		Faculty faculty = new Faculty();
		faculty.setLimitAmount(200);
		faculty.setName("IT");
		facultyService.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties).hasSize(1);

		Faculty facultyFromDb = faculties.get(0);
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
	}

	@Test
	public void testFindAllFaculties() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties).hasSize(0);

		Faculty faculty = new Faculty();
		faculty.setName("IT");

		Faculty faculty2 = new Faculty();
		faculty2.setName("Social");
		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		faculties = facultyRepository.findAll();
		assertThat(faculties).hasSize(2);

		List<Faculty> facultiesFromDb = facultyRepository.findAll();

		assertTrue(facultiesFromDb.get(0).getName().equals(faculty.getName()));
		assertTrue(facultiesFromDb.get(1).getName().equals(faculty2.getName()));
	}

	@Test
	public void testSaveSubject() {

		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("IT");
		subjectService.save(subject);

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(1);

		Subject subjectFromDb = subjects.get(0);
		assertTrue(subjectFromDb.getName().equals(subject.getName()));
	}

	@Test
	public void testFindAllSubjects() {
		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("Test");

		Subject subject2 = new Subject();
		subject2.setName("History");
		subjectRepository.saveAll(Arrays.asList(subject, subject2));

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(2);

		List<Subject> subjectsFromDb = subjectRepository.findAll();

		assertTrue(subjectsFromDb.get(0).getName().equals(subject.getName()));
		assertTrue(subjectsFromDb.get(1).getName().equals(subject2.getName()));
	}

	@Test
	public void testSaveRasult() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Bilozir");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);

		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("IT");
		subjectService.save(subject);

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(1);

		List<Result> results = resultRepository.findAll();
		assertThat(results).hasSize(0);

		Result result = new Result();
		result.setUser(user);
		result.setSubject(subject);
		resultService.save(result);

		results = resultRepository.findAll();
		assertThat(subjects).hasSize(1);
		Result resultFromDb = results.get(0);

		assertTrue(resultFromDb.getUser().getFirstName().equals(result.getUser().getFirstName()));
		assertTrue(resultFromDb.getUser().getLastName().equals(result.getUser().getLastName()));
		assertTrue(resultFromDb.getUser().getUserName().equals(result.getUser().getUserName()));

	}

	@Test
	public void testGetResultByUserId() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Bilozir");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);
		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("IT");
		subjectService.save(subject);

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(1);

		List<Result> results = resultRepository.findAll();
		assertThat(results).hasSize(0);

		Result result = new Result();
		result.setUser(user);
		result.setSubject(subject);
		resultService.save(result);

		results = resultRepository.findAll();
		assertThat(subjects).hasSize(1);
		Result resultFromDb = results.get(0);
		assertTrue(resultFromDb.getUser().getId().equals(result.getUser().getId()));

	}

	@Test
	public void testGetResultById() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Bilozir");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);
		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("IT");
		subjectService.save(subject);

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(1);

		List<Result> results = resultRepository.findAll();
		assertThat(results).hasSize(0);

		Result result = new Result();
		result.setUser(user);
		result.setSubject(subject);
		resultService.save(result);

		results = resultRepository.findAll();
		assertThat(subjects).hasSize(1);
		Result resultFromDb = results.get(0);
		assertTrue(resultFromDb.getId().equals(result.getId()));

	}

	@Test
	public void testSumResultUser() {
		List<User> users = userRepository.findAll();
		assertThat(users).hasSize(0);

		User user = new User();
		user.setUserName("maks");
		user.setFirstName("Bilozir");
		user.setLastName("Bilozir");
		user.setPassword("maks");
		user.setRole(UserRole.ROLE_USER);
		user.setAge(20);
		user.setAmount(200);

		userService.saveOnlyUser(user);

		users = userRepository.findAll();
		assertThat(users).hasSize(1);
		List<Subject> subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(0);

		Subject subject = new Subject();
		subject.setName("IT");
		subjectService.save(subject);

		subjects = subjectRepository.findAll();
		assertThat(subjects).hasSize(1);

		List<Result> results = resultRepository.findAll();
		assertThat(results).hasSize(0);

		Result result = new Result();
		result.setUser(user);
		result.setAmount(200);
		result.setSubject(subject);

		Result result2 = new Result();
		result2.setUser(user);
		result2.setAmount(100);
		result2.setSubject(subject);

		resultRepository.saveAll(Arrays.asList(result, result2));

		results = resultRepository.findAll();

		Result resultFromDb = results.get(0);
		assertTrue(resultFromDb.getUser().getId().equals(result.getUser().getId()));
		assertTrue(new BigDecimal(resultFromDb.getUser().getAmount()).equals(new BigDecimal(user.getAmount())));
	}
}
