import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AnimalTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Baloo", true);
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Baloo() {
    Animal testAnimal = new Animal("Baloo", true);
    assertEquals("Baloo", testAnimal.getName());
  }

  @Test
  public void equals_returnsTrueIfNameIsTheSame_true() {
    Animal firstAnimal = new Animal("Baloo", true);
    Animal anotherAnimal = new Animal("Baloo", true);
    assertTrue(firstAnimal.equals(anotherAnimal));
  }

  @Test
  public void save_assignsIdToObjectAndSavesObjectToDatabase() {
    Animal testAnimal = new Animal("Baloo", true);
    testAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(testAnimal.getId(), savedAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal firstAnimal = new Animal("Baloo", true);
    firstAnimal.save();
    Animal secondAnimal = new Animal("Shere Khan", false);
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

  @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animal firstAnimal = new Animal("Baloo", true);
    firstAnimal.save();
    Animal secondAnimal = new Animal("Shere Khan", false);
    secondAnimal.save();
    assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }

  @Test
  public void delete_deletesAnimalFromDatabase_0() {
    Animal testAnimal = new Animal("Baloo", true);
    testAnimal.save();
    testAnimal.delete();
    assertEquals(0, Animal.all().size());
  }

  public void updateName_updatesAnimalNameInDatabase_String() {
    Animal testAnimal = new Animal("Baloo", true);
    testAnimal.save();
    testAnimal.updateName("Baloooo");
    assertEquals("Baloooo", testAnimal.getName());
  }

  public void updateEndangerment_updatesAnimalEndangermentInDatabase_String() {
    Animal testAnimal = new Animal("Baloo", true);
    testAnimal.save();
    testAnimal.updateEndangerment(false);
    assertEquals("Baloooo", testAnimal.getName());
  }

  @Test
  public void getSpeciesSpecificSightings_retrievesAllSightingsFromDatabaseWithAnimalId_sightingsList() {
    Animal testAnimal = new Animal("Baloo", true);
    testAnimal.save();
    Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    Sighting secondTestSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
    secondTestSighting.save();
    Object[] sightings = new Object[] { testSighting, secondTestSighting };
    assertTrue(testAnimal.getSpeciesSpecificSightings().containsAll(Arrays.asList(sightings)));
  }

  // @Test
  // public void delete_deletesAllAnimalsAndSightingAssoc() {
  //  Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
  //   testSighting.save();
  //   Animal testAnimal = new Animal("Baloo", true);
  //   testAnimal.save();
  //   testSighting.addAnimal(testAnimal);
  //   testAnimal.delete();
  //   assertEquals(0, testSighting.getAnimals().size());
  // }

}
