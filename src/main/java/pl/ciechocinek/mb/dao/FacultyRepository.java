package pl.ciechocinek.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>, CrudRepository<Faculty, Long>{

}
