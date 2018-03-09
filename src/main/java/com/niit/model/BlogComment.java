package com.niit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Blogcomment")
public class BlogComment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
private int id;
	@ManyToOne
	private BlogPost blogPost;
	@ManyToOne
	
private User commentedBy;
private Date commentedOn;


private String commentTxt;

public String getCommentTxt() {
	return commentTxt;
}
public void setCommentTxt(String commentTxt) {
	this.commentTxt = commentTxt;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User getCommentedBy() {
	return commentedBy;
}
public void setCommentedBy(User commentedBy) {
	this.commentedBy = commentedBy;
}
public Date getCommentedOn() {
	return commentedOn;
}
public void setCommentedOn(Date commentedOn) {
	this.commentedOn = commentedOn;
}
public BlogPost getBlogPost() {
	return blogPost;
}
public void setBlogPost(BlogPost blogPost) {
	this.blogPost = blogPost;
}


}