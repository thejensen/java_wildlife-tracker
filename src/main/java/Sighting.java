import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;

public class Sighting {
  private int animalId;
  private boolean endangered;
  private String latLong;
  private String rangerName;
  private int id;
  private Timestamp timeSighted;

  public Sighting(int animalId, boolean endangered, String latLong, String rangerName) {
    this.animalId = animalId;
    this.endangered = endangered;
    this.latLong = latLong;
    this.rangerName = rangerName;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getAnimalId() {
    return animalId;
  }

  public boolean isEndangered() {
    return endangered;
  }

  public String getLatLong() {
    return latLong;
  }

  public String getRangerName() {
    return rangerName;
  }

  public Timestamp getTimeSighted() {
    return timeSighted;
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
        .addParameter("animal_id", this.animalId)
        .addParameter("endangered", this.endangered)
        .addParameter("lat_long", this.latLong)
        .addParameter("ranger_name", this.rangerName)
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
