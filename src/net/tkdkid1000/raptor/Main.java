package net.tkdkid1000.raptor;

import javafx.application.Application;
import net.tkdkid1000.raptor.util.Settings;

public class Main {

	public static void main(String[] args) {
		Application.launch(App.class, args);
		Settings.reload();
	}
}
