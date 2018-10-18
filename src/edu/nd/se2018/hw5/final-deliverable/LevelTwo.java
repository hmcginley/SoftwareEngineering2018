package hw6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelTwo implements GameMap {
	final int dimensions = 25;
	int[][] gameGrid = new int[dimensions][dimensions];
	Image PortalImage, TileImage, RedKeyImage, GreenKeyImage, RedKeyWallImage, GreenKeyWallImage;
	ImageView PortalImageView, TileImageView, RedKeyImageView, GreenKeyImageView, RedKeyWallImageView,
			GreenKeyWallImageView;

	@Override
	public void drawGameMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.LIGHTGREY);
				root.add(rect);
				gameGrid[x][y] = 2;
			}
		}
		createOuterWalls(root, scale);
		createLevelWalls(root, scale);
		createLevelKeys(root, scale);
		createSpecialWalls(root, scale);
	}

	@Override
	public void createLevelWalls(ObservableList<Node> root, int scale) {
		int y = 0, x = 0;

		x = 3;
		for (y = 1; y <= 3; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 3;
		for (x = 1; x <= 1; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 6;
		for (y = 19; y <= 24; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 19;
		for (x = 1; x <= 6; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 22;
		for (x = 1; x <= 6; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		x = 13;
		for (y = 2; y <= 22; y++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 14;
		for (x = 13; x <= 22; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 4;
		for (x = 13; x <= 22; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		y = 20;
		for (x = 15; x <= 23; x++) {
			gameGrid[x][y] = 1;
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREY);
			root.add(rect);
		}

		for (x = 1; x <= 6; x++) {
			for (y = 6; y <= 16; y += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}

		for (x = 16; x <= 23; x++) {
			for (y = 7; y <= 11; y += 1) {
				gameGrid[x][y] = 1;
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
			}
		}
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
		gameGrid[23][23] = 3;
		gameGrid[23][4] = 4;
		RedKeyImage = new Image("hw6\\images\\redKey.png", scale, scale, true, true);
		RedKeyImageView = new ImageView(RedKeyImage);
		RedKeyImageView.setX(23 * scale);
		RedKeyImageView.setY(23 * scale);
		GreenKeyImage = new Image("hw6\\images\\greenKey.png", scale, scale, true, true);
		GreenKeyImageView = new ImageView(GreenKeyImage);
		GreenKeyImageView.setX(15 * scale);
		GreenKeyImageView.setY(5 * scale);
		PortalImage = new Image("hw6\\images\\portal.png", scale, scale, true, true);
		PortalImageView = new ImageView(PortalImage);
		PortalImageView.setX(5 * scale);
		PortalImageView.setY(20 * scale);
		root.add(RedKeyImageView);
		root.add(GreenKeyImageView);
		root.add(PortalImageView);
	}

	@Override
	public void createSpecialWalls(ObservableList<Node> root, int scale) {
		gameGrid[1][22] = -1;
		gameGrid[6][23] = -2;
		RedKeyWallImage = new Image("hw6\\images\\redKeyWall.png", scale, scale, true, true);
		RedKeyWallImageView = new ImageView(RedKeyWallImage);
		RedKeyWallImageView.setX(1 * scale);
		RedKeyWallImageView.setY(22 * scale);
		GreenKeyWallImage = new Image("hw6\\images\\greenKeyWall.png", scale, scale, true, true);
		GreenKeyWallImageView = new ImageView(GreenKeyWallImage);
		GreenKeyWallImageView.setX(6 * scale);
		GreenKeyWallImageView.setY(23 * scale);
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
	}

}
