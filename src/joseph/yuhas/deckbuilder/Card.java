package joseph.yuhas.deckbuilder;

import org.json.JSONObject;

public class Card {
	private String name;
	private String text;
	private String imageURL;
	private String type;
	private int power;
	private int toughness;
	
	Card() {
		setName(null);
		setText(null);
		setImageURL(null);
		setPower(0);
		setToughness(0);
		setType(null);
	}
	
	public void populateFromJSON(JSONObject jObj) {
		
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getToughness() {
		return toughness;
	}
	public void setToughness(int toughness) {
		this.toughness = toughness;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
