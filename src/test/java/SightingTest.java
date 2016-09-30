import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Bagheera")
    testAnimal.save();
    Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
    assertEquals(true, testSighting instanceof Sighting);
  }

  // @Test
  // public void getLocation_sightingInstantiatesWithLocation_true() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting(1, "45.523062, -122.676482", "Ranger Jen");
  //   assertEquals("45.523062, -122.676482", testSighting.getLocation());
  // }
  //
  // @Test
  // public void getRangerName_sightingInstantiatesWithRangerName_String() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting(1, "45.523062, -122.676482", "Ranger Jen");
  //   assertEquals("Lovers of all things water monsters!", testSighting.getDescription());
  // }

  // @Test
  // public void Sighting_instantiatesWithAnimalId_int() {
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   assertEquals(0, testSighting.getAnimalId());
  // }

  // @Test
  // public void equals_returnsTrueIfLocationAndDescriptionAreSame_true() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
    // Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   assertTrue(testSighting.equals(anotherSighting));
  // }
  //
  // @Test
  // public void save_insertsObjectIntoDatabase_Sighting() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   assertEquals(true, Sighting.all().get(0).equals(testSighting));
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfSighting_true() {
  //   Sighting firstSighting = new Sighting("Fire Enthusiasts", "Flame on!");
  //   firstSighting.save();
  //   Sighting secondSighting = new Sighting("Water Enthusiasts", "Lovers of all things water monsters!");
  //   secondSighting.save();
  //   assertEquals(true, Sighting.all().get(0).equals(firstSighting));
  //   assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  // }
  //
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
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
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
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   testSighting.delete();
  //   assertEquals(0, Sighting.all().size());
  // }
  //
  // @Test
  // public void delete_deletesAllPersonsAndCommunitiesAssociations() {
  //   Animal testAnimal = new Animal("Bagheera")
  //   testAnimal.save();
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
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
  //   Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   testSighting.removePerson(testPerson);
  //   List savedPersons = testSighting.getPersons();
  //   assertEquals(0, savedPersons.size());
  // }

}
