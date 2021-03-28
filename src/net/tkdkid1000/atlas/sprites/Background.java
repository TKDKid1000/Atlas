package net.tkdkid1000.atlas.sprites;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import net.tkdkid1000.atlas.Direction;
import net.tkdkid1000.atlas.Sprite;

public class Background extends Sprite {

	public Background(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr,
			Direction dir, double health, double damage) {
		super(layer, image, x, y, r, dx, dy, dr, dir, health, damage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkRemovability() {
		
	}
}
