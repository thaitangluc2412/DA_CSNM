package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class Drink extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drink frame = new Drink();
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
	public Drink() {
		setBackground(UIManager.getColor("CheckBox.highlight"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 460);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// this.getContentPane().setBackground(new Color(ABORT));
		table = new JTable();
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		loadData();

		JButton btnGia_1 = new JButton("Ảnh");
		btnGia_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnTên = new JButton("Giá");
		btnTên.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnChon = new JButton("Chọn");
		btnChon.setBounds(512, 11, 164, 40);
		contentPane.add(btnChon);
		btnTên.setBounds(352, 11, 164, 40);
		contentPane.add(btnTên);

		JButton btnGia = new JButton("Tên");
		btnGia.setBounds(185, 11, 164, 40);
		contentPane.add(btnGia);
		btnGia_1.setBounds(20, 11, 164, 40);
		contentPane.add(btnGia_1);
		// scrollPane.setColumnHeaderView(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(UIManager.getColor("Button.disabledForeground"));
		scrollPane.setBounds(20, 48, 656, 365);
		contentPane.add(scrollPane);
	}

	private void loadData() {
		List<FoodDrink> lists = Utils.getList();
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return ImageIcon.class;
				default:
					return String.class;
				}
			}
		};
		model.addColumn("");
		model.addColumn("");
		model.addColumn("");
		model.addColumn("");
		for (FoodDrink fd : lists) {
			model.addRow(new Object[] { fd.getImage(), fd.getName(), fd.getPrice(), "Chọn" });
		}
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		// table.getColumnModel().getColumn(3).setPreferredWidth(20);

		table.setRowHeight(120);
		// SET CUSTOM RENDERER TO TEAMS COLUMN
		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

		// SET CUSTOM EDITOR TO TEAMS COLUMN

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTable source = (JTable) e.getSource();
				int row = source.rowAtPoint(e.getPoint());
				int column = source.columnAtPoint(e.getPoint());
				System.out.println(row + " " + column);
				if (!source.isRowSelected(row))
					source.changeSelection(row, column, false, false);
			}
		});
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
	}

	public JPanel panel() {
		JPanel p = new JPanel();
		JButton b = new JButton("button1");
		JButton b1 = new JButton("button2");
		p.add(b1);
		p.add(b);
		return p;
	}
}
