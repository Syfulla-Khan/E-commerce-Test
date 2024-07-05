package com.bezkoder.spring.restapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;

public class TutorialControllerTest {

  @InjectMocks
  TutorialController tutorialController;

  @Mock
  TutorialService tutorialService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getAllTutorialsTest() {
    when(tutorialService.findAll()).thenReturn(Arrays.asList(new Tutorial("title1", "desc1", false), new Tutorial("title2", "desc2", true)));
    ResponseEntity<List<Tutorial>> response = tutorialController.getAllTutorials(null);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(2, response.getBody().size());
  }

  @Test
  public void getTutorialByIdTest() {
    when(tutorialService.findById(1L)).thenReturn(new Tutorial("title", "desc", false));
    ResponseEntity<Tutorial> response = tutorialController.getTutorialById(1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("title", response.getBody().getTitle());
  }

  @Test
  public void createTutorialTest() {
    when(tutorialService.save(any(Tutorial.class))).thenReturn(new Tutorial("title", "desc", false));
    ResponseEntity<Tutorial> response = tutorialController.createTutorial(new Tutorial("title", "desc", false));
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals("title", response.getBody().getTitle());
  }

  @Test
  public void updateTutorialTest() {
    when(tutorialService.findById(1L)).thenReturn(new Tutorial("title", "desc", false));
    when(tutorialService.save(any(Tutorial.class))).thenReturn(new Tutorial("newTitle", "newDesc", true));
    ResponseEntity<Tutorial> response = tutorialController.updateTutorial(1L, new Tutorial("newTitle", "newDesc", true));
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("newTitle", response.getBody().getTitle());
  }

  @Test
  public void deleteTutorialTest() {
    ResponseEntity<HttpStatus> response = tutorialController.deleteTutorial(1L);
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    verify(tutorialService, times(1)).deleteById(1L);
  }

  @Test
  public void deleteAllTutorialsTest() {
    ResponseEntity<HttpStatus> response = tutorialController.deleteAllTutorials();
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    verify(tutorialService, times(1)).deleteAll();
  }

  @Test
  public void findByPublishedTest() {
    when(tutorialService.findByPublished(true)).thenReturn(Arrays.asList(new Tutorial("title1", "desc1", true), new Tutorial("title2", "desc2", true)));
    ResponseEntity<List<Tutorial>> response = tutorialController.findByPublished();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(2, response.getBody().size());
  }
}