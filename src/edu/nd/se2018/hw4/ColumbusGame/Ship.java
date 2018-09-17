package hw4;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable {
	int xCell;
	int yCell;
	int unitSize; // Scaling factor
	OceanMap oceanMap;

	public Ship(int x, int y, int unitSize, OceanMap oceanMap) {
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.oceanMap = oceanMap; // We need a reference to it so we can access the grids!
	}

	public Point getShipLocation() {
		return new Point(xCell, yCell);
	}

	public void goEast() {
		// TODO Auto-generated method stub
		if (oceanMap.validMove(xCell + 1, yCell) == true) {
			xCell++;
			setChanged();
			notifyObservers();
		}
	}

	public void goWest() {
		// TODO Auto-generated method stub
		if (oceanMap.validMove(xCell - 1, yCell) == true) {
			xCell--;
			setChanged();
			notifyObservers();
		}
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		if (oceanMap.validMove(xCell, yCell - 1) == true) {
			yCell--;
			setChanged();
			notifyObservers();
		}
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		if (oceanMap.validMove(xCell, yCell + 1) == true) {
			yCell++;
			setChanged();
			notifyObservers();
		}
	}
}
