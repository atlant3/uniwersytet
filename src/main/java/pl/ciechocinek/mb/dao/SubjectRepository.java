package pl.ciechocinek.mb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.ciechocinek.mb.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>, CrudRepository<Subject, Long> {

	@Query(value = "SELECT * FROM subject s join subject_faculty sf on sf.subject_id = s.subject_id WHERE sf.faculty_id = :facultyId", nativeQuery = true)
	public List<Subject> subjectsByFacultet(@Param("facultyId") Long id);
}
