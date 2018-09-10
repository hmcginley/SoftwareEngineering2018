package hw2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw2.race.EarlySprintStrategy;
import hw2.race.RaceStrategy;
import hw2.race.SteadyRunStrategy;
import hw2.strategies.Horse;

/**
 * Tests changing horses' features
 * @author Hugh
 *
 */
class TestChanges {

	@Test
	public void testChanges() {
		Horse horse = new Horse();
		RaceStrategy early = new EarlySprintStrategy();
		RaceStrategy steady = new SteadyRunStrategy();
		
		horse.setHorseNumber(15);
		horse.setMaxSpeed(25);
		horse.setName("Horsey");
		horse.setRaceStrategy(early);
		assert(horse.milesRun == 0);
		assert(horse.finished == false);
		assert(horse.horseNumber == 15);
		assert(horse.name == "Horsey");
		assert(horse.raceStrategy == early);
		
		horse.setMilesRun(50);
		horse.setHorseNumber(-1);
		horse.setMaxSpeed(70);
		horse.setName("Horsey2");
		horse.setRaceStrategy(steady);
		
		assert(horse.milesRun == 50);
		
		horse.runRace();
		
		assert(horse.finished == true);
		assert(horse.horseNumber == -1);
		assert(horse.name == "Horsey2");
		assert(horse.raceStrategy == steady);
	}

}
