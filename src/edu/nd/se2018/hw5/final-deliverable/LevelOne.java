package hw6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelOne implements GameMap {
	final int dimensions = 25;
	int[][] gameGrid = new int[dimensions][dimensions];
	Image PortalImage, TileImage, RedKeyImage, GreenKeyImage, RedKeyWallImage, GreenKeyWallImage;
	ImageView PortalImageView, TileImageView, RedKeyImageView, GreenKeyImageView, RedKeyWallImageView,
			GreenKeyWallImageView;
	ObservableList<Node> root;

	@Override
	public void drawGameMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				TileImage = new Image("hw6\\images\\BlankTile.png", scale, scale, true, true);
				TileImageView = new ImageView(TileImage);
				TileImageView.setX(x * scale);
				TileImageView.setY(y * scale);
				root.add(TileImageView);
				gameGrid[x][y] = 2;
			}
		}
		createOuterWalls(root, scale);
		createLevelWalls(root, scale);
		createLevelKeys(root, scale);
		createSpecialWalls(root, scale);
	}

	@Override
	public boolean validMove(int x, int y) {
		if (x > 24 || x < 0 || y > 24 || y < 0) {
			return false;
		}
		if (gameGrid[x][y] <= 1) {
			return false;
		}

		return true;
	}

	@Override
	// Draw walls of the given level
	public void createLevelWalls(ObservableList<Node> root, int scale) {
		int y = 0, x = 0;

		for (y = 3; y <= 10; y++) {
			for (x = 12; x <= 13; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 10; y <= 20; y++) {
			for (x = 4; x <= 5; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 18; y <= 22; y++) {
			for (x = 2; x <= 3; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 18; y <= 21; y++) {
			for (x = 8; x <= 11; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 15; y <= 21; y++) {
			for (x = 16; x <= 21; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 3; y <= 6; y++) {
			for (x = 19; x <= 21; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 4; y <= 5; y++) {
			for (x = 8; x <= 9; x += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		x = 7;
		for (y = 3; y <= 8; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 13;
		for (y = 15; y <= 22; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 9;
		for (y = 9; y <= 16; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 1;
		for (y = 12; y <= 16; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 18;
		for (y = 3; y <= 9; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 8;
		for (x = 7; x <= 15; x += 1) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 3;
		for (x = 4; x <= 9; x += 1) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 13;
		for (x = 13; x <= 17; x += 1) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 9;
		for (x = 18; x <= 24; x += 1) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 1;
		for (x = 0; x <= 24; x += 1) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 23;
		for (y = 4; y <= 6; y += 2) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}
	}

	@Override
	public void createOuterWalls(ObservableList<Node> root, int scale) {
		int y = 0, x = 0;

		for (x = 0; x <= 24; x++) {
			for (y = 0; y <= 24; y += 24) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (y = 0; y <= 24; y++) {
			for (x = 0; x <= 24; x += 24) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}
	}

	@Override
	public void createLevelKeys(ObservableList<Node> root, int scale) {
		gameGrid[3][4] = 3;
		gameGrid[13][14] = 4;
		RedKeyImage = new Image("hw6\\images\\redKey.png", scale, scale, true, true);
		RedKeyImageView = new ImageView(RedKeyImage);
		RedKeyImageView.setX(3 * scale);
		RedKeyImageView.setY(4 * scale);
		GreenKeyImage = new Image("hw6\\images\\greenKey.png", scale, scale, true, true);
		GreenKeyImageView = new ImageView(GreenKeyImage);
		GreenKeyImageView.setX(13 * scale);
		GreenKeyImageView.setY(14 * scale);
		PortalImage = new Image("hw6\\images\\portal.png", scale, scale, true, true);
		PortalImageView = new ImageView(PortalImage);
		PortalImageView.setX(19 * scale);
		PortalImageView.setY(8 * scale);
		root.add(RedKeyImageView);
		root.add(GreenKeyImageView);
		root.add(PortalImageView);
	}

	@Override
	public void createSpecialWalls(ObservableList<Node> root, int scale) {
		gameGrid[22][4] = -1;
		gameGrid[22][6] = -2;
		RedKeyWallImage = new Image("hw6\\images\\redKeyWall.png", scale, scale, true, true);
		RedKeyWallImageView = new ImageView(RedKeyWallImage);
		RedKeyWallImageView.setX(22 * scale);
		RedKeyWallImageView.setY(4 * scale);
		GreenKeyWallImage = new Image("hw6\\images\\greenKeyWall.png", scale, scale, true, true);
		GreenKeyWallImageView = new ImageView(GreenKeyWallImage);
		GreenKeyWallImageView.setX(22 * scale);
		GreenKeyWallImageView.setY(6 * scale);
		root.add(RedKeyWallImageView);
		root.add(GreenKeyWallImageView);
	}

	@Override
	public int getSquareValue(int x, int y) {
		return gameGrid[x][y];
	}

	@Override
	public void removeLevelObject(int x, int y, int scale) {
		gameGrid[x][y] = 2;
		TileImage = new Image("hw6\\images\\BlankTile.png", scale, scale, true, true);
		TileImageView = new ImageView(TileImage);
		TileImageView.setX(x * scale);
		TileImageView.setY(y * scale);
		// root.add(RedKeyImageView);
	}
}
