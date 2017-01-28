package com.example.study.entities;

import java.sql.Timestamp;

/**
 * MessageBoard entity. @author MyEclipse Persistence Tools
 */

public class MessageBoard implements java.io.Serializable {

	// Fields

	private Long messageBoardId;
	private Course course;
	private String username;
	private Integer identity;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public MessageBoard() {
	}

	/** full constructor */
	public MessageBoard(Course course, String username, Integer identity,
			String content, Timestamp time) {
		this.course = course;
		this.username = username;
		this.identity = identity;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Long getMessageBoardId() {
		return this.messageBoardId;
	}

	public void setMessageBoardId(Long messageBoardId) {
		this.messageBoardId = messageBoardId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIdentity() {
		return this.identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}