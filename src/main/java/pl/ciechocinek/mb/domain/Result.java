package pl.ciechocinek.mb.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Long id;
	private int amount;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "result_subject", joinColumns = @JoinColumn(name = "result_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
	
	public Result(Long id, int amount, User user, Subject subject) {
		super();
		this.id = id;
		this.amount = amount;
		this.user = user;
		this.subject = subject;
	}

	public Result(int amount, User user, Subject subject) {
		super();
		this.amount = amount;
		this.user = user;
		this.subject = subject;
	}

	public Result() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Result other = (Result) obj;
		if (amount != other.amount)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", amount=" + amount + ", user=" + user + ", subjects=" + subject + "]";
	}

}
