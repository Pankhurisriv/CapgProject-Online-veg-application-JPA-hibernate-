package com.cg.ova.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	private int feedbackId;
	private int custId;
	private int vegetableId;
	private int rating;
	private String comments;
	
	public Feedback() {
		//no implementation
	}
	
	
	public Feedback(int feedbackId, int custId, int vegetableId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.custId = custId;
		this.vegetableId = vegetableId;
		this.rating = rating;
		this.comments = comments;
	}


	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getVegetableId() {
		return vegetableId;
	}
	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", custId=" + custId + ", vegetableId=" + vegetableId
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	

}
