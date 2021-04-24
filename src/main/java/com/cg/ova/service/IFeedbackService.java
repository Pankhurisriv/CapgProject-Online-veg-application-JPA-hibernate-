package com.cg.ova.service;

import java.util.List;

import com.cg.ova.entity.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback(Feedback fdk);
	public List<Feedback> viewAllFeedbacks(int vegetableId);

}
