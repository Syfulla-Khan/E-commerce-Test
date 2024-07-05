package com.bezkoder.spring.restapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import com.bezkoder.spring.restapi.model.Tutorial;

public class TutorialServiceTest {

  private TutorialService tutorialService;

  @BeforeEach
  public void setUp() {
    tutorialService = new TutorialService();
  }

  @Test
  public void testFindAll() {
    List<Tutorial> tutorials = tutorialService.findAll();
    assertNotNull(tutorials);
  }

  @Test
  public void testFindByTitleContaining() {
    String title = "Test";
    List<Tutorial> tutorials = tutorialService.findByTitleContaining(title);
    assertNotNull(tutorials);
  }

  @Test
  public void testFindById() {
    long id = 1;
    Tutorial tutorial = tutorialService.findById(id);
    assertNotNull(tutorial);
  }

  @Test
  public void testSave() {
    Tutorial tutorial = new Tutorial();
    tutorial.setTitle("Test");
    tutorial.setPublished(true);
    Tutorial savedTutorial = tutorialService.save(tutorial);
    assertNotNull(savedTutorial);
    assertEquals(tutorial.getTitle(), savedTutorial.getTitle());
    assertTrue(savedTutorial.isPublished());
  }

  @Test
  public void testDeleteById() {
    long id = 1;
    tutorialService.deleteById(id);
    Tutorial tutorial = tutorialService.findById(id);
    assertNull(tutorial);
  }

  @Test
  public void testDeleteAll() {
    tutorialService.deleteAll();
    List<Tutorial> tutorials = tutorialService.findAll();
    assertTrue(tutorials.isEmpty());
  }

  @Test
  public void testFindByPublished() {
    boolean isPublished = true;
    List<Tutorial> tutorials = tutorialService.findByPublished(isPublished);
    assertNotNull(tutorials);
  }
}