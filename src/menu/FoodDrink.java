package menu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FoodDrink {
	private ImageIcon image;
	private String name;
	private String price;
	private JButton button;
	
	public FoodDrink(ImageIcon image, String name, String price, JButton button) {
		this.image = image;
		this.name = name;
		this.price = price;
		this.button = button;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "FoodDrink [image=" + image + ", name=" + name + ", price=" + price + ", button=" + button + "]";
	}
	
}
