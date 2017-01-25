package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Question {
	@Id @GeneratedValue
	private long id;
	
	//@ManyToOne
	//private User writer;
	@Column(length = 30)
	private String writer;
	
	@Column(length = 30, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String contents;

	
	public Question() {}

	public Question(long id, String writer, String title, String contents) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.contents = contents;

	}

	public void setId(long id) {
		this.id = id;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Writer [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}
	
}
