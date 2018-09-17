package hw4;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer {
	int xCell;
	int yCell;
	int unitSize;
	OceanMap oceanMap;
	Ship CCship;
	Point coords;

	public PirateShip(int x, int y, int unitSize, OceanMap oceanMap) {
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.oceanMap = oceanMap;
	}

	@Override
	public void update(Observable observable, Object arg1) {
		CCship = (Ship) observable;
		coords = CCship.getShipLocation();
		int xCoordCC = coords.x;
		int yCoordCC = coords.y;
		int currDistance = getDistance(xCell, xCoordCC, yCell, yCoordCC);

		if (oceanMap.validMove(xCell + 1, yCell) && getDistance(xCell + 1, xCoordCC, yCell, yCoordCC) < currDistance) {
			xCell++;
		} else if (oceanMap.validMove(xCell - 1, yCell)
				&& getDistance(xCell - 1, xCoordCC, yCell, yCoordCC) < currDistance) {
			xCell--;
		} else if (oceanMap.validMove(xCell, yCell + 1)
				&& getDistance(xCell, xCoordCC, yCell + 1, yCoordCC) < currDistance) {
			yCell++;
		} else if (oceanMap.validMove(xCell, yCell - 1)
				&& getDistance(xCell, xCoordCC, yCell - 1, yCoordCC) < currDistance) {
			yCell--;
		}
	}

	public int getDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public Point getShipLocation() {
		return new Point(xCell, yCell);
	}
}
