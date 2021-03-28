package net.tkdkid1000.atlas.items.tools;

import net.tkdkid1000.atlas.App;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.util.Duration;
import net.tkdkid1000.atlas.items.Tool;
import net.tkdkid1000.atlas.sprites.Bush;
import net.tkdkid1000.atlas.sprites.Player;

public class Fist extends Tool {

	public Fist() {
		super("fist", 1, "/fist.png", 0.0);
	}

	@Override
	public void use(Player player) {
		App.getInstance().sprites.forEach(sprite -> {
			if (player.collidesWith(sprite)) {
				if (sprite instanceof Bush) {
					player.getInventory().addItem(null, uses);
				}
			}
		});
//		new Timeline(new KeyFrame(Duration.millis(50), event -> player.setX(player.getX()+10))).play();
//		new Timeline(new KeyFrame(Duration.millis(100), event -> player.setX(player.getX()-10))).play();
//		new Timeline(new KeyFrame(Duration.millis(150), event -> player.setX(player.getX()-10))).play();
//		new Timeline(new KeyFrame(Duration.millis(200), event -> player.setX(player.getX()+10))).play();
	}
}
