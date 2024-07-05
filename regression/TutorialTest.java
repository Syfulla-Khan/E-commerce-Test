package com.bezkoder.spring.restapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TutorialTest {

  @Test
  public void testTutorialConstructor() {
    Tutorial tutorial = new Tutorial("Test title", "Test description", true);
    assertEquals("Test title", tutorial.getTitle());
    assertEquals("Test description", tutorial.getDescription());
    assertTrue(tutorial.isPublished());
  }

  @Test
  public void testSetId() {
    Tutorial tutorial = new Tutorial();
    tutorial.setId(1);
    assertEquals(1, tutorial.getId());
  }

  @Test
  public void testSetTitle() {
    Tutorial tutorial = new Tutorial();
    tutorial.setTitle("Test title");
    assertEquals("Test title", tutorial.getTitle());
  }

  @Test
  public void testSetDescription() {
    Tutorial tutorial = new Tutorial();
    tutorial.setDescription("Test description");
    assertEquals("Test description", tutorial.getDescription());
  }

  @Test
  public void testSetPublished() {
    Tutorial tutorial = new Tutorial();
    tutorial.setPublished(true);
    assertTrue(tutorial.isPublished());
  }

  @Test
  public void testToString() {
    Tutorial tutorial = new Tutorial("Test title", "Test description", true);
    String expectedString = "Tutorial [id=0, title=Test title, desc=Test description, published=true]";
    assertEquals(expectedString, tutorial.toString());
  }
}