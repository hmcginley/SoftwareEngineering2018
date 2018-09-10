package hw2.race;

public class SlowStartStrategy implements RaceStrategy{
	@Override
	public float runRace(float maxSpeed, String name, float milesRun) {
		if (milesRun <= 6) {
			milesRun += (maxSpeed*0.75) / 3600;
		}
		else if (milesRun > 6 || milesRun <= 9) {
			milesRun += (maxSpeed*0.90) / 3600;
		}
		else {
			milesRun += maxSpeed / 3600;
		}
		
		return milesRun;
	}
}
