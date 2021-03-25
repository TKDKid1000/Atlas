package net.tkdkid1000.scrollergame.sprites;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import net.tkdkid1000.scrollergame.App;
import net.tkdkid1000.scrollergame.Input;
import net.tkdkid1000.scrollergame.Sprite;
import net.tkdkid1000.scrollergame.util.Settings;

public class Player extends Sprite {

	private int speed;

	public Player(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, double health,
			double damage, int speed) {
		super(layer, image, x, y, r, dx, dy, dr, health, damage);
//		cancelexit();
		this.speed = speed;
	}
	
 
	
	@Override
	public void move() {
		App.getInstance().backdropLayer.getChildren().forEach((node) -> {
			if (node.getBoundsInParent().contains(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2) && ((Rectangle)node).getFill() == Settings.WALL_COLOR) {
				
			}
		});
	}
	
	public void handleInput() {
		if (Input.keys.contains("w")) {
			App.getInstance().backdropLayer.getChildren().forEach((node) -> {
				node.setLayoutY(node.getLayoutY()+Settings.PLATFORM_SIZE);

				if (node.getBoundsInParent().contains(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2) && ((Rectangle)node).getFill() == Settings.WALL_COLOR) {
					System.out.println(node.getBoundsInParent().getCenterX());
					App.getInstance().backdropLayer.getChildren().forEach((block) -> {
						block.setLayoutY(block.getLayoutY()-Settings.PLATFORM_SIZE);
					});
				}
			});
			Input.keys.clear();
		} else if (Input.keys.contains("s")) {
			App.getInstance().backdropLayer.getChildren().forEach((node) -> {
				node.setLayoutY(node.getLayoutY()-Settings.PLATFORM_SIZE);
				if (node.getBoundsInParent().contains(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2) && ((Rectangle)node).getFill() == Settings.WALL_COLOR) {
					App.getInstance().backdropLayer.getChildren().forEach((block) -> {
						block.setLayoutY(block.getLayoutY()+Settings.PLATFORM_SIZE);
					});
				}
			});
			Input.keys.clear();
		} else if (Input.keys.contains("a")) {
			App.getInstance().backdropLayer.getChildren().forEach((node) -> {
				node.setLayoutX(node.getLayoutX()+Settings.PLATFORM_SIZE);
				if (node.getBoundsInParent().contains(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2) && ((Rectangle)node).getFill() == Settings.WALL_COLOR) {
					
					App.getInstance().backdropLayer.getChildren().forEach((block) -> {
						block.setLayoutX(block.getLayoutX()-Settings.PLATFORM_SIZE);
					});
				}
			});
			Input.keys.clear();
		} else if (Input.keys.contains("d")) {
			App.getInstance().backdropLayer.getChildren().forEach((node) -> {
				node.setLayoutX(node.getLayoutX()-Settings.PLATFORM_SIZE);
				if (node.getBoundsInParent().contains(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2) && ((Rectangle)node).getFill() == Settings.WALL_COLOR) {
					
					App.getInstance().backdropLayer.getChildren().forEach((block) -> {
						block.setLayoutX(block.getLayoutX()+Settings.PLATFORM_SIZE);
					});
				}
			});
			Input.keys.clear();
		}
	}
	
	@Override
	public void checkRemovability() {
		
	}

}
