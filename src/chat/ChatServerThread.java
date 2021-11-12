package chat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import callback.Callback;
import time.TimeThread;
import javax.swing.JScrollPane;

public class ChatServerThread extends Thread{
	
	private DefaultListModel<String> model;
	private JPanel contentPane;
	private JList<String> lsHistory = new JList<>();
	private JTextPane txtMessage;
	private JButton btnSend;
	JFrame jframe ;
	//private static ServerSocket svsocket;
	private Integer moneyButton = 0;
	private int count;
	private Socket socket = null;
	private  DataInputStream din = null;
	private  DataOutputStream dos = null;
	
	public ChatServerThread(Socket socket, int count) {
		this.count = count;
		this.socket = socket;
	}
	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	@Override
	public void run() {
		try {
			dos = new DataOutputStream(this.socket.getOutputStream());
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("ko nhan socket");
		}
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Innit();
	}
	
	

//	public static void main(String[] args) throws IOException {
//		
//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Start();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		t1.start();
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChatServer frame = new ChatServer();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}

	/**
	 * Chat
	 * 
	 * @return
	 * @throws IOException
	 */

	public void Start() throws IOException {
		model = new DefaultListModel<>();
		model.addElement("Server Connecting ... !!");
		lsHistory.setModel(model);
		model.addElement("Server is connected...!!");
		lsHistory.setModel(model);
		try {						
			dos.writeUTF(count + "number");
//			System.out.println("server ---> "+time);
//			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Callback listener = new Callback() {
			@Override
			public void onSecond(String time, String money) {
//				System.out.println("time = " + time);
//				System.out.println("money = " + money);
				String totalMoney = (moneyButton + Integer.parseInt(money.replace(money.substring(money.length() - 4), ""))) + " VND";
				Thread tTime = new Thread(new Runnable() {
					@Override
					public void run() {
						try {						
							dos.writeUTF(time + "time");
							dos.writeUTF(totalMoney + "money");
//							System.out.println("server ---> "+time);
//							dos.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				});
				tTime.start();

//				Thread tMoney = new Thread(new Runnable() {
//					@Override
//					public void run() {
//						try {
////							dos = new DataOutputStream(socket.getOutputStream());
//							dos.writeUTF(money + "money");
////							System.out.println("server ---> "+money);
//							dos.flush();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				});
//				tMoney.start();
//				if (svsocket.isClosed()) {
//					tTime.stop();
//					tMoney.stop();
//
//				}
			}
		};

		TimeThread t2 = new TimeThread(listener);
		t2.start();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					din = new DataInputStream(socket.getInputStream());
					while (true) {
						String msg = din.readUTF();
						System.out.println(msg);
						if (!msg.endsWith("button")) {
							jframe.setVisible(true);
							model.addElement("Bàn số " + count + ": " + msg);
							lsHistory.setModel(model);
						} else {
							String[] msgs = msg.split("-");
							moneyButton += Integer.parseInt(msgs[1].replace(msgs[1].substring(msgs[1].length() - 9), ""));
							//System.out.println(moneyButton);
							ImageIcon icon = new ImageIcon("turtle.png");
							
							JOptionPane.showMessageDialog(null, "Bàn số " + count + " yêu cầu 1 " + msgs[0],"Dịch vụ" ,JOptionPane.INFORMATION_MESSAGE,icon);
//							final JOptionPane pane = new JOptionPane("Hello");
//						    final JDialog d = pane.createDialog((JFrame)null, "Title");
//						    d.setLocation(10,10);
//						    d.setVisible(true);
						}
						
						Thread.sleep(1000);
					}

				} catch (Exception e) {
				}
			}
		});
		t.start();
	}

	/**
	 * Create the frame.
	 */
	public void Innit() {
		jframe = new JFrame();
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(100, 100, 724, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//jframe.setContentPane(contentPane);
		contentPane.setLayout(null);

		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent exit) {
//				try {
//					svsocket.close();
					System.out.println("da dong");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}

		});

		JLabel lblServer = new JLabel("Server");
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServer.setBounds(20, 10, 86, 28);
		contentPane.add(lblServer);

		btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					dos = new DataOutputStream(socket.getOutputStream());
					dos.writeUTF(txtMessage.getText());
					dos.flush();
					model.addElement("Máy chủ: " + txtMessage.getText());
					lsHistory.setModel(model);
					txtMessage.setText("");
				} catch (Exception e2) {

				}
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 48, 680, 275);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(lsHistory);

		lsHistory.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		jframe.setContentPane(contentPane);
		
	}
}
