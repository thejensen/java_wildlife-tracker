import org.sql2o.*;
import static org.junit.Assert.*;
import org.junit.*;


public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void endangeredAnimal_instantiatesCorrectly_true() {
  //   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
  //   assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  // }
  //
  // @Test
  // public void EndangeredAnimal_instantiatesWithName_String() {
  //   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
  //   assertEquals("Kaa", testEndangeredAnimal.getName());
  // }

//   @Test
//   public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Bubbles", 1);
//     assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
//   }
//
//   @Test
//   public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.save();
//     assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
//   }
//
//   @Test
//   public void save_assignsIdToEndangeredAnimal() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.save();
//     EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
//     assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfEndangeredAnimal_true() {
//     EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Bubbles", 1);
//     firstEndangeredAnimal.save();
//     EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Spud", 3);
//     secondEndangeredAnimal.save();
//     assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
//     assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
//   }
//
//   @Test
//   public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
//     EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Bubbles", 1);
//     firstEndangeredAnimal.save();
//     EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Spud", 3);
//     secondEndangeredAnimal.save();
//     assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
//   }
//
//   @Test
//   public void save_savesPersonIdIntoDB_true() {
//     Person testPerson = new Person("Henry", "henry@henry.com");
//     testPerson.save();
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles", testPerson.getId());
//     testEndangeredAnimal.save();
//     EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.find(testEndangeredAnimal.getId());
//     assertEquals(savedEndangeredAnimal.getPersonId(), testPerson.getId());
//   }
//
//   @Test
//   public void endangeredAnimal_instantiatesWithHalfFullPlayLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     assertEquals(testEndangeredAnimal.getPlayLevel(), (EndangeredAnimal.MAX_PLAY_LEVEL / 2));
//   }
//
//   @Test
//   public void endangeredAnimal_instantiatesWithHalfFullSleepLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     assertEquals(testEndangeredAnimal.getSleepLevel(), (EndangeredAnimal.MAX_SLEEP_LEVEL / 2));
//   }
//
//   @Test
//   public void endangeredAnimal_instantiatesWithHalfFullFoodLevel(){
//    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles", 1);
//    assertEquals(testEndangeredAnimal.getFoodLevel(), (EndangeredAnimal.MAX_FOOD_LEVEL / 2));
//   }
//
//   @Test
//   public void isAlive_confirmsEndangeredAnimalIsAliveIfAllLevelsAboveMinimum_true(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     assertEquals(testEndangeredAnimal.isAlive(), true);
//   }
//
//   @Test
//   public void depleteLevels_reducesAllLevels(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.depleteLevels();
//     assertEquals(testEndangeredAnimal.getFoodLevel(), (EndangeredAnimal.MAX_FOOD_LEVEL / 2) - 1);
//     assertEquals(testEndangeredAnimal.getSleepLevel(), (EndangeredAnimal.MAX_SLEEP_LEVEL / 2) - 1);
//     assertEquals(testEndangeredAnimal.getPlayLevel(), (EndangeredAnimal.MAX_PLAY_LEVEL / 2) - 1);
//     assertEquals(testEndangeredAnimal.getFireLevel(), (EndangeredAnimal.MAX_FIRE_LEVEL / 2) - 1);
//   }
//
//   @Test
//   public void isAlive_recognizesEndangeredAnimalIsDeadWhenLevelsReachMinimum_false(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= EndangeredAnimal.MAX_FOOD_LEVEL; i++){
//       testEndangeredAnimal.depleteLevels();
//     }
//     assertEquals(testEndangeredAnimal.isAlive(), false);
//   }
//
//   @Test
//   public void play_increasesEndangeredAnimalPlayLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.play();
//     assertTrue(testEndangeredAnimal.getPlayLevel() > (EndangeredAnimal.MAX_PLAY_LEVEL / 2));
//   }
//
//   @Test
//   public void sleep_increasesEndangeredAnimalSleepLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.sleep();
//     assertTrue(testEndangeredAnimal.getSleepLevel() > (EndangeredAnimal.MAX_SLEEP_LEVEL / 2));
//   }
//
//   @Test
//   public void feed_increasesEndangeredAnimalFoodLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.feed();
//     assertTrue(testEndangeredAnimal.getFoodLevel() > (EndangeredAnimal.MAX_FOOD_LEVEL / 2));
//   }
//
//   // Usually, JUnit fails a test if it receive an exception of any kind. However, because we're specifically testing for an exception, we must let JUnit know that we're intentionally looking for that exception. That is, the test shouldn't fail if it receives an exception, it should pass as long as it receives the correct exception.
//   //
//   @Test
//   public void endangeredAnimal_foodLevelCannotGoBeyondMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_FOOD_LEVEL); i++){
//       try {
//         testEndangeredAnimal.feed();
//       } catch (UnsupportedOperationException exception){ }
//     }
//     assertTrue(testEndangeredAnimal.getFoodLevel() <= EndangeredAnimal.MAX_FOOD_LEVEL);
//   }
//
//   @Test(expected = UnsupportedOperationException.class)
//   public void feed_throwsExceptionIfFoodLevelIsAtMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_FOOD_LEVEL); i++){
//       testEndangeredAnimal.feed();
//     }
//   }
//
//   @Test(expected = UnsupportedOperationException.class)
//   public void play_throwsExceptionIfPlayLevelIsAtMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_PLAY_LEVEL); i++){
//       testEndangeredAnimal.play();
//     }
//   }
//
//   @Test
//   public void endangeredAnimal_playLevelCannotGoBeyondMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_PLAY_LEVEL); i++){
//       try {
//         testEndangeredAnimal.play();
//       } catch (UnsupportedOperationException exception){ }
//     }
//     assertTrue(testEndangeredAnimal.getPlayLevel() <= EndangeredAnimal.MAX_PLAY_LEVEL);
//   }
//
//   @Test
//   public void endangeredAnimal_sleepLevelCannotGoBeyondMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_SLEEP_LEVEL); i++){
//       try {
//         testEndangeredAnimal.sleep();
//       } catch (UnsupportedOperationException exception){ }
//     }
//     assertTrue(testEndangeredAnimal.getSleepLevel() <= EndangeredAnimal.MAX_SLEEP_LEVEL);
//   }
//
//   @Test
//   public void sleep_recordsTimeLastSleptInDatabase() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.save();
//     testEndangeredAnimal.sleep();
//     Timestamp savedEndangeredAnimalLastSlept = EndangeredAnimal.find(testEndangeredAnimal.getId()).getLastSlept();
//     Timestamp rightNow = new Timestamp(new Date().getTime());
//     assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedEndangeredAnimalLastSlept));
//   }
//
//   @Test
//   public void feed_recordsTimeLastAteInDatabase() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.save();
//     testEndangeredAnimal.feed();
//     Timestamp savedEndangeredAnimalLastAte = EndangeredAnimal.find(testEndangeredAnimal.getId()).getLastAte();
//     Timestamp rightNow = new Timestamp(new Date().getTime());
//     assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedEndangeredAnimalLastAte));
//   }
//
//   @Test
//   public void play_recordsTimeLastPlayedInDatabase() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kaa", "healthy", "newborn");
//     testEndangeredAnimal.save();
//     testEndangeredAnimal.play();
//     Timestamp savedEndangeredAnimalLastPlayed = EndangeredAnimal.find(testEndangeredAnimal.getId()).getLastPlayed();
//     Timestamp rightNow = new Timestamp(new Date().getTime());
//     assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedEndangeredAnimalLastPlayed));
//   }
//
//   @Test
//   public void timer_executesDeleteLevelsMethod() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Dr. Bubbles", 1);
//     int firstPlayLevel = testEndangeredAnimal.getPlayLevel();
//     testEndangeredAnimal.startTimer();
//     try {
//       Thread.sleep(6000);
//     } catch (InterruptedException exception) {}
//     int secondPlayLevel = testEndangeredAnimal.getPlayLevel();
//     assertTrue(firstPlayLevel > secondPlayLevel);
//   }
//
//   @Test
//   public void timer_haltsAfterEndangeredAnimalDies() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Dr. Bubbles", 1);
//     testEndangeredAnimal.startTimer();
//     try {
//       Thread.sleep(6000);
//     } catch (InterruptedException exception) {}
//     assertFalse(testEndangeredAnimal.isAlive());
//     assertTrue(testEndangeredAnimal.getFoodLevel() >= 0);
//   }
//
//   @Test
//   public void endangeredAnimal_instantiatesWithHalfFullFireLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Smokey", 1);
//     assertEquals(testEndangeredAnimal.getFireLevel(), (EndangeredAnimal.MAX_FIRE_LEVEL / 2));
//   }
//
//   @Test
//   public void kindling_increasesEndangeredAnimalFireLevel(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Smokey", 1);
//     testEndangeredAnimal.kindling();
//     assertTrue(testEndangeredAnimal.getFireLevel() > (EndangeredAnimal.MAX_FIRE_LEVEL / 2));
//   }
//
//   @Test(expected = UnsupportedOperationException.class)
//   public void kindling_throwsExceptionIfFireLevelIsAtMaxValue(){
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Smokey", 1);
//     for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_FIRE_LEVEL); i++){
//       testEndangeredAnimal.kindling();
//     }
//   }
//
//   @Test
//   public void kindling_recordsTimeLastKindlingInDatabase() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Dr. Bubbles", 1);
//     testEndangeredAnimal.save();
//     testEndangeredAnimal.kindling();
//     Timestamp savedEndangeredAnimalLastKindling = EndangeredAnimal.find(testEndangeredAnimal.getId()).getLastKindling();
//     Timestamp rightNow = new Timestamp(new Date().getTime());
//     assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedEndangeredAnimalLastKindling));
//   }
//
//   @Test
//   public void delete_deletesAllEndangeredAnimalsFromDatabase_0() {
//     EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Dr. Bubbles", 1);
//     testEndangeredAnimal.save();
//     testEndangeredAnimal.delete();
//     assertEquals(null, EndangeredAnimal.find(testEndangeredAnimal.getId()));
//   }
<<<<<<< HEAD


}
=======
//
//
// }
>>>>>>> ed83cfd93a2507a76524fcb0c4e6296032e05d36
