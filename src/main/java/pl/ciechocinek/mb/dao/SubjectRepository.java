package pl.ciechocinek.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>, CrudRepository<Subject, Long> {

}
