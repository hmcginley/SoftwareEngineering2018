package hw2.strategies;

import hw2.race.RaceStrategy;

public class Horse {
	public RaceStrategy raceStrategy;
	public String name;
	public int horseNumber;
	float maxSpeed;
	public boolean finished = false;
	public float milesRun = 0;
	
	public Horse() {}
	
	public void runRace() {
		milesRun = raceStrategy.runRace(maxSpeed, name, milesRun);
		if (milesRun >= 10) {
			finished = true;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHorseNumber(int horseNumber) {
		this.horseNumber = horseNumber;
	}
	
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public void setRaceStrategy(RaceStrategy raceStrategy) {
		this.raceStrategy = raceStrategy;
	}	
	
	public void setMilesRun(float milesRun) {
		this.milesRun = milesRun;
	}	
}
