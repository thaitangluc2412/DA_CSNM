package time;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TimeClient {
	static DataOutputStream dos;
	static DataInputStream din;

	public static void main(String[] args) throws IOException {
		Socket sk = new Socket("localhost", 7977);

		Thread tRead = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					din = new DataInputStream(sk.getInputStream());
					while (true) {
						if (sk != null) {
							String time = din.readUTF();
							System.out.println(time);
						}
						Thread.sleep(1000);
					}
				} catch (Exception e) {
				}

			}
		});
		tRead.start();

	}
}
