package com.example.cs5610spring2020viralserverjava.services;

import com.example.cs5610spring2020viralserverjava.models.Widget;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  private List<Widget> widgetList = new ArrayList<>();
  private static int order;

  public WidgetService() {
    /*Widget newWidget = new Widget();
    newWidget.setId("123456");
    newWidget.setName("First Widget");
    newWidget.setOrder(1);
    this.widgetList.add(newWidget);*/
    /*this.order = 0;*/
  }

  public Widget createWidget(String topicID, Widget newWidgetToAdd) {
    newWidgetToAdd.setId(new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date()));
    int order = findLastOrderForTopicWidget(topicID);
    order++;
    newWidgetToAdd.setOrder(order);
    this.widgetList.add(newWidgetToAdd);
    return newWidgetToAdd;
  }

  private int findLastOrderForTopicWidget(String topicID) {
    int orderToSend = 0;
    for (Widget eachWidget : this.widgetList) {
      if (topicID.equals(eachWidget.getTopicID())) {
        if (orderToSend < eachWidget.getOrder()) {
          orderToSend = eachWidget.getOrder();
        }
      }
    }
    return orderToSend;
  }

  public List<Widget> findWidgetsForTopic(String topicID) {
    List<Widget> widgetsForTopic = new ArrayList<>();
    for (Widget eachWidget : this.widgetList) {
      if (topicID.equals(eachWidget.getTopicID())) {
        widgetsForTopic.add(eachWidget);
      }
    }
    return widgetsForTopic;
  }

  public int updateWidget(String widgetID, Widget updatedWidget) {
    int totalWidgets = this.widgetList.size();
    int i;
    for (i = 0 ; i < totalWidgets ; i++) {
      if (this.widgetList.get(i).getId().equals(widgetID)) {
        this.widgetList.set(i, updatedWidget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(String widgetID) {
    this.widgetList =
        this.widgetList
        .stream()
        .filter(widgetToDelete -> !widgetToDelete.getId().equals(widgetID))
        .collect(Collectors.toList());
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return this.widgetList;
  }

  public Widget findWidgetById(String widgetID) {
    for (Widget eachWidget : this.widgetList) {
      if (widgetID.equals(eachWidget.getId())) {
        return eachWidget;
      }
    }
    return null;
  }

  public int updateAllWidgets(String topicID, List<Widget> allWidgetsToUpdate) {
    List<Widget> widgetsForTopic = new ArrayList<>(allWidgetsToUpdate);
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
        Widget widgetToCreate = this.createWidget(topicID, eachUpdatedWidget);
      }
    }

    return 1;
  }
}