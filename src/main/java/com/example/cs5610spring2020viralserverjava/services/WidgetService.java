package com.example.cs5610spring2020viralserverjava.services;

import com.example.cs5610spring2020viralserverjava.models.Topic;
import com.example.cs5610spring2020viralserverjava.models.Widget;
import com.example.cs5610spring2020viralserverjava.repositories.TopicRepository;
import com.example.cs5610spring2020viralserverjava.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  /*@Autowired
  TopicRepository topicRepository;*/

  public Widget createWidget(Integer topicId, Widget newWidgetToAdd) {
    int order = findLastOrderForTopicWidget(topicId);
    newWidgetToAdd.setOrderOfWidget(++order);

    /*Topic topic = topicRepository.findById(topicId).get();
    newWidgetToAdd.setTopic(topic);*/
    /*newWidgetToAdd.setTopicID(topicId);*/

    return widgetRepository.save(newWidgetToAdd);
  }

  private int findLastOrderForTopicWidget(Integer topicId) {
    if (widgetRepository.findHighestOrderOfWidget(topicId) == null) {
      return 0;
    }
    return widgetRepository.findHighestOrderOfWidget(topicId);
  }

  public List<Widget> findWidgetsForTopic(Integer topicId) {
    /*Topic topic = topicRepository.findById(topicId).get();
    return topic.getListOfWidgets();*/
    
    return widgetRepository.findWidgetsForTopic(topicId);
  }

  public int updateWidget(Integer widgetID, Widget updatedWidget) {
    widgetRepository.save(updatedWidget);
    return 1;
  }

  public int deleteWidget(Integer widgetID) {
    widgetRepository.deleteById(widgetID);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAllWidgets();
  }

  public Widget findWidgetById(Integer widgetID) {
    return widgetRepository.findWidgetById(widgetID);
  }

  public int updateAllWidgets(Integer topicId, List<Widget> allWidgetsToUpdate) {
    widgetRepository.saveAll(allWidgetsToUpdate);
    return 1;
  }
}