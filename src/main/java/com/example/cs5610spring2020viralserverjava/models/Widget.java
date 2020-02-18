package com.example.cs5610spring2020viralserverjava.models;

/**
 * Class represents a single Widget component.
 */
public class Widget {

  private String name; //Optional name of the widget
  private String id; //Widget's unique identifier
  private String type; //Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
  private int order; //Order with respect to widgets in the same list
  private String text; //Plain text useful for heading text, paragraph text, link text, etc
  private String source; //Absolute or relative URL referring to online resource
  private int size; //Useful to represent size of widget, e.g., heading size
  private int width; //Widget's horizontal size, e.g., Image's or YouTube's width
  private int height; //Widget's vertical size, e.g., Image's or YouTube's height
  private String cssClass; //CSS class implementing some CSS rule and transformations configured in some CSS rule
  private String style; //CSS transformations applied to the widget
  private String value; //Some arbitrary initial value interpreted by the widget
  private String topicID; //Topic ID for the widget

  public Widget() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getTopicID() {
    return topicID;
  }

  public void setTopicID(String topicID) {
    this.topicID = topicID;
  }
}