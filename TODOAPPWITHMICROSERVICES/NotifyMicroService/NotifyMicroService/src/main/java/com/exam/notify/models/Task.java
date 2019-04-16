package com.exam.notify.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tasks")
public class Task implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8817205147261352069L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "task_name")
	private String taskName;
	
	
	@Column(name="reminder_time")
	private Timestamp reminderTime;

	@Column(name = "is_completed")
	private Boolean isCompleted;

	@Column(name = "is_notified")
	private int isNotified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public int getIsNotified() {
		return isNotified;
	}

	public void setIsNotified(int isNotified) {
		this.isNotified = isNotified;
	}

	public Timestamp getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(Timestamp reminderTime) {
		this.reminderTime = reminderTime;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", user=" + user + ", taskName=" + taskName + ", reminderTime=" + reminderTime
				+ ", isCompleted=" + isCompleted + ", isNotified=" + isNotified + "]";
	}

	
}
