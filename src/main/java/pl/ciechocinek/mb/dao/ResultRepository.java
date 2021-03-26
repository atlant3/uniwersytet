package pl.ciechocinek.mb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.ciechocinek.mb.domain.Result;
@Transactional
@Repository
public interface ResultRepository extends JpaRepository<Result, Long>, CrudRepository<Result, Long>{
	@Query(value = "SELECT * FROM result r where r.user_id=:userId", nativeQuery = true)
	public List<Result> showResultByUserId(@Param("userId") Long id);
	@Modifying
	@Query(value = "UPDATE user u SET amount = (SELECT SUM(amount) AS user_sum FROM result r where r.user_id=:userId) where u.id=:userId", nativeQuery = true)
	public void sumResult(@Param("userId") Long id);
}
