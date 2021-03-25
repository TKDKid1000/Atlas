package net.tkdkid1000.raptor;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Input {

	private Scene scene;
	public static List<String> keys = new ArrayList<String>();
	
	public Input(Scene scene) {
		this.scene = scene;
		register();
	}
	
	public void register() {
		scene.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (!keys.contains(event.getCharacter())) {
					keys.add(event.getCharacter());					
				}
			}
			
		});
	}
	
}
