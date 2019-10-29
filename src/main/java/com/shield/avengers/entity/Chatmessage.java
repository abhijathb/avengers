package com.shield.avengers.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "chatmessages")
public class Chatmessage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "loggedtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date loggedtime;
	@Column(name = "message")
	private String message;
	@ManyToOne //Many chatmessages to one from_user
	@JoinColumn(name = "from_user")
	private User from_user;
	@ManyToOne //Many chatmessages to one to_user
	@JoinColumn(name = "to_user")
	private User to_user;

	public Chatmessage() {

	}

	public Chatmessage(long id, Date loggedtime, String message, User from_user, User to_user) {
		super();
		this.id = id;
		this.loggedtime = loggedtime;
		this.message = message;
		this.from_user = from_user;
		this.to_user = to_user;
	}

	@Override
	public String toString() {
		return "Chatmessage [id=" + id + ", loggedtime=" + loggedtime + ", message=" + message + ", from_user="
				+ from_user + ", to_user=" + to_user + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLoggedtime() {
		return loggedtime;
	}

	public void setLoggedtime(Date loggedtime) {
		this.loggedtime = loggedtime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getFrom_user() {
		return from_user;
	}

	public void setFrom_user(User from_user) {
		this.from_user = from_user;
	}

	public User getTo_user() {
		return to_user;
	}

	public void setTo_user(User to_user) {
		this.to_user = to_user;
	}

}
