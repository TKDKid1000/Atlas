package net.tkdkid1000.atlas.sprites;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import net.tkdkid1000.atlas.Direction;
import net.tkdkid1000.atlas.Sprite;

public class MapSprite extends Sprite {

	public MapSprite(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr,
			Direction dir, double health, double damage) {
		super(layer, image, x, y, r, dx, dy, dr, dir, health, damage);
	}

	@Override
	public void checkRemovability() {
		if (health == 0) {
			super.remove();
		}
	}

}
