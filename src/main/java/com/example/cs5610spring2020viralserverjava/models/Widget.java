package com.example.cs5610spring2020viralserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class represents a single Widget component.
 */
@Entity
@Table(name ="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name; //Optional name of the widget
  private String type; //Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
  private int orderOfWidget; //Order with respect to widgets in the same list
  @Lob
  private String text; //Plain text useful for heading text, paragraph text, link text, etc
  private String source; //Absolute or relative URL referring to online resource
  private int size; //Useful to represent size of widget, e.g., heading size
  private int width; //Widget's horizontal size, e.g., Image's or YouTube's width
  private int height; //Widget's vertical size, e.g., Image's or YouTube's height
  private String cssClass; //CSS class implementing some CSS rule and transformations configured in some CSS rule
  private String style; //CSS transformations applied to the widget
  private String value; //Some arbitrary initial value interpreted by the widget

  @ManyToOne
  @JsonIgnore
  private Topic topic; //Topic ID for the widget

  public Widget() {
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getOrderOfWidget() {
    return this.orderOfWidget;
  }

  public void setOrderOfWidget(int order) {
    this.orderOfWidget = order;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSource() {
    return this.source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getCssClass() {
    return this.cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return this.style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Topic getTopic() {
    return this.topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }
}