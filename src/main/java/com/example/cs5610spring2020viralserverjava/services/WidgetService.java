package com.example.cs5610spring2020viralserverjava.services;

import com.example.cs5610spring2020viralserverjava.models.Widget;
import com.example.cs5610spring2020viralserverjava.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  /*private List<Widget> widgetList = new ArrayList<>();*/
  @Autowired
  WidgetRepository widgetRepository;

  public Widget createWidget(Integer topicID, Widget newWidgetToAdd) {
    /*int order = findLastOrderForTopicWidget(topicID);
    order++;
    newWidgetToAdd.setOrderOfWidget(order);
    this.widgetList.add(newWidgetToAdd);
    return newWidgetToAdd;*/
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
    /*List<Widget> widgetsForTopic = new ArrayList<>();
    for (Widget eachWidget : this.widgetList) {
      if (topicID.equals(eachWidget.getTopicID())) {
        widgetsForTopic.add(eachWidget);
      }
    }
    return widgetsForTopic;*/
    return widgetRepository.findWidgetsForTopic(topicID);
  }

  public int updateWidget(Integer widgetID, Widget updatedWidget) {
    /*int totalWidgets = this.widgetList.size();
    int i;
    for (i = 0 ; i < totalWidgets ; i++) {
      if (this.widgetList.get(i).getId().equals(widgetID)) {
        this.widgetList.set(i, updatedWidget);
        return 1;
      }
    }
    return 0;*/
    widgetRepository.save(updatedWidget);
    return 1;
  }

  public int deleteWidget(Integer widgetID) {
    /*this.widgetList =
        this.widgetList
        .stream()
        .filter(widgetToDelete -> !widgetToDelete.getId().equals(widgetID))
        .collect(Collectors.toList());
    return 1;*/
    widgetRepository.deleteById(widgetID);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    /*return this.widgetList;*/
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetID) {
    /*for (Widget eachWidget : this.widgetList) {
      if (widgetID.equals(eachWidget.getId())) {
        return eachWidget;
      }
    }
    return null;*/
    return widgetRepository.findById(widgetID).get();
  }

  public int updateAllWidgets(Integer topicID, List<Widget> allWidgetsToUpdate) {
    /*List<Widget> widgetsForTopic = new ArrayList<>(allWidgetsToUpdate);
    int totalWidgets = this.widgetList.size();
    int i;
    boolean isWidgetUpdated;

    for (Widget eachUpdatedWidget : widgetsForTopic) {
      isWidgetUpdated = false;
      for (i = 0 ; i < totalWidgets ; i++) {
        if (this.widgetList.get(i).getId().equals(eachUpdatedWidget.getId())) {
          this.widgetList.set(i, eachUpdatedWidget);
          isWidgetUpdated = true;
        }
      }
      if(!isWidgetUpdated) {
        this.createWidget(topicID, eachUpdatedWidget);
      }
    }

    return 1;*/
    widgetRepository.saveAll(allWidgetsToUpdate);
    return 1;
  }
}