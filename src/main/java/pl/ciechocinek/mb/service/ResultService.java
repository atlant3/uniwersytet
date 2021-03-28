package pl.ciechocinek.mb.service;

import java.util.List;

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
		logger.info("Add a new result" + result.getId());
		resultRepository.save(result);
	}
	//get results by User id
	public List<Result> showResultByUserId(Long id) {
		logger.info("Show results by User id" + id);
		return resultRepository.showResultByUserId(id);
	}
	//get result by id
	public Result getResultById(Long id) {
		logger.info("Show result by id" + id);
		return resultRepository.getOne(id);
	}
	
	public void sumResultUser(Long id) {
		logger.info("Sum results by User id" + id);
		resultRepository.sumResult(id);
	}
}  
