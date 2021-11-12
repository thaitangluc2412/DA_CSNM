package menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import chat.ChatClient;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	
	public void RunMenu() throws IOException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Menu frame = new Menu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 801, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JButton btnDrink = new JButton("\u0110\u1ED3 u\u1ED1ng");
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrameDrink jInternalFrameDrink = new JInternalFrameDrink();

				Dimension desktopSize = desktopPane.getSize();
				Dimension jInternalFrameSize = jInternalFrameDrink.getSize();
				jInternalFrameDrink.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
						(desktopSize.height - jInternalFrameSize.height) / 2 + 20);

				desktopPane.add(jInternalFrameDrink);
				jInternalFrameDrink.setVisible(true);
			}
		});
		btnDrink.setBounds(0, 0, 86, 28);
		desktopPane.add(btnDrink);

		JButton btnFood = new JButton("Th\u1EE9c \u0103n");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrameFood jInternalFrameFood = new JInternalFrameFood();

				Dimension desktopSize = desktopPane.getSize();
				Dimension jInternalFrameSize = jInternalFrameFood.getSize();
				jInternalFrameFood.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
						(desktopSize.height - jInternalFrameSize.height) / 2 + 20);
				desktopPane.add(jInternalFrameFood);
				jInternalFrameFood.setVisible(true);
			}
		});
		btnFood.setBounds(83, 0, 86, 28);
		desktopPane.add(btnFood);
	}
}
