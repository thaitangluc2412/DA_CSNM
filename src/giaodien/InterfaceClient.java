package giaodien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import chat.ChatClient;
import menu.Menu;

import java.awt.SystemColor;

public class InterfaceClient extends JFrame {
	private ChatClient frameChatClient = null;
	static DataOutputStream dos;
//	public static DataInputStream din = new DataInputStream(sk.getInputStream());
	public DataInputStream din;
	public static Socket sk;

	private static String count;
	static JLabel lblNumber;
	static JLabel lbTinhGio;
	static JLabel lbTinhTien;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
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
					InterfaceClient frame = new InterfaceClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public InterfaceClient() throws UnknownHostException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bàn số 1");
		setBounds(1100, 100, 393, 339);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbNameTable = new JLabel("Bàn Số  ", SwingConstants.CENTER);
		lbNameTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbNameTable.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		lbNameTable.setBounds(117, 11, 121, 58);
		contentPane.add(lbNameTable);

		JLabel lbSoTien = new JLabel("Số tiền:", SwingConstants.CENTER);
		lbSoTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbSoTien.setBounds(152, 139, 86, 40);
		contentPane.add(lbSoTien);

		JLabel lbSoGio = new JLabel("Số giờ:", SwingConstants.CENTER);
		lbSoGio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbSoGio.setBounds(152, 80, 82, 40);
		contentPane.add(lbSoGio);

		lbTinhGio = new JLabel("", SwingConstants.CENTER);
		lbTinhGio.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lbTinhGio.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbTinhGio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTinhGio.setBounds(231, 85, 131, 31);
		contentPane.add(lbTinhGio);

		lbTinhTien = new JLabel("", SwingConstants.CENTER);
		lbTinhTien.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lbTinhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTinhTien.setBounds(231, 145, 131, 29);
		contentPane.add(lbTinhTien);
		Thread time = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Time();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		time.start();
		JButton btnDichVu = new JButton("Dịch Vụ");
		buttonGroup.add(btnDichVu);
		btnDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						boolean onOff = false;
						if (!onOff) {
							Menu menu = new Menu();
							try {
								menu.RunMenu();
							} catch (IOException e) {
								e.printStackTrace();
							}
							onOff = true;
						}
						
					}
				});
				t.start();
			}
		});
		btnDichVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDichVu.setFocusPainted(false);
		btnDichVu.setBounds(23, 92, 104, 34);
		contentPane.add(btnDichVu);

		JButton btnNhanTin = new JButton("Nhắn tin");
		btnNhanTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						frameChatClient = new ChatClient();
						try {
							frameChatClient.RunChat(count);
						} catch (IOException e) {
							e.printStackTrace();
						}
						// frame.setVisible(true);
					}
				});
				t.start();
			}
		});
		btnNhanTin.setFocusPainted(false);
		buttonGroup.add(btnNhanTin);
		btnNhanTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanTin.setBounds(23, 143, 104, 34);
		contentPane.add(btnNhanTin);

		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDangXuat.setFocusPainted(false);
		buttonGroup.add(btnDangXuat);
		btnDangXuat.setBounds(23, 198, 104, 34);
		contentPane.add(btnDangXuat);

		lblNumber = new JLabel("");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNumber.setBounds(215, 11, 13, 58);
		contentPane.add(lblNumber);
	}

	public void Time() throws UnknownHostException, IOException {
		sk = new Socket("localhost", 1819);
		System.out.println("start time");
		din = new DataInputStream(sk.getInputStream());
		String number = din.readUTF();
		if (number.endsWith("number")) {
			this.count = (number.replace(number.substring(number.length() - 6), ""));
			lblNumber.setText(number.replace(number.substring(number.length() - 6), ""));
		}
		Thread tReadTime = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					try {
						din = new DataInputStream(sk.getInputStream());
					} catch (Exception e) {
						System.out.println("loi din");
					}
					while (true) {
						// System.out.println("waiting....");
						String timeMoney = din.readUTF();
						// System.out.println("server(from client) ----> " + timeMoney);
						if (timeMoney.endsWith("time")) {
							System.out.println(timeMoney);
							lbTinhGio.setText(timeMoney.replace(timeMoney.substring(timeMoney.length() - 4), ""));
						} else if (timeMoney.endsWith("money")) {
							lbTinhTien.setText(timeMoney.replace(timeMoney.substring(timeMoney.length() - 5), ""));
						} else {
							frameChatClient.chatServer(timeMoney);
						}
					}
				} catch (Exception e) {
					System.out.println("error : " + e.getMessage());
				}
				// loi o client

			}
		});
		tReadTime.start();
	}
}
