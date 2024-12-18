package com.sentiment.tracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentiment.tracker.entity.Feedback;
import com.sentiment.tracker.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    // Save feedback
    public Feedback saveFeedback(Feedback feedback){
        feedback.setTimestamp(LocalDateTime.now());
        String sentiment=sentimentAnalysisService.analyseSentiment(feedback.getFeedbackText());
        feedback.setSentiment(sentiment);
        return feedbackRepository.save(feedback);
    }

    // Get All feedback
    public List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }

    // Get feedback by sentiment
    public List<Feedback> getFeedbackBySentiment(String sentiment){
        return feedbackRepository.findAll().stream().filter(f -> sentiment.equalsIgnoreCase(f.getSentiment())).toList();
    }

}
