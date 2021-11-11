package menu;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Utils {
	private Utils() {
		
	}
	public static List<FoodDrink> getList(){
		ImageIcon icon1 = new ImageIcon("bohuc.jpg");
		ImageIcon icon2 = new ImageIcon("nuocyen.jpg");
		ImageIcon icon3 = new ImageIcon("stingdau.jpg");
		ImageIcon icon4 = new ImageIcon("stingvang.jpg");
		ImageIcon icon5 = new ImageIcon("cocacola.jpg");
		ImageIcon icon6 = new ImageIcon("pepsi.jpg");
		Image img1 = icon1.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img2 = icon2.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img3 = icon3.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img4 = icon4.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img5 = icon5.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img6 = icon6.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		icon1 = new ImageIcon(img1);
		icon2 = new ImageIcon(img2);
		icon3 = new ImageIcon(img3);
		icon4 = new ImageIcon(img4);
		icon5 = new ImageIcon(img5);
		icon6 = new ImageIcon(img6);
		FoodDrink fd1 = new FoodDrink(icon1, "Bò Húc", "15000VND", new JButton("Chọn"));
		FoodDrink fd2 = new FoodDrink(icon2, "Nước Yến", "15000VND", new JButton("Chọn"));
		FoodDrink fd3 = new FoodDrink(icon3, "Sting Dâu", "15000VND", new JButton("Chọn"));
		FoodDrink fd4 = new FoodDrink(icon4, "Sting Vàng", "15000VND", new JButton("Chọn"));
		FoodDrink fd5 = new FoodDrink(icon5, "CocaCola", "15000VND", new JButton("Chọn"));
		FoodDrink fd6 = new FoodDrink(icon6, "Pepsi", "15000VND", new JButton("Chọn"));
		List<FoodDrink> lists = new ArrayList<>();
		lists.add(fd1);
		lists.add(fd2);
		lists.add(fd3);
		lists.add(fd4);
		lists.add(fd5);
		lists.add(fd6);
		return lists;
		
	}
}
