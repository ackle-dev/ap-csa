/**
 * This question simulates birds or possibly a bear eating at a bird
 * feeder.
 * The following Feeder class contains information about how much food is in the
 * bird feeder and simulates how much food is eaten.
 * You will write two methods of the Feeder class.
 *
 * @question 1
 */
public class Feeder {
	/**
	 * The amount of food, in grams, currently in the bird feeder; initialized in
	 * the constructor and always greater than or equal to zero
	 */
	private int currentFood;

	/**
	 * Simulates one day with numBirds birds or possibly a bear at the bird feeder,
	 * as described in part (a)
	 * Precondition: numBirds > 0
	 *
	 * @part a
	 */
	public void simulateOneDay(int numBirds) {
		/*
		 * Write the simulateOneDay method, which simulates numBirds birds or possibly a
		 * bear at the feeder for one day. The method determines the amount of food
		 * taken from the feeder on this day and updates the currentFood instance
		 * variable. The simulation accounts for normal conditions, which occur 95% of
		 * the time, and abnormal conditions, which occur 5% of the time.
		 * Under normal conditions, the simulation assumes that on any given day, only
		 * birds visit the feeder and that each bird at the feeder consumes the same
		 * amount of food. This standard amount consumed is between 10 and 50 grams of
		 * food, inclusive, in 1-gram increments. That is, on any given day, each bird
		 * might eat 10, 11, . . . , 49, or 50 grams of food. The amount of food eaten
		 * by each bird on a given day is randomly generated and each integer from 10 to
		 * 50, inclusive, has an equal chance of being chosen.
		 * For example, a run of the simulation might predict that for a certain day
		 * under normal conditions, each bird coming to the feeder will eat 11 grams of
		 * food. If 10 birds come to the feeder on that day, then a total of 110 grams
		 * of food will be consumed.
		 * If the simulated food consumed is greater than the amount of food in the
		 * feeder, the birds empty the feeder and the amount of food in the feeder at
		 * the end of the day is zero.
		 * Under abnormal conditions, a bear empties the feeder and the amount of food
		 * in the feeder at the end of the day is zero.
		 * The following examples show possible results of three calls to
		 * simulateOneDay.
		 * • Example 1: If the feeder initially contains 500 grams of food, the call
		 * simulateOneDay(12) could result in 12 birds eating 20 grams of food each,
		 * leaving 260 grams of food in the feeder.
		 * • Example 2: If the feeder initially contains 1,000 grams of food, the call
		 * simulateOneDay(22) could result in a bear eating all the food, leaving 0
		 * grams of
		 * food in the feeder.
		 * • Example 3: If the feeder initially contains 100 grams of food, the call
		 * simulateOneDay(5) could result in 5 birds attempting to eat 30 grams of food
		 * each. Since the feeder initially contains less than 150 grams of food, the
		 * feeder is
		 * emptied, leaving 0 grams of food in the feeder.
		 */
		if (Math.random() < .05) // bear
			currentFood = 0;
		else { // normal birds
			currentFood -= numBirds * ((int) (Math.random() * 41) + 10);
			if (currentFood < 0)
				currentFood = 0;
		}
	}

	/**
	 * Returns the number of days birds or a bear found food to eat at the feeder in
	 * this simulation, as described in part (b)
	 * Preconditions: numBirds > 0, numDays > 0
	 *
	 * @part b
	 */
	public int simulateManyDays(int numBirds, int numDays) {
		int accumulator = 0;
		for (int day = 0; day < numDays; day++) {
			if (currentFood <= 0)
				break;
			if (currentFood > 0)
				accumulator++;
			simulateOneDay(numBirds);
		}
		return accumulator;
	}
}
