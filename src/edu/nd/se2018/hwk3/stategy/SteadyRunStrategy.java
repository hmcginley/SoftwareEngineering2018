package hw2.race;

public class SteadyRunStrategy implements RaceStrategy{
	@Override
	public float runRace(float maxSpeed, String name, float milesRun) {
		milesRun += (maxSpeed * 0.80) / 3600;
		
		return milesRun;
	}
}
