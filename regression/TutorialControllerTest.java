package com.bezkoder.spring.restapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;

public class TutorialControllerTest {

  @InjectMocks
  TutorialController tutorialController;

  @Mock
  TutorialService tutorialService;

  @Test
  public void testGetAllTutorials() {
    when(tutorialService.findAll()).thenReturn(new ArrayList<Tutorial>());
    ResponseEntity<List<Tutorial>> response = tutorialController.getAllTutorials(null);
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }

  @Test
  public void testGetTutorialById() {
    Tutorial tutorial = new Tutorial();
    when(tutorialService.findById(1L)).thenReturn(tutorial);
    ResponseEntity<Tutorial> response = tutorialController.getTutorialById(1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  public void testCreateTutorial() {
    Tutorial tutorial = new Tutorial();
    when(tutorialService.save(tutorial)).thenReturn(tutorial);
    ResponseEntity<Tutorial> response = tutorialController.createTutorial(tutorial);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  public void testUpdateTutorial() {
    Tutorial tutorial = new Tutorial();
    when(tutorialService.findById(1L)).thenReturn(tutorial);
    ResponseEntity<Tutorial> response = tutorialController.updateTutorial(1L, tutorial);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  public void testDeleteTutorial() {
    ResponseEntity<HttpStatus> response = tutorialController.deleteTutorial(1L);
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }

  @Test
  public void testDeleteAllTutorials() {
    ResponseEntity<HttpStatus> response = tutorialController.deleteAllTutorials();
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }

  @Test
  public void testFindByPublished() {
    when(tutorialService.findByPublished(true)).thenReturn(new ArrayList<Tutorial>());
    ResponseEntity<List<Tutorial>> response = tutorialController.findByPublished();
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }
}