package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.PacemakerAPI;
import static models.Fixtures.users;
import static models.Fixtures.activities;
import static models.Fixtures.locations;

public class PacemakerAPITest
{
  private PacemakerAPI pacemaker;

  @Before
  public void setup()
  {
    pacemaker = new PacemakerAPI();
  }

  @After
  public void tearDown()
  {
    pacemaker = null;
  }

  @Test
  public void testUser()
  {
    assertEquals (0, pacemaker.getUsers().size());
  } 
  
  @Test
  public void testUserEmpty()
  {
    User homer = new User ("homer", "simpson", "homer@simpson.com",  "secret");

    assertEquals (0, pacemaker.getUsers().size());
    pacemaker.createUser("homer", "simpson", "homer@simpson.com", "secret");
    assertEquals (1, pacemaker.getUsers().size());
  } 
  
  @Test
  public void testEquals()
  {
    User homer2 = new User ("homer", "simpson", "homer@simpson.com",  "secret"); 
    User bart   = new User ("bart", "simpson", "bartr@simpson.com",  "secret"); 

    assertEquals(homer2, homer2);
    assertEquals(homer2, homer2);
    assertNotEquals(homer2, bart);
  }  
}