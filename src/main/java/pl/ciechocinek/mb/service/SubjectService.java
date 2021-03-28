package pl.ciechocinek.mb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ciechocinek.mb.dao.SubjectRepository;
import pl.ciechocinek.mb.domain.Subject;

@Service
public class SubjectService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private SubjectRepository subjectRepository;

	// add a new Subject to DataBase
	public void save(Subject subject) {
		logger.info("Add a new subject to DataBase " + subject.getName());
		subjectRepository.save(subject);
	}

	// show Subjects by Faculty id
	public List<Subject> subjectsFaculty(Long id) {
		logger.info("show Subjects by Faculty id " + id);
		return subjectRepository.subjectsByFacultet(id);
	}
}
