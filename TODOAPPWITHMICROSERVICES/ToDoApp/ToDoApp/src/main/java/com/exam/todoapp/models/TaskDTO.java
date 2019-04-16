package com.exam.todoapp.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class TaskDTO {

	
	

	private Integer id;

	private Long userId;

	private String taskName;
	
	private Timestamp reminderTime;

	private Boolean isCompleted;

	private int isNotified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "TaskDTO [id=" + id + ", userId=" + userId + ", taskName=" + taskName + ", reminderTime=" + reminderTime
				+ ", isCompleted=" + isCompleted + ", isNotified=" + isNotified + "]";
	}

	
	
}
