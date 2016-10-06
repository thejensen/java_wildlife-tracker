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
  public void animal_instantiatesCorrectly_false() {
    Animal testAnimal = new Animal("Baloo");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Baloo() {
    Animal testAnimal = new Animal("Baloo");
    assertEquals("Baloo", testAnimal.getName());
  }

  @Test
  public void equals_returnsTrueIfNameIsTheSame_false() {
    Animal firstAnimal = new Animal("Baloo");
    Animal anotherAnimal = new Animal("Baloo");
    assertTrue(firstAnimal.equals(anotherAnimal));
  }

  @Test
  public void save_assignsIdToObjectAndSavesObjectToDatabase() {
    Animal testAnimal = new Animal("Baloo");
    testAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(testAnimal.getId(), savedAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfAnimal_false() {
    Animal firstAnimal = new Animal("Baloo");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Shere Khan");
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

  @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animal firstAnimal = new Animal("Baloo");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Shere Khan");
    secondAnimal.save();
    assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }

  @Test
  public void delete_deletesAnimalFromDatabase_0() {
    Animal testAnimal = new Animal("Baloo");
    testAnimal.save();
    testAnimal.delete();
    assertEquals(0, Animal.all().size());
  }

  public void updateName_updatesAnimalNameInDatabase_String() {
    Animal testAnimal = new Animal("Baloo");
    testAnimal.save();
    testAnimal.updateName("Baloooo");
    assertEquals("Baloooo", testAnimal.getName());
  }

  @Test
  public void getSpeciesSpecificSightings_retrievesAllSightingsFromDatabaseWithAnimalId_sightingsList() {
    Animal testAnimal = new Animal("Baloo");
    testAnimal.save();
    Sighting testSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
    testSighting.save();
    Sighting secondTestSighting = new Sighting(testAnimal.getId(), "45.523062, -122.676482", "Ranger Jen");
    secondTestSighting.save();
    Object[] sightings = new Object[] { testSighting, secondTestSighting };
    assertTrue(testAnimal.getSpeciesSpecificSightings().containsAll(Arrays.asList(sightings)));
  }

  @Test
  public void find_returnsNullWhenNoAnimalFound_null() {
    assertTrue(Animal.find(999) == null);
  }

}
