package com.example.cs5610spring2020viralserverjava.services;

import com.example.cs5610spring2020viralserverjava.models.Topic;
import com.example.cs5610spring2020viralserverjava.repositories.TopicRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  @Autowired
  TopicRepository topicRepository;

  public Topic createTopic(String lessonId, Topic newTopicToAdd) {
    newTopicToAdd.setLessonId(lessonId);
    return topicRepository.save(newTopicToAdd);
  }

  public List<Topic> findTopicsForLesson(String lessonId) {
    return topicRepository.findTopicsForLesson(lessonId);
  }

  public int updateTopic(Integer topicId, Topic updatedTopic) {
    topicRepository.save(updatedTopic);
    return 1;
  }

  public int deleteTopic(Integer topicID) {
    topicRepository.deleteById(topicID);
    return 1;
  }

  public List<Topic> findAllTopics() {
    return topicRepository.findAllTopics();
  }

  public Topic findTopicById(Integer topicID) {
    return topicRepository.findTopicById(topicID);
  }
}