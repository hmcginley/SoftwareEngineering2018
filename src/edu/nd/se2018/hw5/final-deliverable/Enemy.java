package hw6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Enemy implements Observer {
	int xCell;
	int yCell;
	int unitSize;
	GameMap gameMap;
	Chip chip;
	Point coords;

	public Enemy(int x, int y, int unitSize, GameMap gameMap) {
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.gameMap = gameMap;
	}

	@Override
	public void update(Observable observable, Object arg1) {
		chip = (Chip) observable;
		coords = chip.getChipLocation();
		int xCoord = coords.x;
		int yCoord = coords.y;
		int currDistance = getDistance(xCell, xCoord, yCell, yCoord);
		Random rand = new Random();
		int n = rand.nextInt(50) + 1;

		if (n > 35) {
			if (gameMap.validMove(xCell + 1, yCell)
					&& getDistance(xCell + 1, xCoord, yCell, yCoord) < currDistance) {
				xCell++;
			} else if (gameMap.validMove(xCell - 1, yCell)
					&& getDistance(xCell - 1, xCoord, yCell, yCoord) < currDistance) {
				xCell--;
			} else if (gameMap.validMove(xCell, yCell + 1)
					&& getDistance(xCell, xCoord, yCell + 1, yCoord) < currDistance) {
				yCell++;
			} else if (gameMap.validMove(xCell, yCell - 1)
					&& getDistance(xCell, xCoord, yCell - 1, yCoord) < currDistance) {
				yCell--;
			}
		}
	}

	public int getDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public Point getEnemyLocation() {
		return new Point(xCell, yCell);
	}
}
