package net.tkdkid1000.atlas.sprites;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import net.tkdkid1000.atlas.Direction;

public class Block extends MapSprite {

	public Block(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr,
			Direction direction, double health, double damage) {
		super(layer, image, x, y, r, dx, dy, dr, direction, health, damage);
	}

	@Override
	public void checkRemovability() {
		if (this.health == 0) {
			super.remove();
		}
	}
}
