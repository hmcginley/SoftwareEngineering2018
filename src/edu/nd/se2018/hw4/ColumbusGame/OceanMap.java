package hw4;

import java.util.ArrayList;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	private ArrayList<Line> lines = new ArrayList<Line>();

	int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;

	public void drawOceanMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = 0;
			}
		}
		createIslands(root, scale);
	}

	public boolean validMove(int x, int y) {
		if (x > 24 || x < 0 || y > 24 || y < 0) {
			return false;
		}
		if (oceanGrid[x][y] != 0) {
			return false;
		}

		return true;
	}

	public void createIslands(ObservableList<Node> root, int scale) {
		int islands = 0;
		Random random = new Random();
		while (islands < 10) {
			int xPos = random.nextInt(24) + 1;
			int yPos = random.nextInt(24) + 1;
			if (oceanGrid[xPos][yPos] == 0) {
				Rectangle rect = new Rectangle(xPos * scale, yPos * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREEN);
				root.add(rect);
				oceanGrid[xPos][yPos] = 1;
				islands++;
			}
		}
	}
}
