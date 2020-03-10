package com.example.cs5610spring2020viralserverjava.repositories;

import com.example.cs5610spring2020viralserverjava.models.Widget;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query(value="SELECT MAX(order_of_widget) FROM widgets WHERE topicid=:topicId", nativeQuery = true)
  Integer findHighestOrderOfWidget(@Param("topicId") Integer topicId);

  @Query(value="SELECT * FROM widgets WHERE topicID=:topicId", nativeQuery = true)
  List<Widget> findWidgetsForTopic(@Param("topicId") Integer topicId);

  @Query(value="SELECT * FROM widgets", nativeQuery = true)
  List<Widget> findAllWidgets();

  @Query(value="SELECT * FROM widgets WHERE topicid=:topicId", nativeQuery = true)
  Widget findWidgetById(@Param("topicId") Integer topicId);
}