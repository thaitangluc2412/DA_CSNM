package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Dimension;

public class aaaa extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaaa frame = new aaaa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public aaaa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(100, 100, 200, 200);
		DefaultTableModel model = new DefaultTableModel();
		for(int i =0; i<10; i++) {
			model.addColumn(" ");
		}
		for(int i =0; i<10; i++) {
			model.addRow(new Object[] {" ", " ", " ", " "," "," "," "," "," "," "});
		}
		for(int i =0; i<10; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		
		table.setModel(model);
		
		contentPane.add(table);
		
	}
}
