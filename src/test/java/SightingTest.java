import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.sql.Date;


public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    assertEquals(true, testSighting instanceof Sighting);
  }

  @Test
  public void equals_returnsTrueIfLocationAndDescriptionAreSame_true() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    Sighting anotherSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    assertTrue(testSighting.equals(anotherSighting));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Sighting() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting (testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
  }

  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting (testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    Animal secondTestAnimal = new Animal("King Louie");
    secondTestAnimal.save();
    Sighting secondTestSighting = new Sighting (testAnimal.getId(), false, "45.523062, -122.676482", "Ranger Ashanti");
    secondTestSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
    assertEquals(true, Sighting.all().get(1).equals(secondTestSighting));
  }
  @Test
  public void find_returnsSightingWithSameId_secondSighting() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting (testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    Animal secondTestAnimal = new Animal("King Louie");
    secondTestAnimal.save();
    Sighting secondTestSighting = new Sighting (testAnimal.getId(), false, "45.523062, -122.676482", "Ranger Ashanti");
    secondTestSighting.save();
    assertEquals(Sighting.find(secondTestSighting.getId()), secondTestSighting);
  }

  @Test
  public void save_recordsTimeOfCreationInDatabase() {
    Animal testAnimal = new Animal("Bagheera");
    testAnimal.save();
    Sighting testSighting = new Sighting (testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    Timestamp savedSightingTime = Sighting.find(testSighting.getId()).getTimeSighted();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow, savedSightingTime);
  }

  // @Test
  // public void addPerson_addsPersonToSighting() {
  //   Sighting testSighting = new Sighting("Fire enthusiasts", "Flame on!");
  //   testSighting.save();
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   testSighting.addPerson(testPerson);
  //   Person savedPerson = testSighting.getPersons().get(0);
  //   assertTrue(testPerson.equals(savedPerson));
  // }
  //
  // @Test
  // public void getPersons_returnsAllPersons_List() {
  //   Animal testAnimal = new Animal("Bagheera");
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   testSighting.addPerson(testPerson);
  //   List savedPersons = testSighting.getPersons();
  //   assertEquals(savedPersons.size(), 1);
  // }
  //
  // @Test
  // public void delete_deletesSighting_true() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
  //   testSighting.delete();
  //   assertEquals(0, Sighting.all().size());
  // }
  //
  // @Test
  // public void delete_deletesAllPersonsAndCommunitiesAssociations() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   testSighting.addPerson(testPerson);
  //   testSighting.delete();
  //   assertEquals(0, testPerson.getCommunities().size());
  // }
  //
  // @Test
  // public void removePerson_removesAssociationWithSpecifiedSighting() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting testSighting = new Sighting(testAnimal.getId(), true, "45.523062, -122.676482", "Ranger Jen");
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   testSighting.removePerson(testPerson);
  //   List savedPersons = testSighting.getPersons();
  //   assertEquals(0, savedPersons.size());
  // }

}
