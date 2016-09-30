import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;

public class Sighting {
  private int animal_id;
  private boolean endangered;
  private String lat_long;
  private String ranger_name;
  private int id;
  private Timestamp time_sighted;

  public Sighting(int animal_id, boolean endangered, String lat_long, String ranger_name) {
    this.animal_id = animal_id;
    this.endangered = endangered;
    this.lat_long = lat_long;
    this.ranger_name = ranger_name;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public boolean isEndangered() {
    return endangered;
  }

  public String getLatLong() {
    return lat_long;
  }

  public String getRangerName() {
    return ranger_name;
  }

  public Timestamp getTimeSighted() {
    return time_sighted;
  }

  @Override
  public boolean equals(Object otherSighting) {
    if(!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getAnimalId() == (newSighting.getAnimalId()) && this.isEndangered() == (newSighting.isEndangered()) && this.getLatLong().equals(newSighting.getLatLong()) && this.getRangerName().equals(newSighting.getRangerName()) ;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animal_id, endangered, lat_long, ranger_name, time_sighted) VALUES (:animal_id, :endangered, :lat_long, :ranger_name, now());";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animal_id", this.animal_id)
        .addParameter("endangered", this.endangered)
        .addParameter("lat_long", this.lat_long)
        .addParameter("ranger_name", this.ranger_name)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings;";
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id=:id;";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }




}
