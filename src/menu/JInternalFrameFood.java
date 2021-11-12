package menu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import giaodien.InterfaceClient;

public class JInternalFrameFood extends JInternalFrame {
	DataOutputStream dos;
	Socket sk = InterfaceClient.sk;
	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalFrameFood frame = new JInternalFrameFood();
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
	public JInternalFrameFood() {
		setClosable(true);
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
		btnChon.setBounds(520, 11, 134, 40);
		contentPane.add(btnChon);
		btnTên.setBounds(360, 11, 145, 40);
		contentPane.add(btnTên);

		JButton btnGia = new JButton("Tên nước uống");
		btnGia.setBounds(196, 11, 145, 40);
		contentPane.add(btnGia);
		btnGia_1.setBounds(20, 11, 156, 40);
		contentPane.add(btnGia_1);
		// scrollPane.setColumnHeaderView(table);
		table.setFont(new Font("Serif", Font.BOLD, 20));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(UIManager.getColor("Button.disabledForeground"));
		scrollPane.setBounds(20, 48, 656, 365);
		contentPane.add(scrollPane);
	}
	
	private void loadData() {
		List<FoodDrink> lists = Utils.getListFood();
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
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
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
				if (!source.isRowSelected(row))
					source.changeSelection(row, column, false, false);
				if (column==3) {
					
					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								System.out.println(table.getValueAt(row, 1).toString());
								dos = new DataOutputStream(sk.getOutputStream());
								dos.writeUTF(table.getValueAt(row, 1).toString() + "-" + table.getValueAt(row, 2).toString() + "button");
								dos.flush();
//								model.addElement("Bàn số " + count + ": "+ txtMessage.getText());
//								lsHistory.setModel(model);
//								txtMessage.setText("");
							} catch (Exception e2) {

							}

						}
					});
					t.start();
				}
				
			}
		});
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
	}

}
