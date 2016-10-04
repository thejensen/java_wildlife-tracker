As a ranger I want to be able to report a sighting of a non-endangered animal, that includes the name of the animal and its location only.

As a ranger I want to be able to report a sighting of an endangered animal, that includes the name of the animal, its location, its health and its approximate age.

As a ranger, I want to see a list of animals that have been sighted, by location and/or date last sighted.

As a ranger, I want to see a list of locations that animals have been sighted by date.

As a ranger, I do not want to submit an incomplete form in error.

As a ranger, I want to see a list of sightings of only endangered animals.

How to recreate database:
1)
2)



Assignment details:
Wildlife Tracker
The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. You have been asked to build an application that allows Rangers to track wildlife sightings in the area.

The application must track two categories of wildlife:

Animals

At the very least, require:

id
name

Endangered Animals

Due to their dwindling numbers, Rangers must record additional information about EndangeredAnimals:

id
name
health
Use constants to define options like "healthy", "ill", and "okay".
age (an estimated guess by the ranger)
Use constants to define options like "newborn", "young", or "adult".
Each time an animal species of either category is seen, a Sighting must be reported:

Sightings

When wildlife is spotted, a Ranger submits a form to record a Sighting containing the following:

id of Animal or EndangeredAnimal species
location
(Conveyed in any manner you choose ie: "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values are all acceptable.)
rangerName
Exceptions

It may take a few days for new Rangers to familiarize themselves with the app. To avoid saving incomplete or invalid records, throw and catch exceptions if Rangers attempt to submit an incomplete form, or misuse the application in any other conceivable fashion
