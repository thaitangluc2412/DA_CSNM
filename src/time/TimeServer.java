package time;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TimeServer {
	private static Scanner ip = new Scanner(System.in);
	static Socket sk;
	static DataInputStream din;
	static DataOutputStream dos;
	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket svsk = new ServerSocket(7977);
		System.out.println("Server is started");
		LocalTime timeStart;
		sk = svsk.accept();
		
		timeStart = LocalTime.now();
		Thread tWrite = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					dos = new DataOutputStream(sk.getOutputStream());
					int n = 1;
					while (n < 1000) {
						n++;
						LocalTime timeEnd = LocalTime.now();
						Duration duration = Duration.between(timeStart, timeEnd);
						int hours = (int) duration.toHours();
						int minutes = (int) duration.toMinutes() - hours*60;
						int seconds = (int) duration.toSeconds() - minutes*60 - hours*60;
						String time = hours + "h " + minutes + "m " + seconds + "s";
						System.out.println(time);
						dos.writeUTF(time);
						dos.flush();
						TimeUnit.SECONDS.sleep(1);
					}
					System.out.println("Server is closed");
					svsk.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		tWrite.start();
		
	
	}
	
	
	
}
