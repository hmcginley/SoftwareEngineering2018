package hw4;

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

public class OceanExplorer extends Application {
	final int cellSize = 20;
	final int oceanSize = 12;

	Scene scene;
	Image shipImage, pirateShipOneImage, pirateShipTwoImage;
	ImageView shipImageView, pirateShipOneImageView, pirateShipTwoImageView;

	OceanMap oceanMap;
	Ship ship;
	PirateShip pirateShipOne, pirateShipTwo;
	AnchorPane root;

	@Override
	public void start(Stage oceanStage) throws Exception {
		OceanMap oceanMap = new OceanMap();
		ship = new Ship(1, 1, cellSize, oceanMap);
		pirateShipOne = new PirateShip(5, 5, cellSize, oceanMap);
		pirateShipTwo = new PirateShip(20, 20, cellSize, oceanMap);
		ship.addObserver(pirateShipOne);
		ship.addObserver(pirateShipTwo);

		// Add maze lines, seeker, and images to view
		root = new AnchorPane();
		ObservableList<Node> rootList = root.getChildren(); // drawOceanMap expects an observableList<Node>
		oceanMap.drawOceanMap(rootList, cellSize); // cellSize scale for the map
		loadImages();

		// Setup
		scene = new Scene(root, oceanSize * cellSize + cellSize * 2, oceanSize * cellSize + cellSize * 2);
		oceanStage.setTitle("Ocean Blue");
		oceanStage.setScene(scene);
		oceanStage.show();

		// Start play
		startSailing(oceanStage);
	}

	private void startSailing(Stage oceanStage) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * cellSize);
				shipImageView.setY(ship.getShipLocation().y * cellSize);
				pirateShipOneImageView.setX(pirateShipOne.getShipLocation().x * cellSize);
				pirateShipOneImageView.setY(pirateShipOne.getShipLocation().y * cellSize);
				pirateShipTwoImageView.setX(pirateShipTwo.getShipLocation().x * cellSize);
				pirateShipTwoImageView.setY(pirateShipTwo.getShipLocation().y * cellSize);
			}
		});
		if (ship.getShipLocation().equals(pirateShipOne.getShipLocation()) == true
				|| ship.getShipLocation().equals(pirateShipTwo.getShipLocation()) == true) {
			oceanStage.close();
		}
	}

	private void loadImages() {
		// Load CC's ship
		shipImage = new Image("hw4\\images\\ColumbusShip.png", cellSize, cellSize, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * cellSize);
		shipImageView.setY(ship.getShipLocation().y * cellSize);
		root.getChildren().add(shipImageView);

		// Load pirate ships
		pirateShipOneImage = new Image("hw4\\images\\pirateship.gif", cellSize, cellSize, true, true);
		pirateShipOneImageView = new ImageView(pirateShipOneImage);
		pirateShipOneImageView.setX(pirateShipOne.getShipLocation().x * cellSize);
		pirateShipOneImageView.setY(pirateShipOne.getShipLocation().y * cellSize);
		root.getChildren().add(pirateShipOneImageView);

		pirateShipTwoImage = new Image("hw4\\images\\pirateship.gif", cellSize, cellSize, true, true);
		pirateShipTwoImageView = new ImageView(pirateShipTwoImage);
		pirateShipTwoImageView.setX(pirateShipTwo.getShipLocation().x * cellSize);
		pirateShipTwoImageView.setY(pirateShipTwo.getShipLocation().y * cellSize);
		root.getChildren().add(pirateShipTwoImageView);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
