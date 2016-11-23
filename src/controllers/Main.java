package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
  public static void main(String[] args) throws Exception
  {    
	    File  datastore = new File("datastore3.xml");
	    Serializer serializer = new XMLSerializer(datastore);

	    PacemakerAPI pacemakerAPI = new PacemakerAPI(serializer);
	    if (datastore.isFile())
	    {
	      pacemakerAPI.load();
	    }

	    pacemakerAPI.createUser("Bart", "Simpson",   "bart@simpson.com", "secret");
	    pacemakerAPI.createUser("Homer", "Simpson",  "homer@simpson.com", "secret");
	    pacemakerAPI.createUser("Lisa", "Simpson", " lisa@simpson.com", "secret");

	    Collection<User> users = pacemakerAPI.getUsers();
	    System.out.println(users);

	    User homer = pacemakerAPI.getUserByEmail("homer@simpson.com");
	    pacemakerAPI.createActivity(homer.id, "walk", "tramore", 1000);

	    pacemakerAPI.store();
  }
}