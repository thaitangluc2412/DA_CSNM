package time;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import callback.Callback;

public class TimeThread extends Thread {
	private Callback listener;
	LocalTime timeStart;

	public TimeThread(Callback listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		timeStart = LocalTime.now();
		int n = 1;
		while (n < 1000) {
			n++;
			LocalTime timeEnd = LocalTime.now();
			Duration duration = Duration.between(timeStart, timeEnd);
			int hours = (int) duration.toHours();
			int minutes = (int) duration.toMinutes() - hours * 60;
			int seconds = (int) duration.toSeconds() - minutes * 60 - hours * 60;
			String time = hours + "h " + minutes + "m " + seconds + "s";
			String money = CalMoney(time);
			listener.onSecond(time, money);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	public static String CalMoney(String time) {
		String[] timeMoney = time.split("\\s");
		int hours = Integer.parseInt(timeMoney[0].replace(timeMoney[0].substring(timeMoney[0].length() - 1), ""));
		int minutes = Integer.parseInt(timeMoney[1].replace(timeMoney[1].substring(timeMoney[1].length() - 1), ""));
		int seconds = Integer.parseInt(timeMoney[2].replace(timeMoney[2].substring(timeMoney[2].length() - 1), ""));
		int totalSeconds = hours * 60 * 60 + minutes * 60 + seconds;
		return (int) totalSeconds * 10 / 3 + " VND";
	}

}
