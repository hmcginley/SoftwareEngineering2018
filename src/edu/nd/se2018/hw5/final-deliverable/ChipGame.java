package hw6;

import java.awt.Point;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChipGame extends Application {
	final int cellSize = 20;
	final int mapSize = 12;
	boolean changedLevel = false;

	Scene scene;
	Image ChipImageRight, ChipImageLeft, ChipImageUp, ChipImageDown, BugImage;
	ImageView ChipImageView, BugImageView; // , pirateChipOneImageView, pirateChipTwoImageView;

	LevelOne levelOne;
	LevelTwo levelTwo;

	Chip chip;
	Enemy bug;
	AnchorPane root;
	Point levelOneComplete = new Point(19, 8);

	@Override
	public void start(Stage mapStage) throws Exception {
		LevelOne levelOne = new LevelOne();
		chip = new Chip(8, 7, cellSize, levelOne);

		// Add maze lines, seeker, and images to view
		root = new AnchorPane();
		ObservableList<Node> rootList = root.getChildren(); // drawlevelOne expects an observableList<Node>
		levelOne.drawGameMap(rootList, cellSize); // cellSize scale for the map
		loadImages();

		// Setup
		scene = new Scene(root, mapSize * cellSize + cellSize * 2, mapSize * cellSize + cellSize * 2);
		mapStage.setTitle("Chip's Challenge!");
		mapStage.setScene(scene);
		mapStage.show();

		// Start playing
		startPlaying(mapStage);
	}

	private void startPlaying(Stage mapStage) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
					case RIGHT:
						chip.goEast();
					ChipImageRight = new Image("hw6\\images\\chipRight.png", cellSize, cellSize, true, true);
					ChipImageView.setImage(ChipImageRight);
						break;
					case LEFT:
						chip.goWest();
					ChipImageLeft = new Image("hw6\\images\\chipLeft.png", cellSize, cellSize, true, true);
					ChipImageView.setImage(ChipImageLeft);
						break;
					case UP:
						chip.goNorth();
					ChipImageUp = new Image("hw6\\images\\chipUp.png", cellSize, cellSize, true, true);
					ChipImageView.setImage(ChipImageUp);
						break;
					case DOWN:
						chip.goSouth();
					ChipImageDown = new Image("hw6\\images\\chipDown.png", cellSize, cellSize, true, true);
					ChipImageView.setImage(ChipImageDown);
						break;
				case ESCAPE:
					mapStage.close();
					break;
					default:
						break;
				}

				// Change level
				if (chip.getChipLocation().equals(levelOneComplete)) {
					changedLevel = true;
					chip.setChipLocation(1, 1);
					levelTwo = new LevelTwo();
					chip.updateLevel(levelTwo);
					root = new AnchorPane();
					ObservableList<Node> rootList = root.getChildren();
					bug = new Enemy(10, 6, cellSize, levelTwo);
					chip.addObserver(bug);
					levelTwo.drawGameMap(rootList, cellSize); // cellSize scale for the map
					loadLevelTwoImages();

					// Setup
					scene = new Scene(root, mapSize * cellSize + cellSize * 2, mapSize * cellSize + cellSize * 2);
					mapStage.setScene(scene);
					startPlaying(mapStage);
				}

				ChipImageView.setX(chip.getChipLocation().x * cellSize);
				ChipImageView.setY(chip.getChipLocation().y * cellSize);

				if (changedLevel) {
					BugImageView.setX(bug.getEnemyLocation().x * cellSize);
					BugImageView.setY(bug.getEnemyLocation().y * cellSize);
				}
			}
		});
	}

	private void loadImages() {
		// Load Chip
		ChipImageRight = new Image("hw6\\images\\chipRight.png", cellSize, cellSize, true, true);
		ChipImageView = new ImageView(ChipImageRight);
		ChipImageView.setX(chip.getChipLocation().x * cellSize);
		ChipImageView.setY(chip.getChipLocation().y * cellSize);
		root.getChildren().add(ChipImageView);
	}

	public void loadLevelTwoImages() {
		// Load Chip
		ChipImageRight = new Image("hw6\\images\\chipRight.png", cellSize, cellSize, true, true);
		ChipImageView = new ImageView(ChipImageRight);
		ChipImageView.setX(chip.getChipLocation().x * cellSize);
		ChipImageView.setY(chip.getChipLocation().y * cellSize);
		root.getChildren().add(ChipImageView);

		// Load bug
		BugImage = new Image("hw6\\images\\bugUp.png", cellSize, cellSize, true, true);
		BugImageView = new ImageView(BugImage);
		BugImageView.setX(bug.getEnemyLocation().x * cellSize);
		BugImageView.setY(bug.getEnemyLocation().y * cellSize);
		root.getChildren().add(BugImageView);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
