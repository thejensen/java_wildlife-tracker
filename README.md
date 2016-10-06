# _Wildlife Tracker_

#### _An app for the forest service to track animals for an environmental impact study, October 5, 2016_

#### By _**Sara Jensen**_

## Description

_**The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. Use this page to track wildlife sightings in the area.**_

## Setup/Installation Requirements

_To run app locally:_
* _Make sure you have the Java Development Kit (JDK) and a Java Runtime Environment (JRE) installed._
* _Install Gradle_

* _Clone https://github.com/thejensen/java_wildlife-tracker to your desktop_
* _In terminal, navigate to java_wildlife-tracker_

_Next, recreate the hair-salon database in PSQL:_
* _Make sure postgres is running by executing $postgres, then..._
* _$psql_
* _CREATE DATABASE wildlife_tracker;_
* _\c wildlife_tracker_
* _CREATE TABLE animals (id serial PRIMARY KEY, name varchar, endangered boolean, health varchar, age varchar);_
* _CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, lat_long varchar, ranger_name varchar, time_sighted timestamp);_
* _CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

_Finally, we can run the app by..._
* _In a new terminal tab (or "ctrl c" out of psql) execute $gradle run_
* _In your browser (preferably latest version of Chrome), go to localhost:4567._

## User Stories

* As a ranger I want to be able to report a sighting of a non-endangered animal, that includes the name of the animal and its location only.
* As a ranger I want to be able to report a sighting of an endangered animal, that includes the name of the animal, its location, its health and its approximate age.
* As a ranger, I want to see a list of animals that have been sighted, by location and/or date last sighted.
* As a ranger, I want to see a list of locations that animals have been sighted by date.
* As a ranger, I do not want to submit an incomplete form in error.
* As a ranger, I want to see a list of sightings of only endangered animals.

## Known Bugs

* _No known bugs_

## Support and contact details

_If you run into any issues, have questions, ideas or concerns, or want to make a contribution to the code, contact me at jensen.sara.e@gmail.com._

## Technologies Used

_Java, Spark, Velocity, jUnit, Postgres/PSQL._


### License

Copyright (c) 2016 **_MIT License_**
