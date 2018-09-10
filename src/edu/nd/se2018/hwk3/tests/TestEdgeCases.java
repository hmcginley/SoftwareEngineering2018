package hw2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import hw2.race.*;
import hw2.Race;
import hw2.strategies.*;

/**
 * Tests miles run at edge cases
 * @author Hugh
 *
 */
class TestEdgeCases {

	@Test
	public void testZeroMiles() {
		Horse horse = new Horse();
		assert(horse.milesRun == 0);
		assert(horse.finished == false);
	}
	
	@Test
	public void testEndOfRace() {
		Horse horse = new Horse();
		assert(horse.milesRun == 0);
		assert(horse.finished == false);
		horse.setMilesRun((float) 10);	
		horse.setName("Stringer");
		horse.setMaxSpeed(25);
		horse.setRaceStrategy(new EarlySprintStrategy());
		horse.runRace();
		assert(horse.milesRun > 10);
		assert(horse.finished == true);
	}

}
