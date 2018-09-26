package model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.infrastructure.Direction;

/**
 * Represents the train entity object
 * 
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle {
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private Direction direction;

	public Train(int x, int y, Direction direction) {
		this.currentX = x;
		this.currentY = y;
		this.direction = direction;
		originalX = x;

		// Set proper train image
		switch (direction) {
		case WEST:
			img = new Image("images\\Train.PNG", 120, trainLength, false, false);
			break;
		case EAST:
			img = new Image("images\\TrainReverse.PNG", 120, trainLength, false, false);
			break;
		default:
			img = new Image("images\\Train.PNG", 120, trainLength, false, false); // Set regular train as default
			break;
		}

		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}

	public double getVehicleX() {
		return currentX;
	}

	public double getVehicleY() {
		return currentY;
	}

	public void move() {
		switch (this.getDirection()) {
		case EAST:
			currentX += 2;
			break;
		case WEST:
			currentX -= 2;
			break;
		}

		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}

	public boolean offScreen() {
		if (currentX < -200 || currentX > 2000)
			return true;
		else
			return false;
	}

	public void reset() {
		currentX = originalX;
	}

	// @Override
	public Node getImageView() {
		return imgView;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}
}