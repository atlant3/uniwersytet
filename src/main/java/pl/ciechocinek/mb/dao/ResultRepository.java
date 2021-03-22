package pl.ciechocinek.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long>, CrudRepository<Result, Long>{

}
