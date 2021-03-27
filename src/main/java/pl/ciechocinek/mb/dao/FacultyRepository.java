package pl.ciechocinek.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.ciechocinek.mb.domain.Faculty;
@Transactional
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>, CrudRepository<Faculty, Long>{

}
