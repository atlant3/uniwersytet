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
import javax.persistence.OneToMany;

@Entity
public class Faculty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faculty_id")
	private Long id;
	private String name;
	private int limitAmount;
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "faculty")
	@Column(nullable = false)
	private Set<User> users;

	@ManyToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
	private Set<Subject> subjects = new HashSet<Subject>();

	public Faculty(Long id, String name, int limitAmount, Set<User> users, Set<Subject> subjects) {

		this.id = id;
		this.name = name;
		this.limitAmount = limitAmount;
		this.users = users;
		this.subjects = subjects;
	}

	public Faculty(String name, int limitAmount) {
		this.name = name;
		this.limitAmount = limitAmount;
	}

	public Faculty(Long id, String name, int limitAmount) {
		this.id = id;
		this.name = name;
		this.limitAmount = limitAmount;
	}

	public Faculty(Long id, String name, int limitAmount, Set<Subject> subjects) {
		this.id = id;
		this.name = name;
		this.limitAmount = limitAmount;
		this.subjects = subjects;
	}

	public Faculty(String name, int limitAmount, Set<User> users, Set<Subject> subjects) {
		this.name = name;
		this.limitAmount = limitAmount;
		this.users = users;
		this.subjects = subjects;
	}

	public Faculty() {
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

	public int getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(int limitAmount) {
		this.limitAmount = limitAmount;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + limitAmount;
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
		Faculty other = (Faculty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (limitAmount != other.limitAmount)
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
		return "Faculty [id=" + id + ", name=" + name + ", limitAmount=" + limitAmount + ", users=" + users
				+ ", subjects=" + subjects + "]";
	}

}
