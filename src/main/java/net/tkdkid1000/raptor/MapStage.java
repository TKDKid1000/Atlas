package net.tkdkid1000.raptor;

import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class MapStage {

	private char[][] map;
	private double size;
	private Pane layer;
	private Map<Character, Paint> colors;

	public MapStage(Pane layer, char[][] map, double size, Map<Character, Paint> colors) {
		this.map = map;
		this.size = size;
		this.layer = layer;
		this.colors = colors;
		load();
	}
	
	private void load() {
		for (int x=0; x<map.length; x++) {
			for (int z=0; z<map[x].length; z++) {
				Rectangle rect = new Rectangle(z*size, x*size, z+1*size, x+1*size);
				rect.setFill(colors.get(map[x][z]));
				layer.getChildren().add(rect);
			}
		}
	}
}
