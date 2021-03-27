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

	public void save(Subject subject) {
		logger.info("Add a new subject to DataBase" + subject.getName());
		subjectRepository.save(subject);
	}

	public List<Subject> subjectsFaculty(Long id) {
		return subjectRepository.subjectsByFacultet(id);
	}
}
