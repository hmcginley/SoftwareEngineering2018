package model.vehicles;

import javafx.scene.Node;
import model.infrastructure.Direction;

public interface IVehicle {
	public Node getImageView();

	public double getVehicleX();

	public double getVehicleY();

	public void move();

	public boolean offScreen();

	public void reset();

	public Direction getDirection();
}
