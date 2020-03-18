package com.manny.hibernate.demo.entity;

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
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name="course_student", 
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	
	public List<Review> getReview() {
		return reviews;
	}

	public void setReview(List<Review> review) {
		this.reviews = review;
	}
	
	public void addReview(Review theReview) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(theReview);
	}
	
	

	public List<Student> getAstudent() {
		return students;
	}

	public void setAstudent(List<Student> astudent) {
		this.students = astudent;
	}
	
	public void addStudent(Student aStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(aStudent);
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", title=" + title + "]";
	}
	
	
	
	
	

}
