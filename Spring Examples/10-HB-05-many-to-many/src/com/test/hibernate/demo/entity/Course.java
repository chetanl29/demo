package com.test.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.DETACH})
	@JoinColumn(name = "INSTRUCTOR_ID")
	private Instructor instructor;
	
	@OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="COURSE_ID")
	private List<Review> reviews;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.REFRESH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.DETACH})
	@JoinTable(name ="COURSE_STUDENT",
				joinColumns=@JoinColumn(name="COURSE_ID"),
				inverseJoinColumns=@JoinColumn(name = "STUDENT_ID"))
	private List<Student> students;

	public Course() {
		super();
	}
	
	public Course(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	public void addReview(Review theReview) {
		if(reviews == null) {
			reviews= new ArrayList<Review>();
		}
		reviews.add(theReview);
	}
	
	public void addStudent(Student theStudent) {
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(theStudent);
	}
	
}
