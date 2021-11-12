package chat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import giaodien.InterfaceClient;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ChatClient extends JFrame {
	// static Socket sk;

	Socket sk = InterfaceClient.sk;
//	static DataInputStream din = InterfaceClient.din;
	// static DataInputStream din;
	DataOutputStream dos;
	private static DefaultListModel<String> model;
	
	private static String count;
	private JPanel contentPane;
	public static JList<String> lsHistory = new JList<>();;
	private JTextPane txtMessage;
	private JButton btnSend;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */

	public void RunChat(String count) throws IOException {
		this.count = count;
		System.out.println("count: " + this.count);
		Start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Chat
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void Start() throws IOException {
		model = new DefaultListModel<>();
		model.addElement("Client is Connecting ... !!");
		lsHistory.setModel(model);
		// sk = new Socket("localhost", 8848);
		model.addElement("Client is connected...!!");
		lsHistory.setModel(model);
//		Thread t= new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					while (true) {
//						//if (sk != null) {
//							System.out.println("waiting ......");
//						//	String stringServer = din.readUTF();
//						//	System.out.println("server ---> "+stringServer);		
//								model.addElement("Server: " + receiveChatServer());
//								lsHistory.setModel(model);
//						//	}		
//						Thread.sleep(1000);
//					}
//					
//				} catch (Exception e) {
//				}
//				
//			}
//		});
//		t.start();
	}

	/**
	 * Create the frame.
	 */
	public ChatClient() {
		 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		// this.din = din;
		setBounds(100, 100, 724, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbClient = new JLabel("Client");
		lbClient.setHorizontalAlignment(SwingConstants.CENTER);
		lbClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbClient.setBounds(20, 10, 82, 28);
		contentPane.add(lbClient);

		btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							dos = new DataOutputStream(sk.getOutputStream());
							dos.writeUTF(txtMessage.getText());
							dos.flush();
							model.addElement("Bàn số " + count + ": "+ txtMessage.getText());
							lsHistory.setModel(model);
							txtMessage.setText("");
						} catch (Exception e2) {

						}

					}
				});
				t.start();
			}
		});
		btnSend.setBorder(new LineBorder(Color.BLUE));
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSend.setBounds(595, 333, 100, 64);
		contentPane.add(btnSend);

		txtMessage = new JTextPane();
		txtMessage.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		txtMessage.setBounds(20, 333, 562, 65);
		contentPane.add(txtMessage);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 48, 680, 275);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(lsHistory);
		
		lsHistory.setBorder(new LineBorder(new Color(30, 144, 255), 2));
	}

	public void getJavaProject2_28() {
		contentPane.setVisible(true);
	}

	public static void chatServer(String str) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					//System.out.println("waiting ......");
					model.addElement("Máy chủ: " + str);
					lsHistory.setModel(model);
					Thread.sleep(1000);

				} catch (Exception e) {
				}

			}
		});
		t.start();
	}

	public static boolean timeMoney(String str) {
		if (str.endsWith("time") || str.endsWith("money"))
			return false;
		return true;
	}

}
