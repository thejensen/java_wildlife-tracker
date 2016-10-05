import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EndangeredAnimalTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getHealth_returnsHealth_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    assertEquals("healthy", testEndangeredAnimal.getHealth());
  }

  @Test
  public void save_assignsIdToObjectAndSavesObjectToDatabase() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    testEndangeredAnimal.save();
    EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.getEndangeredAnimals().get(0);
    assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
  }

  @Test
  public void getEndangeredAnimals_returnsInstancesOfEndangeredAnimal_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Shere Khan", "ok", "adult");
    secondEndangeredAnimal.save();
    assertEquals(true, EndangeredAnimal.getEndangeredAnimals().get(0).equals(firstEndangeredAnimal));
    assertEquals(true, EndangeredAnimal.getEndangeredAnimals().get(1).equals(secondEndangeredAnimal));
  }

  @Test
  public void findEndangeredAnimal_returnsAnimalWithSameId_secondAnimal() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Shere Khan", "ok", "adult");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.findEndangeredAnimal(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
  }

  @Test
  public void findEndangeredAnimal_returnsNullWhenNoAnimalFound_null() {
    assertTrue(Animal.find(999) == null);
  }

  @Test
  public void update_updatesHealth_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    testEndangeredAnimal.save();
    testEndangeredAnimal.updateHealth("ill");
    assertEquals("ill", EndangeredAnimal.findEndangeredAnimal(testEndangeredAnimal.getId()).getHealth());
  }

  @Test
  public void update_updatesAge_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Mogwai", "healthy", "young");
    testEndangeredAnimal.save();
    testEndangeredAnimal.updateAge("adult");
    assertEquals("adult", EndangeredAnimal.findEndangeredAnimal(testEndangeredAnimal.getId()).getAge());
  }

}
