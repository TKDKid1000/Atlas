package net.tkdkid1000.atlas.items;

import java.util.HashMap;
import java.util.Map;

import net.tkdkid1000.atlas.items.tools.Fist;

public class Inventory {

	private Map<Item, Integer> items;
	private Item held;
	
	public Inventory() {
		this.items = new HashMap<Item, Integer>();
		this.held = new Fist();
	}
	
	public Item getHeld() {
		return this.held;
	}
	
	public Inventory setHeld(Item item) {
		addItem(getHeld(), 1);
		this.held = item;
		return this;
	}
	
	public Inventory setHeldFromInventory(Item item) {
		setHeld(item);
		removeItem(item);
		return this;
	}
	
	public Map<Item, Integer> getItems() {
		return items;
	}
	
	public Inventory setItems(Map<Item, Integer> items) {
		this.items = items;
		return this;
	}
	
	public Inventory addItem(Item item, int count) {
		this.items.put(item, count);
		return this;
	}
	
	public Inventory removeItem(Item item) {
		this.items.remove(item);
		return this;
	}
	
	public Inventory clear() {
		this.items.clear();
		this.held = new Fist();
		return this;
	}
}
