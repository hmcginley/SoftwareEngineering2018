package model.vehicles;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import model.infrastructure.Direction;
import model.infrastructure.gate.CrossingGate;
import view.CarImageSelector;

/**
 * Represents Car object
 * 
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer {
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean hasMovedWest = false;
	private boolean removeOldObservers = false;
	private boolean gateDown = false;
	private double leadCarY = -1; // Current Y position of car directly in front of this one - going South
	private double leadCarX = -1; // Current X position of car directly in front of this one - going West
	private double speed = 0.5;
	private Direction direction;
	private Car leadCar = null;


	/**
	 * Constructor
	 * 
	 * @param x         initial x coordinate of car
	 * @param y         initial y coordinate of car
	 * @param direction
	 */
	public Car(int x, int y, Direction direction) {
		this.currentX = x;
		this.currentY = y;
		this.direction = direction;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}

	@Override
	public Node getImageView() {
		return ivCar;
	}

	public boolean gateIsClosed() {
		return gateDown;
	}

	public double getVehicleX() {
		return currentX;
	}

	public double getVehicleY() {
		return currentY;
	}

	public void move() {
		boolean canMoveSouth = true;
		boolean canMoveWest = true;

		switch (this.getDirection()) {
		case SOUTH:
			canMoveWest = false;
			if (hasMovedWest) {
				removeOldObservers = true;
			}

			// First case. Car is at the front of the stopping line.
			if (gateDown && getVehicleY() < 430 && getVehicleY() > 390)
				canMoveSouth = false;

			// Second case. Car is too close too other car.
			if (leadCarY != -1 && getDistanceToLeadCarY() < 50)
				canMoveSouth = false;

			// Third case. Car can switch lanes and turn West
			if (leadCarY != -1 && getVehicleY() > 630 && getVehicleY() < 641 && getVehicleX() > 775
					&& Math.random() > 0.5) {
				canMoveSouth = false;
				canMoveWest = true;
			}
			break;

		case WEST:
			canMoveSouth = false;
			hasMovedWest = true; // Update flag to know we should update observers when the car turns again

			// First case. Car is too close to other car on East/West road
			if (leadCarX != -1 && getDistanceToLeadCarX() < 50) {
				canMoveWest = false;
			}

			// Second case. Car can switch lanes and turn South
			if (getVehicleX() > 385 && getVehicleX() < 390) {
				canMoveWest = false;
				canMoveSouth = true;
			}
			break;
		}

		if (canMoveWest) {
			this.setDirection(Direction.WEST);
			currentX -= speed;
			ivCar.setX(currentX);
		}

		else if (canMoveSouth) {
			this.setDirection(Direction.SOUTH);
			currentY += speed;
			ivCar.setY(currentY);
		}
		setChanged();
		notifyObservers();
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setGateDownFlag(boolean gateDown) {
		this.gateDown = gateDown;
	}

	public boolean offScreen() {
		if (currentY > 1020)
			return true;
		else
			return false;
	}

	public boolean removeObservers() {
		if (removeOldObservers) {
			hasMovedWest = false;
			return true;
		}
		return false;
	}

	public void reset() {
		currentY = originalY;
	}

	public double getDistanceToLeadCarY() {
		return Math.abs(leadCarY - getVehicleY());
	}

	private double getDistanceToLeadCarX() {
		return Math.abs(leadCarX - getVehicleX());
	}

	public void removeLeadCar() {
		leadCarY = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car && ((Car) o).getDirection() == Direction.SOUTH) {
			leadCarX = -1;
			leadCarY = (((Car) o).getVehicleY());
			if (leadCarY > 1020)
				leadCarY = -1;
		}

		else if (o instanceof Car && ((Car) o).getDirection() == Direction.WEST) {
			leadCarY = -1;
			leadCarX = (((Car) o).getVehicleX());
			if (leadCarX < 435)
				leadCarX = -1;
		}

		if (o instanceof CrossingGate) {
			CrossingGate gate = (CrossingGate) o;
			if (gate.getTrafficCommand() == "STOP")
				gateDown = true;
			else
				gateDown = false;
		}
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
