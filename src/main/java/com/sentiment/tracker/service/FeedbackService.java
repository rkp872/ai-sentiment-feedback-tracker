package com.sentiment.tracker.service;

import java.util.List;

import com.sentiment.tracker.entity.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedback();
    List<Feedback> getFeedbackBySentiment(String sentiment);
}
