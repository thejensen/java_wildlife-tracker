import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animal {
  private String health;
  private String age;

  public static final String POOR_HEALTH = "Ill";
  public static final String OK_HEALTH = "OK";
  public static final String GOOD_HEALTH = "Healthy";
  public static final String NEWBORN = "Newborn";
  public static final String YOUNG = "Young";
  public static final String ADULT = "Adult";

  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    endangered = true;
    this.health = health;
    this.age = age;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, endangered, health, age) VALUES (:name, :endangered, :health, :age);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("endangered", this.endangered)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<EndangeredAnimal> getEndangeredAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE endangered=true;";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal findEndangeredAnimal(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id;";
      EndangeredAnimal endangeredanimal = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return endangeredanimal;
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public void updateHealth(String health) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET health=:health WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("health", health)
        .executeUpdate();
    }
  }

  public void updateAge(String age) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age=:age WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("age", age)
        .executeUpdate();
    }
  }


}
