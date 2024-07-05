package com.bezkoder.spring.restapi.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    List<Tutorial> tutorials = tutorialService.findByTitleContaining("Test");
    assertNotNull(tutorials);
  }

  @Test
  public void testFindById() {
    Tutorial tutorial = tutorialService.findById(1L);
    assertNotNull(tutorial);
  }

  @Test
  public void testSave() {
    Tutorial tutorial = new Tutorial();
    tutorial.setTitle("Test");
    tutorial = tutorialService.save(tutorial);
    assertNotNull(tutorial);
    assertEquals("Test", tutorial.getTitle());
  }

  @Test
  public void testDeleteById() {
    tutorialService.deleteById(1L);
    Tutorial tutorial = tutorialService.findById(1L);
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
    List<Tutorial> tutorials = tutorialService.findByPublished(true);
    assertNotNull(tutorials);
  }
}