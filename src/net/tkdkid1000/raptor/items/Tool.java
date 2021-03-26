package net.tkdkid1000.raptor.items;

public enum Tool {

	NONE("none", 0.0),
	WOODSWORD("woodensword", 5.0);

	private String id;
	private double damage;

	Tool(String id, double damage) {
		this.id = id;
		this.damage = damage;
	}
	
	public String getId() {
		return id;
	}
	
	public double getDamage() {
		return damage;
	}
}
