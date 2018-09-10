package hw2.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import hw2.race.*;
import hw2.Race;
import hw2.strategies.*;

/**
 * Tests the outcomes of multiple races
 * @author Hugh
 *
 */
class TestRace {

	@Test
	public void testRaceOne() {
		Race race = new Race();
		race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		race.enrollHorse("Molly",1,24,new SlowStartStrategy());
		race.enrollHorse("Joe",2,25,new EarlySprintStrategy());
		race.enrollHorse("Blizzard",3,25,new SlowStartStrategy());
		race.enrollHorse("Flicker",4,25,new SteadyRunStrategy());
		assert(race.runRace() == "Blizzard");
	}
	
	@Test
	public void testRaceTwo() {
		Race race = new Race();
		race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		race.enrollHorse("Molly",1,22,new EarlySprintStrategy());
		assert(race.runRace() == "Sam");
	}

	@Test
	public void testRaceThree() {
		Race race = new Race();
		race.enrollHorse("Sam",0,100,new EarlySprintStrategy());
		race.enrollHorse("Molly",1,100,new SlowStartStrategy());
		assert(race.runRace() == "Molly");
	}
}
