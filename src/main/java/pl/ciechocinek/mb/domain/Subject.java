package pl.ciechocinek.mb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id")
	private Long id;
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_faculty", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "faculty_id"))
	private Set<Faculty> faculty = new HashSet<Faculty>();
	@ManyToMany(mappedBy = "subjects")
	private Set<Result> results = new HashSet<Result>();

	public Subject() {
	}

	public Subject(String name, Set<Faculty> faculty, Set<Result> results) {
		this.name = name;
		this.faculty = faculty;
		this.results = results;
	}

	public Subject(String name) {
		super();
		this.name = name;
	}

	public Subject(String name, Set<Faculty> faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}

	public Subject(Long id, String name, Set<Faculty> faculty) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
	}

	public Subject(Long id, String name, Set<Faculty> faculty, Set<Result> results) {
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}

	public Set<Result> getResults() {
		return results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", faculty=" + faculty + ", results=" + results + "]";
	}

}
