package com.mohanamalini.users.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mohanamalini.users.model.User;
import com.mohanamalini.users.service.UsersInOrAroundLondonService;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class UsersControllerTest {

  private UsersInOrAroundLondonService usersInOrAroundLondonService;
  private UsersController londonUsersController;

  @Before
  public void setUp() {
    usersInOrAroundLondonService = mock(UsersInOrAroundLondonService.class);
    londonUsersController = new UsersController(usersInOrAroundLondonService);
  }

  @Test
  public void givenNoUsers_GetLondonUsers_ReturnsEmptyList() {

    when(usersInOrAroundLondonService.getUsersInOrAroundLondonService()).thenReturn(new ArrayList<>());

    ResponseEntity<List<User>> responseEntity = londonUsersController.getLondonUsers();

    assertThat("Controller returns empty list when no users returned", responseEntity.getBody(), is(new ArrayList()));
  }

  @Test
  public void givenOneMockedUser_GetLondonUsers_ReturnsOneUserInList() {

    User userJohn = new User(
        1,
        "John",
        "Smith",
        "email@domain.com",
        "0.0.0.0",
        123.456,
        654.321);

    List<User> users = new ArrayList<>();
    users.add(userJohn);

    when(usersInOrAroundLondonService.getUsersInOrAroundLondonService()).thenReturn(users);

    ResponseEntity<List<User>> responseEntity = londonUsersController.getLondonUsers();

    assertThat("Controller returns expected list", responseEntity.getBody(), is(users));
  }

  @Test
  public void givenMultipleMockedUsers_GetLondonUsers_ReturnsMultipleUsersInList() {

    User userJohn = new User(
        1,
        "John",
        "Smith",
        "email@domain.com",
        "0.0.0.0",
        123.456,
        654.321);

    List<User> users = new ArrayList<>();
    users.add(userJohn);
    users.add(userJohn);
    users.add(userJohn);

    when(usersInOrAroundLondonService.getUsersInOrAroundLondonService()).thenReturn(users);

    ResponseEntity<List<User>> responseEntity = londonUsersController.getLondonUsers();

    assertThat("Controller returns expected list", responseEntity.getBody(), is(users));
  }
}