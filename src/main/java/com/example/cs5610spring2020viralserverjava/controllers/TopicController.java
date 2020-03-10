package com.example.cs5610spring2020viralserverjava.controllers;

import com.example.cs5610spring2020viralserverjava.models.Topic;
import com.example.cs5610spring2020viralserverjava.services.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

  @Autowired
  private TopicService topicService;

  @GetMapping("/api/lessons/{lessonID}/topics")
  public List<Topic> findTopicsForLesson(@PathVariable("lessonID") String lessonId) {
    return this.topicService.findTopicsForLesson(lessonId);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return this.topicService.findAllTopics();
  }

  @GetMapping("/api/topics/{topicID}")
  public Topic findTopicById(@PathVariable("topicID") Integer topicId) {
    return this.topicService.findTopicById(topicId);
  }

  @PostMapping("/api/lessons/{lessonID}/topics")
  public Topic createTopic(@PathVariable("lessonID") String lessonId,
      @RequestBody Topic newTopicToAdd) {
    return this.topicService.createTopic(lessonId, newTopicToAdd);
  }

  @PutMapping("/api/topics/{topicID}")
  public int updateTopic(@PathVariable("topicID") Integer topicId,
      @RequestBody Topic updatedTopic) {
    return this.topicService.updateTopic(topicId, updatedTopic);
  }

  @DeleteMapping("/api/topics/{topicID}")
  public int deleteTopic(@PathVariable("topicID") Integer topicId) {
    return this.topicService.deleteTopic(topicId);
  }
}