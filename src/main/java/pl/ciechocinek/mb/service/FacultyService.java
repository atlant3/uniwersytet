package pl.ciechocinek.mb.service;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ciechocinek.mb.dao.FacultyRepository;
import pl.ciechocinek.mb.domain.Faculty;

@Service
public class FacultyService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private FacultyRepository facultyRepository;

	// save Faculty to DataBase
	public void save(Faculty faculty) {
		logger.info("Add a new faculty to DataBase" + faculty.getName());
		facultyRepository.save(faculty);
	}

	// find all faculty
	public List<Faculty> listOfFaculty() {
		logger.info("Find all faculty");
		return facultyRepository.findAll();

	}

	// find by id
//	public Faculty findById(Long id) {
//		logger.info("Find faculty by id" + id);
//		return facultyRepository.getOne(id);
//	}

//	public Set<Faculty> setOfFaculty(Faculty faculty) {
//		logger.info("Show faculty" + faculty.getName());
//		return setOfFaculty(faculty);
//	}
}
