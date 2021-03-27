package pl.ciechocinek.mb.service;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ciechocinek.mb.dao.FacultyRepository;
import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;

@Service
public class FacultyService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private FacultyRepository facultyRepository;
	
	//save Faculty to DataBase
	public void save(Faculty faculty) {
//		logger.info("Add a new faculty to DataBase" + faculty.toString());
		facultyRepository.save(faculty);
	}
	
	
	//find all faculty
	public List<Faculty> listOfFaculty() {
		logger.info("Find all faculty");
		return facultyRepository.findAll();
		
	}
	
	//find by id
	public Faculty findById(Long id) {
		logger.info("Find faculty by id" + id);
		return facultyRepository.getOne(id);	
	}
	public Set<Faculty> setOfFaculty(Faculty faculty) {
		return setOfFaculty(faculty);
	}
}
