package pl.ciechocinek.mb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ciechocinek.mb.dao.ResultRepository;
import pl.ciechocinek.mb.domain.Result;

@Service
public class ResultService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private ResultRepository resultRepository;
	
	//add resault to DataBase
	public void save(Result result) {
		resultRepository.save(result);
	}
} 
