package menu;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Utils {
	private Utils() {
		
	}
	public static List<FoodDrink> getListDrink(){
		ImageIcon icon1 = new ImageIcon("trasua.jpg");
		ImageIcon icon2 = new ImageIcon("nuocepduahau.jpg");
		ImageIcon icon3 = new ImageIcon("nuocepxoai.jpg");
		ImageIcon icon4 = new ImageIcon("stingvang.jpg");
		ImageIcon icon5 = new ImageIcon("cocacola.jpg");
		ImageIcon icon6 = new ImageIcon("pepsi.jpg");
		ImageIcon icon7 = new ImageIcon("bohuc.jpg");
		ImageIcon icon8 = new ImageIcon("nuocyen.jpg");
		ImageIcon icon9 = new ImageIcon("stingdau.jpg");
		Image img1 = icon1.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img2 = icon2.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img3 = icon3.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img4 = icon4.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img5 = icon5.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img6 = icon6.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img7 = icon7.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img8 = icon8.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img9 = icon9.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		icon1 = new ImageIcon(img1);
		icon2 = new ImageIcon(img2);
		icon3 = new ImageIcon(img3);
		icon4 = new ImageIcon(img4);
		icon5 = new ImageIcon(img5);
		icon6 = new ImageIcon(img6);
		icon7 = new ImageIcon(img7);
		icon8 = new ImageIcon(img8);
		icon9 = new ImageIcon(img9);
		FoodDrink fd1 = new FoodDrink(icon1, "Trà sữa", "25000VND", new JButton("Chọn"));
		FoodDrink fd2 = new FoodDrink(icon2, "Nước ép dưa hấu", "20000VND", new JButton("Chọn"));
		FoodDrink fd3 = new FoodDrink(icon3, "Nước ép xoài", "20000VND", new JButton("Chọn"));
		FoodDrink fd4 = new FoodDrink(icon4, "Sting Vàng", "10000VND", new JButton("Chọn"));
		FoodDrink fd5 = new FoodDrink(icon5, "CocaCola", "10000VND", new JButton("Chọn"));
		FoodDrink fd6 = new FoodDrink(icon6, "Pepsi", "10000VND", new JButton("Chọn"));
		FoodDrink fd7 = new FoodDrink(icon7, "Bò Húc", "15000VND", new JButton("Chọn"));
		FoodDrink fd8 = new FoodDrink(icon8, "Nước Yến", "10000VND", new JButton("Chọn"));
		FoodDrink fd9 = new FoodDrink(icon9, "Sting Dâu", "10000VND", new JButton("Chọn"));
		List<FoodDrink> lists = new ArrayList<>();
		lists.add(fd1);
		lists.add(fd2);
		lists.add(fd3);
		lists.add(fd4);
		lists.add(fd5);
		lists.add(fd6);
		lists.add(fd7);
		lists.add(fd8);
		lists.add(fd9);
		return lists;
	}
	
	public static List<FoodDrink> getListFood(){
		ImageIcon icon1 = new ImageIcon("mixao.jpg");
		ImageIcon icon2 = new ImageIcon("phobo.jpg");
		ImageIcon icon3 = new ImageIcon("comchien.png");
		ImageIcon icon4 = new ImageIcon("banhtrangtron.jpg");
		ImageIcon icon5 = new ImageIcon("cavienchien.jpg");
		ImageIcon icon6 = new ImageIcon("khoaitaychien.jpg");
		ImageIcon icon7 = new ImageIcon("nuixao.jpg");
		ImageIcon icon8 = new ImageIcon("phomaique.jpg");
		Image img1 = icon1.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img2 = icon2.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img3 = icon3.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img4 = icon4.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img5 = icon5.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img6 = icon6.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img7 = icon7.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		Image img8 = icon8.getImage().getScaledInstance(80, 60,Image.SCALE_DEFAULT);
		icon1 = new ImageIcon(img1);
		icon2 = new ImageIcon(img2);
		icon3 = new ImageIcon(img3);
		icon4 = new ImageIcon(img4);
		icon5 = new ImageIcon(img5);
		icon6 = new ImageIcon(img6);
		icon7 = new ImageIcon(img7);
		icon8 = new ImageIcon(img8);
		FoodDrink fd1 = new FoodDrink(icon1, "Mì xào", "25000VND", new JButton("Chọn"));
		FoodDrink fd2 = new FoodDrink(icon2, "Phở bò", "30000VND", new JButton("Chọn"));
		FoodDrink fd3 = new FoodDrink(icon3, "Cơm chiên", "30000VND", new JButton("Chọn"));
		FoodDrink fd4 = new FoodDrink(icon4, "Bánh tráng trộn", "15000VND", new JButton("Chọn"));
		FoodDrink fd5 = new FoodDrink(icon5, "Cá viên chiên", "10000VND", new JButton("Chọn"));
		FoodDrink fd6 = new FoodDrink(icon6, "Khoai tây chiên", "10000VND", new JButton("Chọn"));
		FoodDrink fd7 = new FoodDrink(icon7, "Nui xào", "20000VND", new JButton("Chọn"));
		FoodDrink fd8 = new FoodDrink(icon8, "Phô mai que", "13000VND", new JButton("Chọn"));
		List<FoodDrink> lists = new ArrayList<>();
		lists.add(fd1);
		lists.add(fd2);
		lists.add(fd3);
		lists.add(fd4);
		lists.add(fd5);
		lists.add(fd6);
		lists.add(fd7);
		lists.add(fd8);
		return lists;
	}
}
