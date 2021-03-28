package net.tkdkid1000.atlas.sprites;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import net.tkdkid1000.atlas.App;
import net.tkdkid1000.atlas.Direction;
import net.tkdkid1000.atlas.Input;
import net.tkdkid1000.atlas.Sprite;
import net.tkdkid1000.atlas.items.Inventory;

public class Player extends Sprite {

	private int speed;
	private double food;
	private Inventory inv;
	private boolean tooldelay;
	
	public Player(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, Direction dir, double health,
			double damage, int speed, double food) {
		super(layer, image, x, y, r, dx, dy, dr, dir, health, damage);
//		cancelexit();
		this.speed = speed;
		this.food = food;
		this.inv = new Inventory();
		this.tooldelay = false;
	}
	
 
	
	@Override
	public void move() {
		
	}
	
	public void handleInput() {
		handlemovement();
		handleitems();
	}
	
	public void handleitems() {
		App.getInstance().weapon.setText(inv.getHeld().getId() + " " + inv.getHeld().getUses());
		if (Input.keys.contains(KeyCode.SPACE)) {
			if (!tooldelay) {
				getInventory().getHeld().use(this);
				tooldelay = true;
				new Timeline(new KeyFrame(Duration.millis(500), event -> tooldelay = false)).play();
			}
		}
	}
	
	public void handlemovement() {
		App.getInstance().text.setText(super.getDirection()+"");
		if (Input.keys.contains(KeyCode.W)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setY(sprite.getY()+speed);
					super.setImage(new Image("/images/player/up.png"));
					super.setDirection(Direction.UP);
					if (sprite instanceof Block && this.collidesWith(sprite)) {
						App.getInstance().sprites.forEach((block) -> {
							block.setY(block.getY()-speed);
						});
					}
				}
			});
		} else if (Input.keys.contains(KeyCode.S)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setY(sprite.getY()-speed);
					super.setImage(new Image("/images/player/down.png"));
					super.setDirection(Direction.DOWN);
					if (sprite instanceof Block && this.collidesWith(sprite)) {
						App.getInstance().sprites.forEach((block) -> {
							block.setY(block.getY()+speed);
						});
					}
				}
			});
		} else if (Input.keys.contains(KeyCode.A)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setX(sprite.getX()+speed);
					super.setImage(new Image("/images/player/left.png"));
					super.setDirection(Direction.LEFT);
					if (sprite instanceof Block && this.collidesWith(sprite)) {
						App.getInstance().sprites.forEach((block) -> {
							block.setX(block.getX()-speed);
						});
					}
				}
			});
		} else if (Input.keys.contains(KeyCode.D)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setX(sprite.getX()-speed);
					super.setImage(new Image("/images/player/right.png"));
					super.setDirection(Direction.RIGHT);
					if (sprite instanceof Block && this.collidesWith(sprite)) {
						App.getInstance().sprites.forEach((block) -> {
							block.setX(block.getX()+speed);
						});
					}
				}
			});
		}
	}
	
	@Override
	public void checkRemovability() {
		
	}
	
	public Inventory getInventory() {
		return inv;
	}
	
	public void setInventory(Inventory inv) {
		this.inv = inv;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getFood() {
		return food;
	}
	
	public void setFood(double food) {
		this.food = food;
	}
}
