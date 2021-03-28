package net.tkdkid1000.atlas.sprites;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import net.tkdkid1000.atlas.Direction;

public class Bush extends MapSprite {

	public Bush(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, Direction dir,
			double health, double damage) {
		super(layer, image, x, y, r, dx, dy, dr, dir, health, damage);
	}
}
