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

    // Homepage, index.vtl. Info posts from /animal/new
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      model.put("sightings", Sighting.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// --------------------------------------------------------------

    // Post request for success, which goes to homepage, Info posts from /animal/new, also posts from Homepage form.
    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // Report a sighting form on /
      String rangerName = request.queryParams("rangerName");
      int animalIdSelected = Integer.parseInt(request.queryParams("animalSelected"));
      String latLong = request.queryParams("latLong");
      // Instantiates new sighting.
      Sighting sighting = new Sighting(animalIdSelected, latLong, rangerName);
      sighting.save();
      model.put("sighting", sighting);
      // required for Animal selector in sighting form...maybe?
      model.put("animals", Animal.all());
      // used for success message.
      String animal = Animal.find(animalIdSelected).getName();
      model.put("animal", animal);
      // Success message posts to / immediately upon adding an Animal, but we go to success.vtl after posting.
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// --------------------------------------------------------------
    // This is the animal-form whose info is posted to the Homepage.
    get("/animal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // contant options from EndangeredAnimal class that are used as inputs here. Feels convoluted, but I see that they can be used to ensure very strict options are used for the front end dictacted by the backend.
      model.put("Poor", EndangeredAnimal.POOR_HEALTH);
      model.put("Ok", EndangeredAnimal.OK_HEALTH);
      model.put("Good", EndangeredAnimal.GOOD_HEALTH);
      model.put("Newborn", EndangeredAnimal.NEWBORN);
      model.put("Young", EndangeredAnimal.YOUNG);
      model.put("Adult", EndangeredAnimal.ADULT);

      // Animal.all and EndangeredAnimal.all are here so that the ranger can see if their animal has already been added.
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      model.put("template", "templates/animal-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// -----------------------------------------------------------------------------------------------
    post("/animal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // boolean endangered refers to checkbox in animal-form; since we instantiate Animal with endangered attribute false, and Endangered Animal with endangered attribute true, this var can be used to as a front-end conditional to instantiate EITHER the animal or the endangered animal, depending on whether the box was checked.
      boolean endangered = request.queryParamsValues("endangered")!=null;
      if (endangered) {
        // Instantiate EndangeredAnimal with additional form inputs specific to the subclass constructor.
        String name = request.queryParams("name");
          try {
            if(name.equals("")) {
              throw new UnsupportedOperationException("Missing Input");
            }
          } catch (java.lang.UnsupportedOperationException exception) {
            model.put("error", "Please enter the animal name. It's worth it!");
          }
        String health = request.queryParams("health");
        String age = request.queryParams("age");
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
        endangeredAnimal.save();
        model.put("animals", Animal.all());
        model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      } else {
        // instantiate Animal with form inputs for the superclass constructor.
        String name = request.queryParams("name");
        Animal animal = new Animal(name);
        animal.save();
        model.put("animals", Animal.all());
        model.put("endangeredAnimals", EndangeredAnimal.getEndangeredAnimals());
      }

      // because there wooould be multiple post requests to / the way I've set this up, let's post to animal/new and redirect to /.
      response.redirect("/");
        return null;
      });
// -----------------------------------------------------------------------------------------------

    get("/animal/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Animal animal = Animal.find(Integer.parseInt(request.params("id")));
      model.put("animal", animal);
      model.put("template", "templates/animal.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
