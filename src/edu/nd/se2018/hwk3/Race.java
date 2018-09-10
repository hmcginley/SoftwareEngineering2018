package hw2;
import hw2.strategies.*;
import hw2.race.*;
import java.util.ArrayList;

public class Race {
	ArrayList<Horse> horseArray = new ArrayList<Horse>();
	String winner;
	
	public Race() {}
	
	public void enrollHorse(String name, int horseNumber, int maxSpeed, RaceStrategy raceStrategy) {
		Horse horse = new Horse();
		horse.setName(name);
		horse.setHorseNumber(horseNumber);
		horse.setMaxSpeed(maxSpeed);
		horse.setRaceStrategy(raceStrategy);
		horseArray.add(horse);
	}
	
	public String runRace() {
		int printCounter = 15;
		while (true) {
			for (int i = 0; i < horseArray.size(); i++) {
				if (horseArray.get(i).finished) {
					winner = horseArray.get(i).name;
					System.out.print("WINNER: " + winner);
					return winner;
				}
				else {
					printCounter++;
					if (printCounter >= 15) {
						System.out.println(horseArray.get(i).name + " has run " + horseArray.get(i).milesRun + " miles");							printCounter = 0;
					}
						
					horseArray.get(i).runRace();
				}
			}
		}
	}
}
