package net.tkdkid1000.raptor.util;

import javafx.animation.AnimationTimer;
import net.tkdkid1000.raptor.App;
import net.tkdkid1000.raptor.sprites.Player;

public class GameLoop extends AnimationTimer {

	int playermovetimer = 0;
	
	@Override
	public void handle(long now) {
		playermovetimer++;
		App.getInstance().sprites.forEach((sprite) -> {
			sprite.updateUI();
			sprite.checkRemovability();
			if (sprite instanceof Player) {
				Player player = (Player) sprite;
				if (playermovetimer == 20) {
					player.handleInput();
					playermovetimer = 0;
				}
			} else {
				sprite.move();
			}
		});
	}

}
