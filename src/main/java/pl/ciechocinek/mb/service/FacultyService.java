package pl.ciechocinek.mb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ciechocinek.mb.dao.FacultyRepository;
import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.User;

@Service
public class FacultyService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private FacultyRepository facultyRepository;
	
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

}
