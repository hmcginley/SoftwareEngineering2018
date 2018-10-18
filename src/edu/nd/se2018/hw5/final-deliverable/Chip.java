package hw6;

import java.awt.Point;
import java.util.Observable;

public class Chip extends Observable {
	int xCell;
	int yCell;
	int unitSize; // Scaling factor
	int keyCount = 0;
	GameMap GameMap;

	public Chip(int x, int y, int unitSize, GameMap level) {
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.GameMap = level; // We need a reference to it so we can access the grids!
	}

	public Point getChipLocation() {
		return new Point(xCell, yCell);
	}

	public void setChipLocation(int x, int y) {
		this.xCell = x;
		this.yCell = y;
	}

	public void updateLevel(GameMap level) {
		this.GameMap = level;
	}

	public void goEast() {
		if (GameMap.validMove(xCell + 1, yCell) == true) {
			xCell++;

			// Landed on special key
			if (GameMap.getSquareValue(xCell, yCell) > 2) {
				keyCount++;
				GameMap.removeLevelObject(xCell, yCell, unitSize);
			}

			setChanged();
			notifyObservers();
		}
		else {
			if (GameMap.getSquareValue(xCell + 1, yCell) < 0 & keyCount > 0) {
				GameMap.removeLevelObject(xCell + 1, yCell, unitSize);
				xCell++;
				keyCount--;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if (GameMap.validMove(xCell - 1, yCell) == true) {
			xCell--;

			// Landed on special key
			if (GameMap.getSquareValue(xCell, yCell) > 2) {
				keyCount++;
				GameMap.removeLevelObject(xCell, yCell, unitSize);
			}

			setChanged();
			notifyObservers();
		}
		else {
			if (GameMap.getSquareValue(xCell - 1, yCell) < 0 & keyCount > 0) {
				GameMap.removeLevelObject(xCell - 1, yCell, unitSize);
				xCell--;
				keyCount--;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goNorth() {
		if (GameMap.validMove(xCell, yCell - 1) == true) {
			yCell--;

			// Landed on special key
			if (GameMap.getSquareValue(xCell, yCell) > 2) {
				keyCount++;
				GameMap.removeLevelObject(xCell, yCell, unitSize);
			}

			setChanged();
			notifyObservers();
		}
		else {
			if (GameMap.getSquareValue(xCell, yCell - 1) < 0 & keyCount > 0) {
				GameMap.removeLevelObject(xCell, yCell - 1, unitSize);
				yCell--;
				keyCount--;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goSouth() {
		if (GameMap.validMove(xCell, yCell + 1) == true) {
			yCell++;

			// Landed on special key
			if (GameMap.getSquareValue(xCell, yCell) > 2) {
				keyCount++;
				GameMap.removeLevelObject(xCell, yCell, unitSize);
			}

			setChanged();
			notifyObservers();
		}
		else {
			if (GameMap.getSquareValue(xCell, yCell + 1) < 0 & keyCount > 0) {
				GameMap.removeLevelObject(xCell, yCell + 1, unitSize);
				yCell++;
				keyCount--;
				setChanged();
				notifyObservers();
			}
		}
	}
}
