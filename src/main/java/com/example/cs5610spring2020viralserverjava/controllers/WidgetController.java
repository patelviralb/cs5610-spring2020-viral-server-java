package com.example.cs5610spring2020viralserverjava.controllers;

import com.example.cs5610spring2020viralserverjava.models.Widget;
import com.example.cs5610spring2020viralserverjava.services.WidgetService;
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
public class WidgetController {
  @Autowired
  private WidgetService widgetService;

  @GetMapping("/api/topics/{topicID}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("topicID") Integer topicID) {
    return this.widgetService.findWidgetsForTopic(topicID);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return this.widgetService.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetID}")
  public Widget findWidgetById(@PathVariable("widgetID") Integer widgetID) {
    return this.widgetService.findWidgetById(widgetID);
  }

  @PostMapping("/api/topics/{topicID}/widgets")
  public Widget createWidget(@PathVariable("topicID") Integer topicID, @RequestBody Widget newWidgetToAdd) {
    return this.widgetService.createWidget(topicID, newWidgetToAdd);
  }

  @PutMapping("/api/widgets/{widgetID}")
  public int updateWidget(@PathVariable("widgetID") Integer widgetID, @RequestBody Widget updatedWidget) {
    return this.widgetService.updateWidget(widgetID, updatedWidget);
  }

  @DeleteMapping("/api/widgets/{widgetID}")
  public int deleteWidget(@PathVariable("widgetID") Integer widgetID) {
    return this.widgetService.deleteWidget(widgetID);
  }

  @PostMapping("/api/topics/{topicID}/widgets/allWidgets")
  public int updateAllWidgets(@PathVariable("topicID") Integer topicID, @RequestBody List<Widget> allWidgetsToUpdate) {
    return this.widgetService.updateAllWidgets(topicID, allWidgetsToUpdate);
  }
}