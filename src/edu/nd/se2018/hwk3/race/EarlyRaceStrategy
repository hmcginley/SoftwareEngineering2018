package hw2.race;

public class EarlySprintStrategy implements RaceStrategy{
	@Override
	public float runRace(float maxSpeed, String name, float milesRun) {
		if (milesRun <= 2) {
			milesRun += maxSpeed / 3600;
		}
		else {
			milesRun += (maxSpeed*0.75) / 3600;
		}
		
		return milesRun;
	}
}
