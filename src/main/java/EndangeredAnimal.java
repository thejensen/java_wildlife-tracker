import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animal {
  private String health;
  private String age;

  public static final String POOR_HEALTH = "ill";
  public static final String OK_HEALTH = "ok";
  public static final String GOOD_HEALTH = "healthy";
  public static final String NEWBORN = "newbord";
  public static final String YOUNG = "young";
  public static final String ADULT = "adult";

  public EndangeredAnimal(String name, boolean endangered, String health, String age) {
    super(name, endangered);
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

  public static List<EndangeredAnimal> allEndangeredAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE endangered=true;";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .executeAndFetch(EndangeredAnimal.class);
    }
  }


}
