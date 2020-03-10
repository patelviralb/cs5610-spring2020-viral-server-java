package com.example.cs5610spring2020viralserverjava.repositories;

import com.example.cs5610spring2020viralserverjava.models.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends CrudRepository<Topic,Integer> {

  @Query(value="SELECT * FROM topics", nativeQuery = true)
  List<Topic> findAllTopics();

  @Query(value="SELECT * FROM topics WHERE lesson_id=:lessonId", nativeQuery = true)
  List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);

  @Query(value="SELECT * FROM topics WHERE id=:topicId", nativeQuery = true)
  Topic findTopicById(@Param("topicId") Integer topicId);
}
