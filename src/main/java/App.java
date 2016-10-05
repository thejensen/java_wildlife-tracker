import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------

    //posts from /animal/new/
    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");

      Animal animal = new Animal(name);
      animal.save();
      int animalId = animal.getId();

      String health = request.queryParams("health");
      String age = request.queryParams("age");
      EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
      endangeredAnimal.save();
      int endangeredAnimalId = endangeredAnimal.getId();

      // what is "id", id used for again??
      model.put("animalId", animalId);
      model.put("endangeredAnimalId", endangeredAnimalId);

      model.put("success-add", animal.getName());

      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------

    get("/animal/:id/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Animal animal  = Animal.find(Integer.parseInt(request.params("id")));
      model.put("animal", animal);

      // may not need this
      model.put("sightings", animal.getSpeciesSpecificSightings());

      model.put("template", "templates/sighting-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------

    get("/sightings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------

    // posts from sighting/new or sighting-form.vtl
    post("/animal/:id/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangerName = request.queryParams("rangerName");
      String animalName = request.queryParams("animalName");
      String latLong = request.queryParams("latLong");
      String endangered = request.queryParams("endangered");
      String health = request.queryParams("health");
      String age = request.queryParams("age");


      // whyyyyyyy
      int sightingId = Integer.parseInt(request.queryParams("sightingId"));

      Animal animal  = Animal.find(Integer.parseInt(request.params("id")));
      Sighting sighting = new Sighting(animal.getId(), latLong, rangerName);
      sighting.save();

      model.put("sightings", animal.getSpeciesSpecificSightings());
      model.put("animalName", animalName);
      model.put("endangered", endangered);
      model.put("sighting", sighting);
      model.put("success-add", sighting.getId());
      model.put("template", "templates/sightings.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------

    // get("/sighting/:id/update", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Sighting sighting  = Sighting.find(Integer.parseInt(request.params("id")));
    //   Sighting sighting = Sighting.find(sighting.getSightingId());
    //   model.put("sightings", Sighting.all());
    //   model.put("sighting", sighting);
    //   model.put("sighting", sighting);
    //   model.put("template", "templates/sighting-update.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    // post("/sighting/:id/update", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Sighting sighting = Sighting.find(Integer.parseInt(request.params("id")));
    //   String endangered = request.queryParams("endangered");
    //   String name = request.queryParams("name");
    //   int sightingId = Integer.parseInt(request.queryParams("sightingId"));
    //   Sighting sighting = Sighting.find(sighting.getSightingId());
    //   sighting.updateDescription(endangered);
    //   sighting.updateName(name);
    //   sighting.updateSighting(sightingId);
    //   String url = String.format("/sighting/%d", sightingId);
    //   response.redirect(url);
    //   return null;
    // });
    //
    //
    // post("/sighting/:sighting_id/sighting/:id/delete", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Sighting sighting = Sighting.find(Integer.parseInt(request.params("id")));
    //   Sighting sighting = Sighting.find(sighting.getSightingId());
    //   // model.put("success-delete", sighting.getName());
    //   sighting.delete();
    //   String url = String.format("/");
    //   response.redirect(url);
    //   return null;
    // });

    // get("/animal/:id/update", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Animal animal  = Animal.find(Integer.parseInt(request.params("id")));
    //   model.put("animal", animal);
    //   model.put("template", "templates/animal-update.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/animal/:id/update", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Animal animal = Animal.find(Integer.parseInt(request.params("id")));
    //   String endangered = request.queryParams("endangered");
    //   animal.updateDescription(endangered);
    //   String name = request.queryParams("name");
    //   animal.updateName(name);
    //   model.put("success-edit", animal.getName());
    //   String url = String.format("/animal/%d", animal.getId());
    //   response.redirect(url);
    //   return null;
    // });
    //
    // post("/animal/:id/delete", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Animal animal = Animal.find(Integer.parseInt(request.params("id")));
    //   animal.delete();
    //   String url = String.format("/");
    //   response.redirect(url);
    //   return null;
    // });
  }
}
