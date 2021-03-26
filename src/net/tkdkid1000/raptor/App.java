package net.tkdkid1000.raptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import net.tkdkid1000.raptor.sprites.Background;
import net.tkdkid1000.raptor.sprites.MapSprite;
import net.tkdkid1000.raptor.sprites.Player;
import net.tkdkid1000.raptor.util.GameLoop;
import net.tkdkid1000.raptor.util.Settings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	public Text text;
	public Text weapon;
	
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
		stage.setResizable(false);
		stage.show();
		text = new Text();
		weapon = new Text();
		Background bg = new Background(backdropLayer, new Image("file:bg.png", 9000, 9000, true, true), 0, 0, 0, 0, 0, 0, 0, 0) {

			@Override
			public void checkRemovability() {
				
			}
			
		};
		App.getInstance().sprites.add(bg);
		AnimationTimer gameloop = new GameLoop();
		gameloop.start();
		new Input(scene);
		addText();
		jsonmap();
//		Map<Character, Paint> colors = new HashMap<Character, Paint>();
//		colors.put(' ', Color.GREEN);
//		colors.put('c', Color.ALICEBLUE);
//		colors.put('g', Color.RED);
//		colors.put('w', Settings.WALL_COLOR);
//		colors.put('b', Settings.PLATFORM_COLOR);
//		new MapStage(backdropLayer, new char[][] {
//			{' ', 'c', ' ', 'c', 'c', ' ', 'c', ' ', 'c'},
//			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//			{' ', ' ', ' ', 'w', ' ', ' ', ' ', ' ', 'b', ' ', ' ', ' ', ' ', 'b', ' ', ' ', ' ', ' '},
//			{' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b', 'b', ' ', ' ', 'b', ' ', 'w', ' ', ' ', 'b', ' '},
//			{'b', 'w', 'b', 'w', ' ', 'b', 'b', 'b', 'b', 'w', ' ', 'b', 'b', 'b', 'b', ' ', 'b', ' '},
//			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'w', 'b', 'b', 'b', 'b', 'g', 'g'},
//			{'b', 'b', 'w', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
//			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
//			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'g', 'g'},
//		}, Settings.PLATFORM_SIZE, colors);
		Player player = new Player(playfieldLayer, new Image("file:steve.png"), (Settings.GAME_WIDTH/2)+25, (Settings.GAME_HEIGHT/2)+25, 0, 0, 0, 0, 20, 20, 5);
		App.getInstance().sprites.add(player);
		
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
		// split
		weapon.setFont(Font.font( null, FontWeight.NORMAL, 48));
		weapon.setFill(Color.BLACK);
		backdropLayer.getChildren().add(weapon);
		x = Settings.GAME_WIDTH-200;
		y = 40;
		weapon.relocate(x, y);
		weapon.setText("");
		weapon.setBoundsType(TextBoundsType.VISUAL);
	}

	
	public void jsonmap() throws FileNotFoundException {
		Gson gson = new Gson();
		File f = new File("map.json");
		Scanner s = new Scanner(f);
		String data = "";
		while (s.hasNextLine()) {
			data = data + s.nextLine() + "\n";
		}
		s.close();
		String[][] map = gson.fromJson(data, String[][].class);
		int size = 86;
		for (int x=0; x<map.length; x++) {
			for (int y=0; y<map[x].length; y++) {
				Image image = new Image("file:images/objects/"+map[y][x], size, size, true, true);
				MapSprite piece = new MapSprite(playfieldLayer, image, y*size, x*size, 0, 0, 0, 0, 20, 0);
				App.getInstance().sprites.add(piece);
			}
		}
	}
}
