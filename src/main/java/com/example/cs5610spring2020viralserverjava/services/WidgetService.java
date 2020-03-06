package com.example.cs5610spring2020viralserverjava.services;

import com.example.cs5610spring2020viralserverjava.models.Widget;
import com.example.cs5610spring2020viralserverjava.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  public Widget createWidget(Integer topicID, Widget newWidgetToAdd) {
    int order = findLastOrderForTopicWidget(topicID);
    newWidgetToAdd.setOrderOfWidget(++order);
    newWidgetToAdd.setTopicID(topicID);
    return widgetRepository.save(newWidgetToAdd);
  }

  private int findLastOrderForTopicWidget(Integer topicID) {
    if (widgetRepository.findHighestOrderOfWidget(topicID) == null) {
      return 0;
    }
    return widgetRepository.findHighestOrderOfWidget(topicID);
  }

  public List<Widget> findWidgetsForTopic(Integer topicID) {
    return widgetRepository.findWidgetsForTopic(topicID);
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
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetID) {
    return widgetRepository.findById(widgetID).get();
  }

  public int updateAllWidgets(Integer topicID, List<Widget> allWidgetsToUpdate) {
    widgetRepository.saveAll(allWidgetsToUpdate);
    return 1;
  }
}