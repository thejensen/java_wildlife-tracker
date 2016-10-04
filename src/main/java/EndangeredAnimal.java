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
}
