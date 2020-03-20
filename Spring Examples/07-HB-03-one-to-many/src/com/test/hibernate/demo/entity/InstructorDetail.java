package com.test.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR_DETAIL")
public class InstructorDetail {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "YOUTUBE_CHANNEL")
	private String youtubeChannel;
	
	@Column(name = "HOBBY")
	private String hobby;
	
	//@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL) //Use CascadeType.ALL when both Instructor and InstructorDetail entry needs to be deleted
	@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.REFRESH,
														CascadeType.DETACH,
														CascadeType.MERGE,
														CascadeType.PERSIST})//Use above Cascade types when InstructorDetail entry only needs to be deleted
	private Instructor instructor;
	
	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
