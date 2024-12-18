package com.sentiment.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sentiment.tracker.entity.Feedback;
import com.sentiment.tracker.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback){
        Feedback savedFeedback=feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(savedFeedback,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback(){
        List<Feedback> feedbackList=feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbackList,HttpStatus.OK);
    }

    @GetMapping("/by-sentiment")
    public ResponseEntity<List<Feedback>> getFeedbackBySentiment(@RequestParam String sentiment){
        List<Feedback> feedbackList=feedbackService.getFeedbackBySentiment(sentiment);
        return new ResponseEntity<>(feedbackList,HttpStatus.OK);
    }
}
