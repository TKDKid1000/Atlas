package net.tkdkid1000.scrollergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import net.tkdkid1000.scrollergame.sprites.Player;
import net.tkdkid1000.scrollergame.util.GameLoop;
import net.tkdkid1000.scrollergame.util.Settings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class App extends Application {
	
	private static App instance;
	public Pane playfieldLayer;
	public Pane backdropLayer;
	Scene scene;
	
	public List<Sprite> sprites = new ArrayList<Sprite>();
	Text text;
	
	public static App getInstance() {
		return instance;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		instance = this;
		Group root = new Group();
		playfieldLayer = new Pane();
		backdropLayer = new Pane();
		root.getChildren().add(backdropLayer);
		root.getChildren().add(playfieldLayer);
		Settings.reload();
		scene = new Scene(root, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
		stage.getIcons().add(new Image("file:steve.png"));
		stage.setTitle("Scroller Game");
		stage.setScene(scene);
		stage.show();
		text = new Text();
		Player player = new Player(playfieldLayer, new Image("file:steve.png"), (Settings.GAME_WIDTH/2)+25, (Settings.GAME_HEIGHT/2)+25, 0, 0, 0, 0, 20, 20, 5);
		sprites.add(player);
		AnimationTimer gameloop = new GameLoop();
		gameloop.start();
		new Input(scene);
		addText();
		Map<Character, Paint> colors = new HashMap<Character, Paint>();
		colors.put(' ', Color.GREEN);
		colors.put('c', Color.ALICEBLUE);
		colors.put('g', Color.RED);
		colors.put('w', Settings.WALL_COLOR);
		colors.put('b', Settings.PLATFORM_COLOR);
		new MapStage(backdropLayer, new char[][] {
			{' ', 'c', ' ', 'c', 'c', ' ', 'c', ' ', 'c'},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', 'w', ' ', ' ', ' ', ' ', 'b', ' ', ' ', ' ', ' ', 'b', ' ', ' ', ' ', ' '},
			{' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b', 'b', ' ', ' ', 'b', ' ', 'w', ' ', ' ', 'b', ' '},
			{'b', 'w', 'b', 'w', ' ', 'b', 'b', 'b', 'b', 'w', ' ', 'b', 'b', 'b', 'b', ' ', 'b', ' '},
			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'w', 'b', 'b', 'b', 'b', 'g', 'g'},
			{'b', 'b', 'w', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
		}, Settings.PLATFORM_SIZE, colors);
	}
	
	public void addText() {
		text.setFont(Font.font( null, FontWeight.BOLD, 64));
		text.setStroke(Color.BLACK);
		text.setFill(Color.RED);
		backdropLayer.getChildren().add(text);
		double x = (Settings.GAME_WIDTH - text.getBoundsInLocal().getWidth()) / 2;
		double y = (Settings.GAME_HEIGHT - text.getBoundsInLocal().getHeight()) / 2;
		text.relocate(x, y);
		text.setText("");
		text.setBoundsType(TextBoundsType.VISUAL);
	}

}
