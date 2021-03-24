package pl.ciechocinek.mb.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ciechocinek.mb.dao.FacultyRepository;
import pl.ciechocinek.mb.dao.SubjectRepository;
import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.Subject;

@Service
public class SubjectService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	
	
	
//	@PostConstruct
//	public void addFirstFaculty() {
//		Subject s1 = new Subject("Jeee");
//		subjectRepository.save(s1);
//		Faculty f1 = new Faculty("Jeesss", 0);
//		facultyRepository.save(f1);
//		s1.getFaculty().add(f1);
//		subjectRepository.save(s1);
//	}

	public void save(Subject subject) {
//		logger.info("Add a new subject to DataBase" + subject);
		subjectRepository.save(subject);
	}

}
