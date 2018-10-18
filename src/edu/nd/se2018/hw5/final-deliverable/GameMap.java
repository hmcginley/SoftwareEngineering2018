package hw6;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface GameMap {
	final int dimensions = 25;
	int[][] gameGrid = new int[dimensions][dimensions];

	public void drawGameMap(ObservableList<Node> root, int scale);

	public boolean validMove(int x, int y);

	// Draw walls along the outer bounds of map
	public void createOuterWalls(ObservableList<Node> root, int scale);

	// Draw walls of the given level
	public void createLevelWalls(ObservableList<Node> root, int scale);

	// Draw special keys of the given level
	public void createLevelKeys(ObservableList<Node> root, int scale);

	// Draw special walls of the given level
	public void createSpecialWalls(ObservableList<Node> root, int scale);

	// Remove special keys/walls of the given level
	public void removeLevelObject(int x, int y, int scale);

	// Draw special keys of the given level
	public int getSquareValue(int x, int y);
}
