package com.example.cs5610spring2020viralserverjava.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Class represents a single Widget component.
 */
@Entity
@Table(name ="topics")
public class Topic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonSerialize(using = ToStringSerializer.class)
  private Integer id;
  private String title;
  private String description;

  @OneToMany(mappedBy = "topic")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<Widget> listOfWidgets;
  private String lessonId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Widget> getListOfWidgets() {
    return listOfWidgets;
  }

  public void setListOfWidgets(
      List<Widget> listOfWidgets) {
    this.listOfWidgets = listOfWidgets;
  }

  public String getLessonId() {
    return lessonId;
  }

  public void setLessonId(String lessonId) {
    this.lessonId = lessonId;
  }
}